package com.example.second_home_task.adapter

import com.example.second_home_task.model.Element

interface AdaptersListener {
    fun onClickItem(element: Element, holder: ItemAdapter.ItemHolder)
}
