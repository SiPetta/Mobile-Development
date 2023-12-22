package com.dicoding.sipetta.view.plant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dicoding.sipetta.R
import com.dicoding.sipetta.ViewModelFactory
import com.dicoding.sipetta.data.api.ApiConfig
import com.dicoding.sipetta.data.pref.UserPreference
import com.dicoding.sipetta.data.pref.dataStore
import com.dicoding.sipetta.view.home.HomeActivity
import com.dicoding.sipetta.view.post.NotesActivity
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class BawangActivity : AppCompatActivity() {

    private lateinit var viewModel: PlantViewModel
    private lateinit var questionTextView: TextView
    private lateinit var receivedToken: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bawang_q1)

        questionTextView = findViewById(R.id.bawangq1)
        val nextButton: Button = findViewById(R.id.buttonNextB1)
        nextButton.setOnClickListener {
            viewModel.showNextQuestion()
            displayCurrentQuestion()
        }

        receivedToken = intent.getStringExtra("TOKEN") ?: ""

        initializeViewModel()
        observeQuestions()

        viewModel.questions.observe(this) { questions ->
            if (viewModel.currentQuestionIndex < questions.size) {
                val options = questions[viewModel.currentQuestionIndex].options
                val indicatorCodes = questions[viewModel.currentQuestionIndex].indicatorCodes
                displayOptions(options, indicatorCodes)
            } else {
                navigateToHome()
            }
        }
    }

    private fun initializeViewModel() {
        val userPreference = UserPreference.getInstance(this.dataStore)
        viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this, ApiConfig.getApiService()))[PlantViewModel::class.java]

        lifecycle.addObserver(viewModel)

        if (receivedToken.isNotEmpty()) {
            val agricode = intent.getStringExtra("CATEGORY_CODE") ?: ""
            viewModel.init(receivedToken, agricode)
        } else {
            lifecycleScope.launch {
                val userModel = userPreference.getSession().firstOrNull()
                val token = userModel?.token ?: ""

                val agricodeResponse = ApiConfig.getApiService().getListFarm(token, "")
                val agricode = agricodeResponse.data?.firstOrNull()?.fvAgricode ?: ""

                viewModel.init(token, agricode)
            }
        }
    }

    private fun observeQuestions() {
        viewModel.questions.observe(this) { questions ->
            if (viewModel.currentQuestionIndex < questions.size) {
                val question = questions[viewModel.currentQuestionIndex].question
                questionTextView.text = question
            } else {
                navigateToHome()
            }
        }
    }

    private fun displayCurrentQuestion() {
        val questions = viewModel.questions.value ?: emptyList()
        if (viewModel.currentQuestionIndex < questions.size) {
            val question = questions[viewModel.currentQuestionIndex].question
            val options = questions[viewModel.currentQuestionIndex].options
            val indicatorCodes = questions[viewModel.currentQuestionIndex].indicatorCodes
            questionTextView.text = question
            displayOptions(options, indicatorCodes)
        } else {
            navigateToNotesActivity()
        }
    }

    private fun navigateToNotesActivity() {
        val intent = Intent(this, NotesActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun displayOptions(options: List<String>, indicatorCodes: List<String>) {
        val checkboxContainer: LinearLayout = findViewById(R.id.checkboxContainer)
        checkboxContainer.removeAllViews()

        val selectedOptions = mutableListOf<String>()

        options.forEachIndexed { index, option ->
            val checkBox = CheckBox(this)
            checkBox.text = option
            checkBox.id = index
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedOptions.add(option)
                } else {
                    selectedOptions.remove(option)
                }
            }
            checkboxContainer.addView(checkBox)
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
