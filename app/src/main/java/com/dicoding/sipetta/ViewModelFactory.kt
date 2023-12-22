package com.dicoding.sipetta

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.sipetta.data.FarmRepository
import com.dicoding.sipetta.data.UserRepository
import com.dicoding.sipetta.data.api.ApiService
import com.dicoding.sipetta.di.Injection
import com.dicoding.sipetta.view.fragment.ProfileViewModel
import com.dicoding.sipetta.view.login.LoginViewModel
import com.dicoding.sipetta.view.main.MainViewModel
import com.dicoding.sipetta.view.plant.PlantViewModel
import com.dicoding.sipetta.view.post.CategoryViewModel
import com.dicoding.sipetta.view.signup.SignUpViewModel

class ViewModelFactory(
    private val userRepository: UserRepository,
    private val farmRepository: FarmRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SignUpViewModel::class.java) -> {
                SignUpViewModel(userRepository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(userRepository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(userRepository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(userRepository) as T
            }
            modelClass.isAssignableFrom(PlantViewModel::class.java) -> {
                PlantViewModel(farmRepository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                CategoryViewModel(farmRepository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context, apiService: ApiService): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(
                        Injection.provideUserRepository(context, apiService),
                        Injection.provideFarmRepository(apiService)
                    )
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}
