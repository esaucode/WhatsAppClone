package com.esaudev.whatsappclone.ui.chat

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.navArgs
import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.data.local.UserHelper
import com.esaudev.whatsappclone.databinding.FragmentCallsBinding
import com.esaudev.whatsappclone.databinding.FragmentChatBinding
import com.esaudev.whatsappclone.domain.ext.hideKeyboard

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding: FragmentChatBinding
        get() = _binding!!

    private val args: ChatFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onDetach() {
        super.onDetach()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChatBinding.inflate(inflater, container, false)

        setupClickListeners()
        setupUserInformation()
        setupMessageListener()

        return binding.root
    }

    private fun setupClickListeners() {
        binding.backButton.setOnClickListener { activity?.onBackPressed() }
    }

    private fun setupUserInformation() {

        val userToText = UserHelper.usersList.find {
            it.id == args.chatId
        }?: throw Exception("Invalid chat id")

        with(binding) {
            chatImage.setImageResource(userToText.image)
            chatName.text = userToText.name
        }
    }

    private fun setupMessageListener() {
        with(binding) {
            etMessage.addTextChangedListener {
                llSendMessage.isVisible = it.toString().isNotEmpty()
            }

            etMessage.setOnEditorActionListener { textView, actionId, keyEvent ->
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    hideKeyboard()
                }
                true
            }
        }
    }

}