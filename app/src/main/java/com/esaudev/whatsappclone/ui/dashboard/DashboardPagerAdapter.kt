package com.esaudev.whatsappclone.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.esaudev.whatsappclone.ui.calls.CallsFragment
import com.esaudev.whatsappclone.ui.chats.ChatsFragment
import com.esaudev.whatsappclone.ui.social.SocialFragment

class DashboardPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { ChatsFragment() }
            1 -> { SocialFragment() }
            2 -> { CallsFragment() }
            else -> throw IllegalArgumentException("Invalid fragment position, max value 2")
        }
    }

}