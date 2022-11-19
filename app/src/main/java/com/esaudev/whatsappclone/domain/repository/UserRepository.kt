package com.esaudev.whatsappclone.domain.repository

interface UserRepository {

    fun saveUserId(userId: String)

    fun getUserId(): String

}