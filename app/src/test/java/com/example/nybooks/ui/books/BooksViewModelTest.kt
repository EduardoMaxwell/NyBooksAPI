package com.example.nybooks.ui.books

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.nybooks.R
import com.example.nybooks.data.BooksResult
import com.example.nybooks.data.model.Book
import com.example.nybooks.data.repository.BooksRepository
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BooksViewModelTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var booksLiveDataObserver: Observer<List<Book>>

    @Mock
    private lateinit var viewFlipperLiveDataObserver: Observer<Pair<Int, Int?>>

    private lateinit var booksViewModel: BooksViewModel

    @Test
    fun `when view model getBooks get success then sets booksLiveData`() {
        //Arrange
        val books = listOf(
            Book("Title 01", "Author 01", "Description 01")
        )
        val resultSuccess = MockRepository(BooksResult.Success(books))
        booksViewModel = BooksViewModel(resultSuccess)
        booksViewModel.booksLiveData.observeForever(booksLiveDataObserver)
        booksViewModel.viewFlipperLiveData.observeForever(viewFlipperLiveDataObserver)

        //Act
        booksViewModel.getBooks()

        //Assert
        verify(booksLiveDataObserver).onChanged(books)
        verify(viewFlipperLiveDataObserver).onChanged(Pair(1, null))
    }

    @Test
    fun `when view model getBooks get server error then sets viewFlipperLiveData`() {
        //Arrange
        val resultServerError = MockRepository(BooksResult.ServerError)
        booksViewModel = BooksViewModel(resultServerError)
        booksViewModel.viewFlipperLiveData.observeForever(viewFlipperLiveDataObserver)

        //Act
        booksViewModel.getBooks()

        //Assert
        verify(viewFlipperLiveDataObserver).onChanged(Pair(2, R.string.books_error_500))

    }
}

class MockRepository(private val result: BooksResult) : BooksRepository {
    override fun getBooks(booksResultCallback: (booksResult: BooksResult) -> Unit) {
        booksResultCallback(result)
    }

}