package com.shashlik.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashlik.app.adapter.CursorAdapter
import com.shashlik.app.databinding.ActivityMainBinding
import com.shashlik.app.dbhelper.MyDatabase
import com.shashlik.app.model.ProductData

class MainActivity : AppCompatActivity(){
    private val bindign by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindign.root)



    }
}