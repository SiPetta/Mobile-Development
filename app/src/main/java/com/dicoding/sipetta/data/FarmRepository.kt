package com.dicoding.sipetta.data

import com.dicoding.sipetta.data.api.ApiService
import com.dicoding.sipetta.data.api.ListOptionsItem
import com.dicoding.sipetta.data.pref.Question

class FarmRepository(private val apiService: ApiService) {

    suspend fun getQuestionsAndAnswersWithOptions(token: String, fvAgricode: String): List<Question> {
        val questionsWithOptions: MutableList<Question> = mutableListOf()

        try {
            val questionFormResponse = apiService.getQuestionListFarm("Bearer $token", fvAgricode)

            questionFormResponse.data?.forEach { dataItem ->
                val question = Question(
                    question = dataItem?.fvDiseasequestion ?: "",
                    options = parseOptions(dataItem?.listOptions),
                    indicatorCodes = parseIndicatorCodes(dataItem?.listOptions) // Mendapatkan kode indikator
                )
                questionsWithOptions.add(question)
            }
        } catch (_: Exception) {
        }

        return questionsWithOptions
    }


    private fun parseOptions(listOptions: List<ListOptionsItem?>?): List<String> {
        val options: MutableList<String> = mutableListOf()
        listOptions?.forEach { optionItem ->
            optionItem?.let {
                it.fvIndicatorname?.let { indicatorName ->
                    options.add(indicatorName)
                }
            }
        }
        return options
    }

    private fun parseIndicatorCodes(listOptions: List<ListOptionsItem?>?): List<String> {
        val indicatorCodes: MutableList<String> = mutableListOf()
        listOptions?.forEach { optionItem ->
            optionItem?.let {
                it.fvIndicatorcode?.let { indicatorCode ->
                    indicatorCodes.add(indicatorCode)
                }
            }
        }
        return indicatorCodes
    }


}
