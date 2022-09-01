package com.iei.dotshop.domain

import com.iei.dotshop.data.remote.BaseCommonResponse
import com.iei.dotshop.data.remote.NetworkResponse
import com.iei.dotshop.data.remote.ServerStatusCodes
import com.iei.dotshop.utils.Resource

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

/**
- Acts as a contract for all the use cases in our application:
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means that any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.

 * @param RequestType: a return type which is the result of the *Network Execution*.
 * @param Params: a parameters class which will be consumed inside the [invoke] function
in case we need extra data for our use case.
 * @param ResultType: the result returned after mapping the response to to the *View*
 */
abstract class BaseUseCase<RequestType : BaseCommonResponse, ResultType : Any, in Params> :
    BaseCommonUseCase<RequestType, ResultType, Params>() {
    fun invoke(
        scope: CoroutineScope,
        params: Params? = null,
        onResult: (Resource<ResultType>) -> Unit = {}
    ) {
        scope.launch(handler(onResult) + Dispatchers.Main) {
            onResult.invoke(Resource.loading())
            runFlow(executeRemote(params), onResult).collect {

                when (it) {
                    is NetworkResponse.Success -> {
                        if (it.body.status == ServerStatusCodes.SUCCESS.code
                            || it.body.status == ServerStatusCodes.SOCIAL_REGISTER.code
                        ) {
                            val res = mapper(it.body)
                            onResult.invoke(Resource.success(res))
                        } else {
                            showFailureMessage(onResult, it.body.message)
                        }
                    }
                    is NetworkResponse.NetworkError -> showFailureMessage(
                        onResult,
                        it.error.message
                    )
                    is NetworkResponse.ServerError -> showFailureMessage(onResult, it.body?.message)
                    is NetworkResponse.UnknownError -> showFailureMessage(
                        onResult,
                        it.error.toString()
                    )
                }
                onResult.invoke(Resource.loading(false))
            }

            }
        }
    }
