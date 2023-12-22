package com.dicoding.sipetta.view.plant

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.sipetta.data.FarmRepository
import com.dicoding.sipetta.data.pref.Question
import kotlinx.coroutines.launch

class PlantViewModel(private val farmRepository: FarmRepository) : ViewModel(), LifecycleObserver {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> get() = _questions

    var currentQuestionIndex = 0

    fun init(token: String, agricode: String) {
        viewModelScope.launch {
            val retrievedQuestions = farmRepository.getQuestionsAndAnswersWithOptions(token, agricode)
            _questions.value = retrievedQuestions
        }
    }

    fun showNextQuestion() {
        currentQuestionIndex++
    }
}