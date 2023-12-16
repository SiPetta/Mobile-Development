package com.dicoding.sipetta.view.post

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.dicoding.sipetta.R
import com.dicoding.sipetta.view.plant.AndewiActivity
import com.dicoding.sipetta.view.plant.BawangActivity
import com.dicoding.sipetta.view.plant.SawiActivity
import com.dicoding.sipetta.view.plant.SeladaActivity
import com.dicoding.sipetta.view.plant.SeledriActivity

class AddNewPostActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_post)

        spinner = findViewById(R.id.spinner)
        buttonNext = findViewById(R.id.buttonAddNext)

        val items = arrayOf(
            "Andewi",
            "Bawang",
            "Sawi",
            "Selada",
            "Seledri"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        buttonNext.setOnClickListener {
            navigateToNextActivity()
        }
    }

    private fun navigateToNextActivity() {
        when (spinner.selectedItem.toString()) {
            "Andewi" -> {
                startActivity(Intent(this, AndewiActivity::class.java))
            }
            "Bawang" -> {
                startActivity(Intent(this, BawangActivity::class.java))
            }
            "Sawi" -> {
                startActivity(Intent(this, SawiActivity::class.java))
            }
            "Selada" -> {
                startActivity(Intent(this, SeladaActivity::class.java))
            }
            "Seledri" -> {
                startActivity(Intent(this, SeledriActivity::class.java))
            }
            else -> {
                // Tidak ada aksi jika tidak ada yang dipilih
            }
        }
    }
}

