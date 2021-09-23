package com.example.nybooks.ui.books

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nybooks.R
import com.example.nybooks.databinding.ActivityBooksBinding
import com.example.nybooks.ui.base.BaseActivity
import com.example.nybooks.ui.details.BookDetailsActivity

class BooksActivity : BaseActivity() {
    private lateinit var binding: ActivityBooksBinding
    private val viewModel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Método criado na classe BaseActivity para reaproveitar código da Toolbar*/
        setupToolbar(binding.toolbarBooks.root, R.string.books_title)

        viewModel.booksLiveData.observe(this, {
            it?.let { books ->
                with(binding.recyclerBooks) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getStartIntent(
                            this@BooksActivity,
                            book.title,
                            book.description
                        )

                        this@BooksActivity.startActivity(intent)
                    }
                }
            }
        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                binding.viewFlipperBooks.displayedChild = viewFlipper.first

                viewFlipper.second?.let { errorMessageResId ->
                    binding.tvError.text = getString(errorMessageResId)
                }
            }

        })

        viewModel.getBooks()
    }

}