package com.example.consumerestapi.activity.helper

import android.content.Context
import android.widget.Toast

class utils {


    companion object {
        const val ID_CONTACT = "idContact"

        fun showToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}