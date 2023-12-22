package com.dicoding.sipetta.view.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.sipetta.data.UserRepository
import com.dicoding.sipetta.data.api.DetailUserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _userDetail = MutableLiveData<DetailUserResponse>()
    val userDetail: LiveData<DetailUserResponse> = _userDetail

    private val _isLoading = MutableLiveData<Boolean>()

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchUserDetail(token: String) {
        _isLoading.value = true
        Log.d("ProfileViewModel", "fetchUserDetail called with token: $token")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val detailResponse = userRepository.getDetailUser(token)
                if (detailResponse.error == false) {
                    _userDetail.postValue(detailResponse)
                    _isLoading.postValue(false)
                } else {
                    _isLoading.postValue(false)
                    _error.postValue("Error occurred while fetching user data")
                }
            } catch (e: Exception) {
                _isLoading.postValue(false)
                _error.postValue(e.message ?: "Unknown error")
            }
        }
    }
}
