package com.example.composeaula01.data

import androidx.annotation.DrawableRes

data class Profile(
    val name: String,
    val description: String,
    @DrawableRes val avatar: Int
)
