package com.example.rv_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>()
        items.add("A")
        items.add("B")
        items.add("C")

        val rv = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RvAdapter(items)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)


        //item click 직접 구현.
        rvAdapter.itemClick = object : RvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
               Toast.makeText(baseContext, items[position], Toast.LENGTH_SHORT).show()
            }

        }
    }
}