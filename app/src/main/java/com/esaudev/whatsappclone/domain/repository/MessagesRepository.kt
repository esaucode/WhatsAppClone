package com.esaudev.whatsappclone.domain.repository

import com.esaudev.whatsappclone.domain.model.Message
import com.esaudev.whatsappclone.util.Resource

interface MessagesRepository {

    suspend fun sendMessage(message: Message): Resource<Unit>

    //suspend fun fetchMessagesByChat(chatId: String): Resource<List<Message>>

}