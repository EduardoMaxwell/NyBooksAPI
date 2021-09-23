package com.example.nybooks.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.nybooks.R

open class BaseActivity : AppCompatActivity() {
    protected fun setupToolbar(toolbar: Toolbar, titleResId: Int, showBackButton: Boolean = false) {
        toolbar.title = getString(titleResId)
        setSupportActionBar(toolbar)
        if (showBackButton)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}