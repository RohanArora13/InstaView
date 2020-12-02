package com.example.instaview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var imageAdapter: ImageRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()

    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        imageAdapter.submitList(data)
    }

    private fun initRecyclerView(){

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
          //  val topSpacingDecorator = TopSpacingItemDecoration(30)
            //addItemDecoration(topSpacingDecorator)
        imageAdapter = ImageRecyclerAdapter()
        recyclerView.adapter = imageAdapter

        }

}