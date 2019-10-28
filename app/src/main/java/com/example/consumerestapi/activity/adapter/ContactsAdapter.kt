package com.example.consumerestapi.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.consumerestapi.R
import com.example.consumerestapi.activity.data.ContactData
import kotlinx.android.synthetic.main.row_item.view.*

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {


    var arrayList: ArrayList<ContactData> = ArrayList()

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun binData(contactData: ContactData){

            Glide.with(view).load(contactData.image_url).apply(RequestOptions().circleCrop()).into(view.ivPhoto)

            view.tvNameContact.text = contactData.name
            view.tvPhoneContact.text = contactData.phone
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false )

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
       holder.binData(arrayList[position])
    }
}