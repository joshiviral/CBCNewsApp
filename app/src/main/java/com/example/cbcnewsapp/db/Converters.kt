package com.example.cbcnewsapp.db


import androidx.room.TypeConverter
import com.example.cbcnewsapp.Images

class Converters {
    @TypeConverter
    fun fromImages(images: Images):String{
        return images.square_140
    }
    @TypeConverter
    fun toImages(images: String): Images {
        return Images(images)
    }
}