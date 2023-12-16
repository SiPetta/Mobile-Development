package com.dicoding.sipetta.view.plant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.sipetta.R
import com.dicoding.sipetta.view.home.HomeActivity

class SawiActivity : AppCompatActivity() {
    private var currentLayoutIndex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sawi_q1)

        val nextButton: Button = findViewById(R.id.buttonNextSW1)
        nextButton.setOnClickListener {
            navigateToNextQuestion()
        }
    }

    private fun navigateToNextQuestion() {
        when (currentLayoutIndex) {
            1 -> {
                setContentView(R.layout.sawi_q2)
                val nextButton: Button = findViewById(R.id.buttonNextSW2)
                nextButton.setOnClickListener {
                    navigateToNextQuestion()
                }
                currentLayoutIndex = 2
            }
            2 -> {
                setContentView(R.layout.sawi_q4)
                val nextButton: Button = findViewById(R.id.buttonNextSW4)
                nextButton.setOnClickListener {
                    navigateToNextQuestion()
                }
                currentLayoutIndex = 3
            }
            3 -> {
                setContentView(R.layout.sawi_q5)
                val nextButton: Button = findViewById(R.id.buttonNextSW5)
                nextButton.setOnClickListener {
                    navigateToNextQuestion()
                }
                currentLayoutIndex = 4
            }
            4 -> {
                setContentView(R.layout.add_notes)
                val nextButton: Button = findViewById(R.id.buttonSubmit)
                nextButton.setOnClickListener {
                    navigateToHome()
                }
                currentLayoutIndex = 4
            }
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}