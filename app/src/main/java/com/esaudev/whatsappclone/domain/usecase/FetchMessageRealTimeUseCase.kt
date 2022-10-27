package com.esaudev.whatsappclone.domain.usecase

import com.esaudev.whatsappclone.domain.model.Message
import com.esaudev.whatsappclone.util.Resource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FetchMessageRealTimeUseCase @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    suspend operator fun invoke(chatId: String): Flow<Resource<List<Message>>> = callbackFlow {

        val event = firestore.collection(chatId).orderBy("timestamp", Query.Direction.DESCENDING)

        val subscription = event.addSnapshotListener { snapshot, error ->

            if (error != null) {
                this.trySend(Resource.Error(error.message.toString())).isSuccess
                return@addSnapshotListener
            }

            if (snapshot != null) {

                val messageList = snapshot.toObjects(Message::class.java)

                this.trySend(Resource.Success(messageList)).isSuccess

            }
        }

        awaitClose { subscription.remove() }

    }

}