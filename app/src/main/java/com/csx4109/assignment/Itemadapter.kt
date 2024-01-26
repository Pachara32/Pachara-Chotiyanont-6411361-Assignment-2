package com.example.recyclerviewwithlistandgridview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.databinding.ItemListAdapterBinding

import com.example.recyclerviewwithlistandgridview.model.infromation

class Itemadapter (private val context: Context, private val score: List<infromation>)
    : RecyclerView.Adapter<Itemadapter.RecyclerViewHolder>(){
    class RecyclerViewHolder(val itemBinding: ItemListAdapterBinding)
        : RecyclerView.ViewHolder(itemBinding.root)

    override fun getItemCount(): Int = score.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemListAdapterBinding.inflate(layoutInflater, parent, false)

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val score = score[position]

        holder.itemBinding.textName.text = score.nameGame.toString()
        holder.itemBinding.description.text = score.dec
        holder.itemBinding.score.text = score.score.toString()
        holder.itemBinding.imageView.setImageResource(score.image)

    }


}