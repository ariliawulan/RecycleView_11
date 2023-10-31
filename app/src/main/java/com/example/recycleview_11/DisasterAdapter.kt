package com.example.recycleview_11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview_11.databinding.ItemDisasterBinding

typealias onClickDisaster = (Disaster) -> Unit

class DisasterAdapter (private val listDisaster: List<Disaster>, private val onClickDisaster: onClickDisaster)
    : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {
    inner class ItemDisasterViewHolder (private val binding: ItemDisasterBinding) :RecyclerView.ViewHolder(binding.root) {

        fun bind (data: Disaster) {
            with(binding) {
                txtDisasaterName.text = data.nameDisaster
                txtDisasterType.text = data.typeDisaster
                itemView.setOnClickListener{
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int = listDisaster.size

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}