package com.example.cbcnewsapp.ui

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.cbcnewsapp.models.Images

val PATH = "https://i.cbc.ca/1.6662014.1669248932!/fileImage/httpImage/image.jpg_gen/derivatives/square_140/1443951065.jpg"

fun ImageView.loadUrl(imageurl: String) = Glide.with(this).load(imageurl).into(this)