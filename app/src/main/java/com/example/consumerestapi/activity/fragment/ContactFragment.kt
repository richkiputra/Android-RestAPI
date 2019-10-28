package com.example.consumerestapi.activity.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumerestapi.BuildConfig

import com.example.consumerestapi.R
import com.example.consumerestapi.activity.DetailActivity
import com.example.consumerestapi.activity.adapter.ContactsAdapter
import com.example.consumerestapi.activity.api.API
import com.example.consumerestapi.activity.data.ResponseData
import com.example.consumerestapi.activity.helper.utils
import kotlinx.android.synthetic.main.fragment_contact.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    private val contactsAdapter = ContactsAdapter()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        initEvent()

    }

    override fun onResume() {
        super.onResume()

        getData()
    }

    private fun getData() {

        srlMain.isRefreshing = true

        API.getContacts(object: retrofit2.Callback<ResponseData>{
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                srlMain.isRefreshing =false

                if(BuildConfig.DEBUG){
                    utils.showToast(activity!!, t.message!!)

                }
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                srlMain.isRefreshing = false

                if (response.isSuccessful) {
                    contactsAdapter.arrayList = response.body()!!.data

                } else {
                    if (BuildConfig.DEBUG) {
                        utils.showToast(activity!!, response.message())
                    }
                }

            }

        })
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity!!)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        rvContacts.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = contactsAdapter
        }

    }

    private fun initEvent() {
        fabAdd.setOnClickListener {
            startActivity(Intent(activity!!, DetailActivity::class.java)) }

            srlMain.setOnRefreshListener { getData() }
    }
}