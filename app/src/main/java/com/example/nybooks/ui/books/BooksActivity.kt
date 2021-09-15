package com.example.nybooks.ui.books

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nybooks.R
import com.example.nybooks.data.Book
import com.example.nybooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarMain.title = getString(R.string.books_title)
        setSupportActionBar(binding.toolbarMain)

        with(binding.recyclerBooks) {
            layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = BooksAdapter(getBooks())
        }
    }

    fun getBooks(): List<Book> {

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