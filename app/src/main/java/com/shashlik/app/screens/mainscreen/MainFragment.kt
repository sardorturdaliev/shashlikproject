package com.shashlik.app.screens.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashlik.app.adapter.CursorAdapter
import com.shashlik.app.databinding.FragmentMainBinding
import com.shashlik.app.dbhelper.MyDatabase
import com.shashlik.app.model.ProductData


class MainFragment : Fragment(), CursorAdapter.OnClikedListener {
    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private lateinit var database: MyDatabase
    private lateinit var adapter: CursorAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database = MyDatabase.getDataBase()
        val cursor = database.getAllWords()
        adapter = CursorAdapter(requireContext(), cursor, "", this)

        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(requireContext(), 2)


        return binding.root
    }

    override fun click(productData: ProductData) {
//        val intent = Intent(this, AboutActivity::class.java)
//        intent.putExtra("key", productData.about)
//        startActivity(intent)
    }
}