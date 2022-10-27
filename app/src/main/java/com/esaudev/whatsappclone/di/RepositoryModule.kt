package com.esaudev.whatsappclone.di

import com.esaudev.whatsappclone.data.remote.repository.MessagesRepositoryImpl
import com.esaudev.whatsappclone.domain.repository.MessagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMessagesRepository(
        messagesRepository: MessagesRepositoryImpl
    ): MessagesRepository

}