package com.esaudev.whatsappclone.data.local

import com.esaudev.whatsappclone.R
import com.esaudev.whatsappclone.domain.model.Chat
import com.esaudev.whatsappclone.domain.model.User

object UserHelper {

    val usersList = listOf(
        User(
            id = "1",
            image = R.drawable.asset_cr7,
            name = "Cristiano Ronaldo"
        ),
        User(
            id = "2",
            image = R.drawable.asset_messi,
            name = "Lionel Messi"
        ),
        User(
            id = "3",
            image = R.drawable.asset_lewandowski,
            name = "Robert Lewandowski"
        ),
        User(
            id = "4",
            image = R.drawable.asset_neymar,
            name = "Neymar Jr"
        ),
    )

    val chatList = listOf(
        Chat(
            id = "1",
            userImage = R.drawable.asset_cr7,
            userName = "Cristiano Ronaldo"
        ),
        Chat(
            id = "2",
            userImage = R.drawable.asset_messi,
            userName = "Lionel Messi"
        ),
        Chat(
            id = "3",
            userImage = R.drawable.asset_lewandowski,
            userName = "Robert Lewandowski"
        ),
        Chat(
            id = "4",
            userImage = R.drawable.asset_neymar,
            userName = "Neymar Jr"
        ),
    )

}