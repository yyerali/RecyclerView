package com.example.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ExampleAdapterBinding

class ExampleRecyclerAdapter():RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>() {

    private val adapterlist = mutableListOf<Product>()

    inner class ExampleViewHolder(private var binding: ExampleAdapterBinding):RecyclerView.ViewHolder(binding.root) {
        fun onBind(item:Product){
            binding.tvBookTitle.text = item.title
            binding.tvBookPrice.text = item.price.toString()
            binding.tvBookGrade.text = "${item.grade} класс"
        }
    }

    fun submitList(list:List<Product>){
        adapterlist.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleRecyclerAdapter.ExampleViewHolder {
        return ExampleViewHolder(
            ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExampleRecyclerAdapter.ExampleViewHolder, position: Int) {
        holder.onBind(adapterlist[position])
    }

    override fun getItemCount(): Int {
        return adapterlist.size
    }

}