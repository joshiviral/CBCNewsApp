package com.example.cbcnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cbcnewsapp.R
import com.example.cbcnewsapp.db.NewsResponseItemDatabase
import com.example.cbcnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.coroutines.InternalCoroutinesApi

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(NewsResponseItemDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
       bottomNavigationView.setupWithNavController(cbcnewsNavHostFragment.findNavController())
    }
}
