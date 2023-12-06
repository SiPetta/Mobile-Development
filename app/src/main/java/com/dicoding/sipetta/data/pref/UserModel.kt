package com.dicoding.sipetta.data.pref

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)