package com.example.swvlmoviesapp.modules.search_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.databinding.ActivitySearchBinding
import com.example.swvlmoviesapp.modules.search_screen.viewmodel.SearchViewModel

/**
 * Search activity class
 */
class SearchActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
    }

    /**
     * Binding viewmodel with view
     */
    private fun setUpBinding() {
        val binding =
            DataBindingUtil.setContentView<ActivitySearchBinding>(this, R.layout.activity_search)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setUpToolbar(binding)
    }

    /**
     * Setting up toolbar
     * @param binding
     */
    private fun setUpToolbar(binding: ActivitySearchBinding) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * On back button pressed on toolbar
     */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}