package com.esaudev.whatsappclone.ui.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.databinding.FragmentCallsBinding
import com.esaudev.whatsappclone.databinding.FragmentSocialBinding

class SocialFragment : Fragment() {

    private var _binding: FragmentSocialBinding? = null
    private val binding: FragmentSocialBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSocialBinding.inflate(inflater, container, false)

        return binding.root
    }

}