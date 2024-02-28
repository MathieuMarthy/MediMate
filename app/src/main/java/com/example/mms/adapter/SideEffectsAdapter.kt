package com.example.mms.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mms.R
import com.example.mms.model.ShoawbleItem


class SideEffectsAdapter(
    private val items: List<ShoawbleItem>
) : RecyclerView.Adapter<SideEffectsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_side_effects, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.name.text = item.title
        holder.message.text = item.content
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.side_effects_name)
        val message: TextView = itemView.findViewById(R.id.side_effects_message)
    }

    override fun getItemCount() = items.size
}
