package com.dicoding.sipetta.view.post

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.sipetta.data.FarmRepository
import com.dicoding.sipetta.data.api.DataListItem

class CategoryViewModel(private val farmRepository: FarmRepository) : ViewModel(), LifecycleObserver {

    private val _categories = MutableLiveData<List<DataListItem>>()

    private val _selectedCategory = MutableLiveData<DataListItem>()
    val selectedCategory: LiveData<DataListItem> get() = _selectedCategory

    private val categoryMap = mapOf(
        "Andewi" to "TN-DEC/23-00001",
        "Selada" to "TN-DEC/23-00002",
        "Sawi" to "TN-DEC/23-00003",
        "Bawang" to "TN-DEC/23-00004",
        "Seledri" to "TN-DEC/23-00005"
    )

    fun setCategories(data: List<DataListItem>) {
        _categories.value = data
    }

    fun setSelectedCategory(category: DataListItem) {
        _selectedCategory.value = category
    }

    fun getCategoryCodeByName(categoryName: String): String? {
        return categoryMap[categoryName]
    }
}
