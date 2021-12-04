package com.kay.prog.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var listener: OnItemClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as OnItemClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addBtn = view.findViewById<AppCompatButton>(R.id.add_btn)
        val name = view.findViewById<AppCompatEditText>(R.id.edit_name)
        val number = view.findViewById<AppCompatEditText>(R.id.edit_number)

        val list = mutableListOf<Person>()
        val adapter = SimpleAdapter {
            listener.onItemClicked(list[it])
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_container)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))

        addBtn.setOnClickListener {
            if (name.text.toString() != "" && number.text.toString() != "") {
                val saved = Person(name.text.toString(), number.text.toString())
                list.add(saved)
                adapter.setData(list)
                name.setText("")
                number.setText("")
            }
            else
            {
                Toast.makeText(context, "Заполните оба поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}