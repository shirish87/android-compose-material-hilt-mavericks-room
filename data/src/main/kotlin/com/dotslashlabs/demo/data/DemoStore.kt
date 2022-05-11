package com.dotslashlabs.demo.data

import com.dotslashlabs.demo.data.entity.Book
import com.dotslashlabs.demo.data.repository.BookRepository
import javax.inject.Inject

class DemoStore @Inject constructor(
    private val bookRepository: BookRepository,
) {
    fun books() = bookRepository.books()
    fun booksCount() = bookRepository.booksCount()
    suspend fun createBooks(books: Collection<Book>) = bookRepository.createBooks(books)
}
