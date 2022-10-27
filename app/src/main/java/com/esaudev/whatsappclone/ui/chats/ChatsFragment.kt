package com.esaudev.whatsappclone.ui.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.data.local.UserHelper
import com.esaudev.whatsappclone.databinding.FragmentChatsBinding
import com.esaudev.whatsappclone.domain.ext.gone
import com.esaudev.whatsappclone.domain.ext.show
import com.esaudev.whatsappclone.ui.dashboard.DashboardFragmentDirections

class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding: FragmentChatsBinding
        get() = _binding!!

    private val chatListAdapter = ChatListAdapter() {
        val action = DashboardFragmentDirections.actionDashboardFragmentToChatFragment(chatId = it.id)
        findNavController().navigate(action)
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
        val chatList = UserHelper.chatList

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