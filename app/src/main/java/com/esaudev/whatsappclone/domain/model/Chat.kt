package com.esaudev.whatsappclone.domain.model

import androidx.annotation.DrawableRes

data class Chat(
    @DrawableRes val userImage: Int,
    val id: String,
    val userOneId: String,
    val userTwoId: String,
    val userOne: String,
    val userTwo: String
)