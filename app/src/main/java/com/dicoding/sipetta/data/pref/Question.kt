package com.dicoding.sipetta.data.pref

data class Question(
    val question: String,
    val options: List<String>,
    val indicatorCodes: List<String>
)
