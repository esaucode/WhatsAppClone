package com.esaudev.whatsappclone.domain.model

import androidx.annotation.DrawableRes

data class Chat(
    @DrawableRes val userImage: Int,
    val userName: String,
    val id: String
)