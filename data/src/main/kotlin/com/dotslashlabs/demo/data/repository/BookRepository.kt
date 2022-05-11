package com.dotslashlabs.demo.data.repository

import com.dotslashlabs.demo.data.dao.BookDao
import com.dotslashlabs.demo.data.entity.Book
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val bookDao: BookDao,
) {
    fun books() = bookDao.books()
    fun booksCount() = bookDao.booksCount()
    fun bookById(bookId: Long) = bookDao.bookById(bookId)
    suspend fun createBook(book: Book) = bookDao.insert(book)
    suspend fun createBooks(books: Collection<Book>) = bookDao.insertAll(books)
    suspend fun updateBook(book: Book) = bookDao.update(book)
    suspend fun deleteBook(book: Book) = bookDao.delete(book)
}
