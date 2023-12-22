package com.dicoding.sipetta.data

import com.dicoding.sipetta.data.api.ApiService
import com.dicoding.sipetta.data.api.DetailUserResponse
import com.dicoding.sipetta.data.api.LoginResponse
import com.dicoding.sipetta.data.api.SignUpResponse
import com.dicoding.sipetta.data.pref.UserModel
import com.dicoding.sipetta.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class UserRepository private constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {

    suspend fun register(name: String, email: String, password: String): SignUpResponse {
        return apiService.register(name, email, password)
    }

    suspend fun login(email: String, password: String): LoginResponse {
        return apiService.login(email, password)
    }

    suspend fun getDetailUser(token: String): DetailUserResponse {
        return apiService.getDetailUser("Bearer $token")
    }

    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference, apiService)
            }.also { instance = it }
    }
}