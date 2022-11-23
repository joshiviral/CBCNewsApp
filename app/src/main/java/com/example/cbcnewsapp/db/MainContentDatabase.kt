package com.example.cbcnewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cbcnewsapp.models.MainContent
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [MainContent::class],
    version = 1
)
abstract class MainContentDatabase : RoomDatabase() {

    abstract fun getMainContentDao(): MainContentDao

    companion object {
        @Volatile
        private var instance: MainContentDatabase? = null
        private val LOCK = Any()


        @InternalCoroutinesApi
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MainContentDatabase::class.java,
            "maincontent_db.db"
        ).build()
    }

}