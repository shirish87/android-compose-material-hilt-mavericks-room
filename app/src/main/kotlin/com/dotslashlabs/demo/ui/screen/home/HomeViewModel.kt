package com.dotslashlabs.demo.ui.screen.home

import com.airbnb.mvrx.*
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.dotslashlabs.demo.data.DemoStore
import com.dotslashlabs.demo.data.entity.Book
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class HomeViewState(
    val books: Async<List<Book>> = Uninitialized,
) : MavericksState

class HomeViewModel @AssistedInject constructor(
    @Assisted private val state: HomeViewState,
    private val store: DemoStore,
) : MavericksViewModel<HomeViewState>(state) {

    init {
        store.books().execute(retainValue = HomeViewState::books) {
            copy(books = it)
        }

        onAsync(HomeViewState::books) { books ->
            if (books.isEmpty()) {
                seedBooks()
            }
        }
    }

    fun booksCount() = store.booksCount()
    suspend fun createBooks(books: Collection<Book>) = store.createBooks(books)

    private suspend fun seedBooks() = store.createBooks(
        mutableListOf<Book>().apply {
            repeat(50) {
                add(Book(bookId = 0, title = "Book ${it + 1}"))
            }
        }
    )

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<HomeViewModel, HomeViewState> {
        override fun create(state: HomeViewState): HomeViewModel
    }

    companion object : MavericksViewModelFactory<HomeViewModel, HomeViewState>
    by hiltMavericksViewModelFactory()
}
