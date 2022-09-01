package com.iei.dotshop.domain

import com.iei.dotshop.data.ErrorResponse
import com.iei.dotshop.data.remote.BaseCommonResponse
import com.iei.dotshop.data.remote.NetworkResponse
import com.iei.dotshop.utils.Resource

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Mahmoud Ayman on 12/8/2021.
 */
abstract class BaseCommonUseCase<RequestType : BaseCommonResponse, ResultType : Any, in Params> {
    //map class from response to the result needed in View
    abstract fun mapper(req: RequestType): ResultType

    //run the remote api
    abstract fun executeRemote(
        params: Params?
    ): Flow<NetworkResponse<RequestType, ErrorResponse>>

    fun handler(onResult: (Resource<ResultType>) -> Unit) =
        CoroutineExceptionHandler { _, exception ->
            onResult.invoke(Resource.loading(false))
            showFailureMessage(onResult, exception.message ?: exception.toString())
        }

    fun <T> runFlow(resFlow: Flow<T>, onResult: (Resource<ResultType>) -> Unit): Flow<T> {
        return resFlow.catch { e ->
            showFailureMessage(onResult, e.cause?.toString() ?: e.toString())
        }.flowOn(Dispatchers.IO)
    }

    fun showFailureMessage(onResult: (Resource<ResultType>) -> Unit, message: String?) {
        onResult.invoke(Resource.loading(false))
        onResult.invoke(Resource.failure(message))
      //  message.showLogMessage()
    }
}
