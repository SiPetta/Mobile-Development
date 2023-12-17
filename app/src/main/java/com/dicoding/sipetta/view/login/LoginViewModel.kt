package com.dicoding.sipetta.view.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.sipetta.data.UserRepository
import com.dicoding.sipetta.data.api.LoginResponse
import com.dicoding.sipetta.data.pref.UserModel
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(private val repository: UserRepository) : ViewModel() {

    val loginResult = MutableLiveData<LoginResponse>()
    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                val loginResponse = repository.login(email, password)
                loginResult.value = loginResponse
                handleLoginResponse(loginResponse)
            } catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
                loginResult.value = errorResponse
                Log.e("LoginError", "Login failed", e)
            }
        }
    }

    private fun handleLoginResponse(response: LoginResponse) {
        if (response.error == false && response.status == 200) {
            val accessToken = response.accessToken
            Log.d("AccessToken", "Token: $accessToken")
        } else {
            val errorMessage = response.message ?: "Login failed. Unknown error."
            Log.e("LoginError", "Error: $errorMessage")
        }
    }
}