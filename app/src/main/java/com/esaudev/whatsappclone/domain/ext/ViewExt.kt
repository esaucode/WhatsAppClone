package com.esaudev.whatsappclone.domain.ext

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}