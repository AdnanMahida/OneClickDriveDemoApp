package com.ad.oneclickdrivedemoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NumberInputViewModel : ViewModel() {
    private val pattern = Regex("[\\d,]*")

    var input1 by mutableStateOf("")
        private set
    var input2 by mutableStateOf("")
        private set
    var input3 by mutableStateOf("")
        private set
    var isButtonEnabled by mutableStateOf(false)


    var resultStr by mutableStateOf("")


    fun setInput1Value(value: String) {
        if (value.matches(pattern)) {
            input1 = value
            updateButtonState()
        }
    }

    fun setInput2Value(value: String) {
        if (value.matches(pattern)) {
            input2 = value
            updateButtonState()
        }
    }

    fun setInput3Value(value: String) {
        if (value.matches(pattern)) {
            input3 = value
            updateButtonState()
        }
    }

    private fun updateButtonState() {
        isButtonEnabled = (input1.isNotBlank() && input2.isNotBlank() && input3.isNotBlank())
    }


    fun calculateResult() {
        val numbers1List = input1.split(",").mapNotNull { it.toIntOrNull() }
        val numbers2List = input2.split(",").mapNotNull { it.toIntOrNull() }
        val numbers3List = input3.split(",").mapNotNull { it.toIntOrNull() }

        val listOf3 = listOf(numbers1List, numbers2List, numbers3List)

        val intersection = listOf3.reduce { acc, list -> acc.intersect(list.toSet()).toList() }
            .joinToString(prefix = "(", postfix = ")")
        val union = listOf3.flatten().toSet().joinToString(prefix = "(", postfix = ")")
        val highestNumber = listOf3.flatten().maxOrNull()

        resultStr = "Intersect :- $intersection\nUnion :- $union\nHighest :- $highestNumber"
    }
}