package com.iei.dotshop.ui.fragments.login

import com.iei.dotshop.Action


sealed class LoginAction : Action {
    object LoginSuccess : LoginAction()
    object OnForgotClicked : LoginAction()
    object OnRegisterClicked : LoginAction()
    object GoogleClicked : LoginAction()
    object FacebookClicked : LoginAction()
    object ContinueUserData : LoginAction()
    data class ShowLoading(val show: Boolean) : LoginAction()
    data class ShowFailureMsg(val message: String?) : LoginAction()
}
