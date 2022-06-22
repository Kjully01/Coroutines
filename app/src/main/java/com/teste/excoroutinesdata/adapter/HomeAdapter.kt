package com.teste.excoroutinesdata.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teste.excoroutinesdata.databinding.LayoutRecyclerViewBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val listMock = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listMock[position])
    }

    override fun getItemCount(): Int {
        return listMock.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNewString(string: String){
        listMock.add(listMock.size, string)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: LayoutRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: String) {
            binding.tvRecyclerView.text = item
        }
    }

}