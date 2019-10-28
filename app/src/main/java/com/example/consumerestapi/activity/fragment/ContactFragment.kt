package com.example.consumerestapi.activity.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.consumerestapi.R
import com.example.consumerestapi.activity.DetailActivity
import com.example.consumerestapi.activity.adapter.ContactsAdapter
import kotlinx.android.synthetic.main.fragment_contact.*

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    val contactsAdapter = ContactsAdapter()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        initEvent()

    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity!!)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
    }

    private fun initEvent() {
        fabAdd.setOnClickListener{ startActivity(Intent(activity!!, DetailActivity::class.java))
        }
    }



}
