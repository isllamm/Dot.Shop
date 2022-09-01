package com.iei.dotshop.ui.fragments.login

import android.app.Application
import android.provider.Settings.Global.getString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iei.dotshop.BaseViewModel
import com.iei.dotshop.BuildConfig
import com.iei.dotshop.R
import com.iei.dotshop.data.pojo.LoginResponse
import com.iei.dotshop.data.remote.BaseResponse
import com.iei.dotshop.data.remote.ServerStatusCodes
import com.iei.dotshop.domain.LoginParams
import com.iei.dotshop.domain.LoginUseCase
import com.iei.dotshop.utils.Extension
import com.iei.dotshop.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel@Inject constructor( app: Application)    :BaseViewModel<LoginAction>(app)  {

//@Inject constructor(app: Application, val loginUseCase: LoginUseCase)
var email =""
    var pass=""

    fun onLoginClick() {
        if (isValidParams()) {
         login()
        }
    }

    private fun isValidParams(): Boolean {
        if (BuildConfig.DEBUG) {
            return true
        }
        return if (email.isNullOrBlank()) {
           produce(LoginAction.ShowFailureMsg(getString(R.string.msg_empty_email)))
            false
        } else if (!Extension.isEmailValid(email)) {
            produce(LoginAction.ShowFailureMsg(getString(R.string.msg_invalide_email)))
            false
        } else if (pass.isNullOrBlank()) {
            produce(LoginAction.ShowFailureMsg(getString(R.string.msg_empty_new_password)))
            false
        } else true

    }
    private fun login() {
      /*  loginUseCase.invoke(viewModelScope, LoginParams(email,pass)) { res ->
            when (res) {
                is Resource.Failure -> produce(LoginAction.ShowFailureMsg(res.message))
                is Resource.Progress -> produce(LoginAction.ShowLoading(res.loading))
                is Resource.Success -> handleLoginSuccess(res.data)
            }
        }*/
    }



     private fun handleLoginSuccess(response: BaseResponse<LoginResponse>) {
       when (response.status) {
           ServerStatusCodes.SUCCESS.code -> {
               loginSuccess(response.data!!)
           }
           ServerStatusCodes.SOCIAL_REGISTER.code -> {// social media register now
               produce(LoginAction.ShowFailureMsg(getString(R.string.please_complete_data)))
               produce(LoginAction.ContinueUserData)
           }
       }

}


    private fun loginSuccess(data: LoginResponse) {
        produce(LoginAction.LoginSuccess)
        /*if (obsRememberMe.get() == true)
            sessionManager.writePrefObject(
                PreferenceKeys.PREF_LOGIN_DATA,
                params,
                viewModelScope
            )*/
      //  sessionManager.setPrefUserData(data, viewModelScope) {
              //  sessionManager.setToken(data.jwtToken, viewModelScope) {
                        }
                   }