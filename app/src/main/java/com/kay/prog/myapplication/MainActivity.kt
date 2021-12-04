package com.kay.prog.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnItemClicked {
    private val list = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .addToBackStack(null)
            .commit()
    }

    override fun onItemClicked(person: Person) {
        list.add(person)

        val frg2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("name", person.name)
        bundle.putString("number", person.number)
        frg2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, frg2)
            .addToBackStack(null)
            .commit()
    }
}