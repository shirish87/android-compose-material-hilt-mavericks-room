package com.dotslashlabs.demo

import com.dotslashlabs.demo.data.dao.BookDao
import com.dotslashlabs.demo.data.entity.Book
import dagger.hilt.android.testing.HiltAndroidTest
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

@HiltAndroidTest
class BookDaoTest : BaseTest() {

    @Inject
    lateinit var bookDao: BookDao

    @Test
    @Throws(Exception::class)
    fun insertAndGetBook() = runBlocking {
        val bookId = 0
        val book = Book(
            0,
            title = "Harry Potter $bookId",
        )

        bookDao.insert(book)
        val savedBook = bookDao.books().first()
        assertEquals(savedBook[0].title, book.title)
    }
}
