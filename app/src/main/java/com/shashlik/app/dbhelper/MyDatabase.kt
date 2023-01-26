package com.shashlik.app.dbhelper

import android.content.Context
import android.database.Cursor

class MyDatabase private constructor(context: Context) : CopyHelper(context, "ShashlikDataAll.db") {
    companion object {
        private var database: MyDatabase? = null
        fun init(context: Context) {
            database = MyDatabase(context)
        }

        fun getDataBase(): MyDatabase = database!!
    }


    fun getAllWords(): Cursor {
        return getDatabase().rawQuery("select * from foodtable", null)
    }




}