package com.example.second_home_task.data

import com.example.second_home_task.R
import com.example.second_home_task.model.Element

class DataSource {
    fun loadElement(): MutableList<Element> {
        val listElement = mutableListOf<Element>()
        for (number in 1..1000) {
            val element =
                Element(R.drawable.baseline_pets_24, "Title $number", "Description $number")
            listElement.add(element)
        }
        return listElement
    }
}