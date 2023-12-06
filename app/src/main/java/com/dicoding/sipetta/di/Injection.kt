package com.dicoding.sipetta.di

import android.content.Context
import com.dicoding.sipetta.data.UserRepository
import com.dicoding.sipetta.data.api.ApiService
import com.dicoding.sipetta.data.pref.UserPreference
import com.dicoding.sipetta.data.pref.dataStore

object Injection {
    fun provideUserRepository(context: Context, apiService: ApiService): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref, apiService)
    }
}
