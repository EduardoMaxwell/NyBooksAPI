package com.example.nybooks.ui.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nybooks.data.Book
import com.example.nybooks.databinding.ItemBookBinding
import com.example.nybooks.ui.books.BooksAdapter.BooksViewHolder

class BooksAdapter(
    private val books: List<Book>
) : RecyclerView.Adapter<BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.viewBind(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {

        private val title = binding.tvTitle
        private val author = binding.tvAuthor

        fun viewBind(book: Book) {
            title.text = book.title
            author.text = book.author
        }
    }
}