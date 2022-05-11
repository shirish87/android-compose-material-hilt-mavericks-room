package com.dotslashlabs.demo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dotslashlabs.demo.data.dao.BookDao
import com.dotslashlabs.demo.data.entity.Book

@Database(
    entities = [
        Book::class,
    ],
    version = DemoDatabase.VERSION, exportSchema = false
)
abstract class DemoDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1

        fun instance(appContext: Context) = Room.databaseBuilder(
            appContext,
            DemoDatabase::class.java,
            "demo.db",
        ).build()
    }

    abstract fun bookDao(): BookDao
}
