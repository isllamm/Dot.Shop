package com.iei.dotshop.domain


import com.iei.dotshop.data.ErrorResponse
import com.iei.dotshop.data.pojo.LoginResponse
import com.iei.dotshop.data.pojo.UserInfoModel
import com.iei.dotshop.data.remote.BaseResponse
import com.iei.dotshop.data.remote.NetworkResponse
import com.iei.dotshop.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase{

} /*@Inject constructor(private val authRepository: Repository):
    BaseUseCase<BaseResponse<LoginResponse>, BaseResponse<LoginResponse>, LoginParams>() {
    override fun mapper(req: BaseResponse<LoginResponse>):BaseResponse< LoginResponse> = req

    override fun executeRemote(params: LoginParams?): Flow<NetworkResponse<BaseResponse<LoginResponse>, ErrorResponse>> =
        flow {
            params?.email?.let { params.password?.let { it1 -> authRepository.login(it, it1) } }?.let { emit(it) }
        }

}*/