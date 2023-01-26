package com.shashlik.app.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shashlik.app.databinding.ItemCardBinding
import com.shashlik.app.model.ProductData

class CursorAdapter(
    val context: Context,
    var cursor: Cursor,
    var query: String = "",
    val listener: OnClikedListener
) :
    RecyclerView.Adapter<CursorAdapter.CursorViewHolder>() {

    inner class CursorViewHolder(private val view: ItemCardBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(productData: ProductData) {
            view.tvTitle.text = productData.word

            Glide.with(context).load(productData.img).into(view.imgProduct)


            itemView.setOnClickListener {
                listener.click(productData)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CursorViewHolder(
        ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: CursorViewHolder, position: Int) {
        cursor.moveToPosition(position)

        val data = ProductData(
            cursor.getInt(cursor.getColumnIndex("id")),
            cursor.getString(cursor.getColumnIndex("word")),
            cursor.getString(cursor.getColumnIndex("about")),
            cursor.getString(cursor.getColumnIndex("img"))
        )
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return cursor.count
    }


    interface OnClikedListener {
        fun click(productData: ProductData)
    }
}