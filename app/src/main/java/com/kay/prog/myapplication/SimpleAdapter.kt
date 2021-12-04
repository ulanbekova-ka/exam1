package com.kay.prog.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(
    private val click: (pos: Int) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = list[position]
        holder.bind(text)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        itemView: View,
        private val click: (pos: Int) -> Unit
    ): RecyclerView.ViewHolder(itemView) {

        fun bind(text: String) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_txt)
            txt.text = text
            val btn = itemView.findViewById<AppCompatButton>(R.id.item_btn)
            btn.setOnClickListener {
                click.invoke(adapterPosition)
            }
        }
    }
}