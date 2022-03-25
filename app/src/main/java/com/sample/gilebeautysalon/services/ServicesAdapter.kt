package com.sample.gilebeautysalon.services

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.gilebeautysalon.databinding.ServiceItemBinding
import com.sample.gilebeautysalon.models.Data

class ServicesAdapter : RecyclerView.Adapter<ServicesViewHolder>() {

    private var data = mutableListOf<Data>()
    private lateinit var servicesViewModel: ServicesViewModel

    fun addServicesList(data: List<Data>, viewModel: ServicesViewModel){
        this.data = data.toMutableList()
        servicesViewModel = viewModel
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val itemBinding = ServiceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServicesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}