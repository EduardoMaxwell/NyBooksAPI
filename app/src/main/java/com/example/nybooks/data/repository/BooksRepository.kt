package com.example.nybooks.data.repository

import com.example.nybooks.data.BooksResult

interface BooksRepository {

    fun getBooks(booksResultCallback: (booksResult: BooksResult) -> Unit)
}