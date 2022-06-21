package com.example.second_home_task.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Element(
    val image: Int,
    val title: String,
    val description: String
) : Parcelable