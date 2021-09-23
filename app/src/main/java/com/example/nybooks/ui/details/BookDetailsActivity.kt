package com.example.nybooks.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.nybooks.R
import com.example.nybooks.databinding.ActivityBookDetailsBinding
import com.example.nybooks.databinding.IncludeToolbarBinding
import com.example.nybooks.ui.base.BaseActivity

class BookDetailsActivity : BaseActivity() {
    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Método criado na classe BaseActivity para reaproveitar código da Toolbar*/
        setupToolbar(binding.toolbarDetails.root, R.string.book_detail_title, true)

        binding.bookDetailsTitle.text = intent.getStringExtra(EXTRA_TITLE)
        binding.bookDetailsDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    /*cria uma intent na activity destino*/
    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}