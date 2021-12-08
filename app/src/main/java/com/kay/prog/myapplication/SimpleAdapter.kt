package com.kay.prog.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(
    private val click: (person: Person) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = mutableListOf<Person>()

    fun addPerson(person: Person) {
        list.add(person)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = list[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        itemView: View,
        private val click: (person: Person) -> Unit
    ): RecyclerView.ViewHolder(itemView) {

        fun bind(person: Person) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_txt)
            txt.text = person.name
            val btn = itemView.findViewById<AppCompatButton>(R.id.item_btn)
            btn.setOnClickListener {
                click.invoke(person)
            }
        }
    }
}