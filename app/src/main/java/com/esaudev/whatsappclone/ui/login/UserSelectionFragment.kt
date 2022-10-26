package com.esaudev.whatsappclone.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.data.local.UserHelper
import com.esaudev.whatsappclone.databinding.FragmentSocialBinding
import com.esaudev.whatsappclone.databinding.FragmentUserSelectionBinding

class UserSelectionFragment : Fragment() {

    private var _binding: FragmentUserSelectionBinding? = null
    private val binding: FragmentUserSelectionBinding
        get() = _binding!!

    private val userListAdapter = UserListAdapter() {
        Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUserSelectionBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.userList.apply {
            adapter = userListAdapter
            layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }

        userListAdapter.submitList(UserHelper.usersList)
    }
}