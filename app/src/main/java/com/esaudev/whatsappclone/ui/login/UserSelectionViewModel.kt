package com.esaudev.whatsappclone.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaudev.whatsappclone.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSelectionViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun saveUserSelection(userId: String) {
        viewModelScope.launch {
            userRepository.saveUserId(userId)
        }
    }

}