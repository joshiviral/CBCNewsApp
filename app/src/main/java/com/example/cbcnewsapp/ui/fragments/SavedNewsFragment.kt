package com.androiddevs.cbcnewapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
//import com.androiddevs.cbcnewapp.R
import com.example.cbcnewsapp.R
import com.example.cbcnewsapp.ui.NewsActivity
import com.example.cbcnewsapp.ui.NewsViewModel

class SavedNewsFragment:Fragment(R.layout.fragment_saved_news) {

    lateinit var viewModel:NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

}