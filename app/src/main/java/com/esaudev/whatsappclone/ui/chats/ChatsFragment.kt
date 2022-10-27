package com.esaudev.whatsappclone.ui.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.esaudev.whatsappclone.data.local.UserHelper
import com.esaudev.whatsappclone.databinding.FragmentChatsBinding
import com.esaudev.whatsappclone.domain.ext.gone
import com.esaudev.whatsappclone.domain.ext.show
import com.esaudev.whatsappclone.ui.dashboard.DashboardFragmentDirections
import com.google.firebase.firestore.auth.User

class ChatsFragment() : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding: FragmentChatsBinding
        get() = _binding!!

    private val chatListAdapter by lazy {
        ChatListAdapter {
            val action = DashboardFragmentDirections.actionDashboardFragmentToChatFragment(
                chatId = it.id,
                userId = arguments?.getString("userId") ?: throw Exception("Invalid user id"),
                userToTextId = it.userTwoId
            )
            findNavController().navigate(action)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChatsBinding.inflate(inflater, container, false)

        setupRecyclerView()
        handleChatList()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.chatList.apply {
            adapter = chatListAdapter
        }
    }

    private fun handleChatList() {

        val chatList = when(arguments?.getString("userId")?: throw Exception("Invalid user id")) {
            "1" -> UserHelper.cristianoChatList
            "2" -> UserHelper.messiChatList
            "3" -> UserHelper.lewandowskiChatList
            "4" -> UserHelper.neymarChatList
            else -> throw Exception("Invalid user id")
        }

        if (chatList.isEmpty()) {
            binding.chatList.gone()
            binding.emptyMessage.show()
        } else {
            binding.emptyMessage.gone()
            binding.chatList.show()

            chatListAdapter.submitList(chatList)
        }
    }

}