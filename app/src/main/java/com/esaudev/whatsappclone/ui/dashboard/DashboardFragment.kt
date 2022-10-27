package com.esaudev.whatsappclone.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.databinding.FragmentChatsBinding
import com.esaudev.whatsappclone.databinding.FragmentDashboardBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding: FragmentDashboardBinding
        get() = _binding!!

    private val args: DashboardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        setupViewPager()

        return binding.root
    }

    private fun setupViewPager() {
        binding.dashboardViewPager.apply {
            adapter = DashboardPagerAdapter(this@DashboardFragment, userId = args.userId)
        }

        TabLayoutMediator(binding.dashboardTabLayout, binding.dashboardViewPager) { tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.chats)
                1 -> getString(R.string.social)
                2 -> getString(R.string.calls)
                else -> throw Exception("Invalid position")
            }
        }.attach()
    }
}