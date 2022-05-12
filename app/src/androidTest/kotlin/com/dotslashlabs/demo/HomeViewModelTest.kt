package com.dotslashlabs.demo

import com.dotslashlabs.demo.data.DemoStore
import com.dotslashlabs.demo.data.entity.Book
import com.dotslashlabs.demo.data.repository.BookRepository
import com.dotslashlabs.demo.ui.screen.home.HomeViewModel
import com.dotslashlabs.demo.ui.screen.home.HomeViewState
import dagger.hilt.android.testing.HiltAndroidTest
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

@HiltAndroidTest
class HomeViewModelTest : BaseTest() {

    @Inject
    lateinit var bookRepository: BookRepository

    @Test
    fun testHomeViewModel() = runBlocking {
        val viewModel = HomeViewModel(
            HomeViewState(),
            DemoStore(
                bookRepository,
            ),
        )

        val books = (1..10).map { bookId ->
            Book(
                bookId = 0,
                title = "Harry Potter $bookId",
            )
        }

        viewModel.createBooks(books)
        assertEquals(books.size, runBlocking { viewModel.booksCount().first() })
    }
}
