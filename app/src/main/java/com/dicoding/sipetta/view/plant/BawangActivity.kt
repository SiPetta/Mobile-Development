package com.dicoding.sipetta.view.plant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.sipetta.R
import com.dicoding.sipetta.view.home.HomeActivity

class BawangActivity : AppCompatActivity() {
    private var currentLayoutIndex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bawang_q1)

        val nextButton: Button = findViewById(R.id.buttonNextB1)
        nextButton.setOnClickListener {
            navigateToNextQuestion()
        }
    }

    private fun navigateToNextQuestion() {
        when (currentLayoutIndex) {
            1 -> {
                setContentView(R.layout.bawang_q2)
                val nextButton: Button = findViewById(R.id.buttonNextB2)
                nextButton.setOnClickListener {
                    navigateToNextQuestion()
                }
                currentLayoutIndex = 2
            }
            2 -> {
                setContentView(R.layout.bawang_q3)
                val nextButton: Button = findViewById(R.id.buttonNextB3)
                nextButton.setOnClickListener {
                    navigateToNextQuestion()
                }
                currentLayoutIndex = 3
            }
            3 -> {
                setContentView(R.layout.bawang_q4)
                val nextButton: Button = findViewById(R.id.buttonNextB4)
                nextButton.setOnClickListener {
                    navigateToNextQuestion()
                }
                currentLayoutIndex = 4
            }
            4 -> {
                setContentView(R.layout.bawang_q5)
                val nextButton: Button = findViewById(R.id.buttonNextB5)
                nextButton.setOnClickListener {
                    navigateToNextQuestion()
                }
                currentLayoutIndex = 5
            }
            5 -> {
                setContentView(R.layout.add_notes)
                val nextButton: Button = findViewById(R.id.buttonSubmit)
                nextButton.setOnClickListener {
                    navigateToHome()
                }
                currentLayoutIndex = 5
            }
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}