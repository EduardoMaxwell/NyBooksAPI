package com.example.nybooks.data

import com.example.nybooks.data.model.Book

/*sealed class is a closed class as an enum but more powerful*/
sealed class BooksResult {


    /*When result is success return the book list*/
    class Success(val books: List<Book>) : BooksResult()
    class ApiError(val statusCode: Int) : BooksResult()
    object ServerError : BooksResult()
}