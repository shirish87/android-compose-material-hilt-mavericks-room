package com.dotslashlabs.demo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "bookId") val bookId: Long,
    @ColumnInfo(name = "title") val title: String,
)
