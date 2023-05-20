package com.example.myhospitalapp

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter(private val serviceList: ArrayList<Services>): RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ServiceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.service_item,
        parent,false)
        return ServiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ServiceAdapter.ServiceViewHolder, position: Int) {
        val curItem = serviceList[position]

        holder.serviceName.text = curItem.serviceName
        holder.serviceDesc.text = curItem.serviceDesc
        holder.servicePrice.text = curItem.servicePrice
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    class ServiceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val serviceName: TextView = itemView.findViewById(R.id.tvServiceName)
        val serviceDesc: TextView = itemView.findViewById(R.id.tvServiceDesc)
        val servicePrice: TextView = itemView.findViewById(R.id.tvServicePrice)
    }
}