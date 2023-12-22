package com.dicoding.sipetta.view.post

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.sipetta.R
import com.dicoding.sipetta.view.home.HomeActivity
import com.google.android.material.textfield.TextInputEditText

class NotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)
        val textInputEditText: TextInputEditText = findViewById(R.id.textInputEditText)

        buttonSubmit.setOnClickListener {
            textInputEditText.text.toString()

            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}