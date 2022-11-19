package com.esaudev.whatsappclone.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.data.local.UserHelper
import com.esaudev.whatsappclone.databinding.FragmentSocialBinding
import com.esaudev.whatsappclone.databinding.FragmentUserSelectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSelectionFragment : Fragment() {

    private var _binding: FragmentUserSelectionBinding? = null
    private val binding: FragmentUserSelectionBinding
        get() = _binding!!

    private val viewModel: UserSelectionViewModel by viewModels()

    private val userListAdapter = UserListAdapter() {
        viewModel.saveUserSelection(userId = it.id)
        val action = UserSelectionFragmentDirections.actionUserSelectionFragmentToDashboardFragment(userId = it.id)
        findNavController().navigate(action)
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