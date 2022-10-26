package com.esaudev.whatsappclone.ui.calls

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.databinding.FragmentCallsBinding
import com.esaudev.whatsappclone.databinding.FragmentChatsBinding

class CallsFragment : Fragment() {

    private var _binding: FragmentCallsBinding? = null
    private val binding: FragmentCallsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCallsBinding.inflate(inflater, container, false)

        return binding.root
    }

}