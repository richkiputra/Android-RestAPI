package com.example.consumerestapi.activity.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumerestapi.activity.data.ContactData

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {


    var arrayList: ArrayList<ContactData> = ArrayList()

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindata(contactData: ContactData){

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {


        return ViewHolder()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
       holder.binData(arrayList[postition])
    }
}