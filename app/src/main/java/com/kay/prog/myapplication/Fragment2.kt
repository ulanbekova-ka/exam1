package com.kay.prog.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt = view.findViewById<AppCompatTextView>(R.id.frg2_txt)
        val name = arguments?.getString("name") ?: "Fragment 2"
        val number = arguments?.getString("number") ?: "Fragment 2"
        txt.text = "$name\n $number"
    }
}