// AddNewPostActivity.kt
package com.dicoding.sipetta.view.post
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import com.dicoding.sipetta.R
import com.dicoding.sipetta.ViewModelFactory
import com.dicoding.sipetta.data.api.ApiConfig
import com.dicoding.sipetta.data.api.DataListItem
import com.dicoding.sipetta.data.pref.UserPreference
import com.dicoding.sipetta.data.pref.dataStore
import com.dicoding.sipetta.view.plant.AndewiActivity
import com.dicoding.sipetta.view.plant.BawangActivity
import com.dicoding.sipetta.view.plant.SawiActivity
import com.dicoding.sipetta.view.plant.SeladaActivity
import com.dicoding.sipetta.view.plant.SeledriActivity
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

class AddNewPostActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var buttonNext: Button
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var userPreference: UserPreference
    private var token: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_post)

        spinner = findViewById(R.id.spinner)
        buttonNext = findViewById(R.id.buttonAddNext)
        userPreference = UserPreference.getInstance(this.dataStore)

        val factory = ViewModelFactory.getInstance(applicationContext, ApiConfig.getApiService())
        categoryViewModel = ViewModelProvider(this, factory)[CategoryViewModel::class.java]

        buttonNext.setOnClickListener {
            if (token.isNotEmpty()) {
                val selectedCategory = spinner.selectedItem.toString()
                val selectedCategoryCode = categoryViewModel.getCategoryCodeByName(selectedCategory) ?: ""
                if (selectedCategoryCode.isNotEmpty()) {
                    navigateToNextActivity(selectedCategory, selectedCategoryCode)
                }
            } else {
                fetchDataFromApi()
            }
        }

        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        if (token.isEmpty()) {
            runBlocking {
                try {
                    val userModel = userPreference.getSession().firstOrNull()
                    token = userModel?.token ?: ""

                    val response = ApiConfig.getApiService().getListFarm("Bearer $token", "")
                    val categories: List<DataListItem?>? = response.data

                    categories?.let {
                        val categoryList = it.filterNotNull()

                        // Log untuk memeriksa kategori beserta kode-kodenya
                        categoryList.forEach { category ->
                            Log.d("Kategori", "${category.fvAgriname}: ${category.fvAgricode}")
                        }

                        categoryViewModel.setCategories(categoryList)

                        val categoryNames = categoryList.map { category -> category.fvAgriname }
                        val adapter = ArrayAdapter(this@AddNewPostActivity, android.R.layout.simple_spinner_item, categoryNames)
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinner.adapter = adapter
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun navigateToNextActivity(selectedPlant: String, selectedPlantCode: String) {
        val encodedPlantCode = Base64.encodeToString(selectedPlantCode.toByteArray(), Base64.DEFAULT)

        val intent = when (selectedPlant) {
            "Andewi" -> Intent(this, AndewiActivity::class.java)
            "Bawang" -> Intent(this, BawangActivity::class.java)
            "Sawi" -> Intent(this, SawiActivity::class.java)
            "Selada" -> Intent(this, SeladaActivity::class.java)
            "Seledri" -> Intent(this, SeledriActivity::class.java)
            else -> null
        }

        Log.d("SelectedCategoryCode", "Selected Plant: $selectedPlant, Encoded Category Code: $encodedPlantCode")

        intent?.let {
            it.putExtra("SELECTED_PLANT", selectedPlant)
            it.putExtra("TOKEN", "Bearer $token")
            it.putExtra("CATEGORY_CODE", encodedPlantCode)
            startActivity(it)
        }
    }


}