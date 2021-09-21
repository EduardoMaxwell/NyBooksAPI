package com.example.nybooks.ui.books

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nybooks.data.model.Book
import com.example.nybooks.databinding.ItemBookBinding
import com.example.nybooks.ui.books.BooksAdapter.BooksViewHolder

class BooksAdapter(
    private val books: List<Book>,
    private val onItemClickListener: ((book: Book) -> Unit)
) : RecyclerView.Adapter<BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.viewBind(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(
        val binding: ItemBookBinding,
        private val onItemClickListener: ((book: Book) -> Unit)
    ) : RecyclerView.ViewHolder(binding.root) {

        private val title = binding.tvTitle
        private val author = binding.tvAuthor

        fun viewBind(book: Book) {
            title.text = book.title
            author.text = book.author

            binding.root.setOnClickListener {
                onItemClickListener.invoke(book)
            }
        }

    }
}