package com.example.nybooks.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nybooks.data.Book

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        booksLiveData.value = createFakeBooks()
    }

    fun createFakeBooks(): List<Book> {

        return listOf(
            Book("Title 1", "Author 1"),
            Book("Title 2", "Author 2"),
            Book("Title 3", "Author 3"),
            Book("Title 4", "Author 4"),
            Book("Title 5", "Author 5"),
            Book("Title 6", "Author 6"),
            Book("Title 7", "Author 7"),
            Book("Title 8", "Author 8"),
            Book("Title 9", "Author 9"),
            Book("Title 10", "Author 10"),
            Book("Title 11", "Author 11"),
            Book("Title 12", "Author 12"),
            Book("Title 13", "Author 13"),
            Book("Title 14", "Author 14"),

            )
    }
}