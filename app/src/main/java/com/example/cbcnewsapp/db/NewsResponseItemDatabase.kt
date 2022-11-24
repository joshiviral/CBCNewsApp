package com.example.cbcnewsapp.db

import android.content.Context
import androidx.room.*
import com.example.cbcnewsapp.models.NewsResponseItem
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [NewsResponseItem::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class NewsResponseItemDatabase : RoomDatabase() {

    abstract fun getNewsResponseItemDao(): NewsResponseItemtDao

    companion object {
        @Volatile

        // Recreating an instance which is single of our db
        private var instance: NewsResponseItemDatabase? = null
        private val LOCK = Any()


        @InternalCoroutinesApi
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NewsResponseItemDatabase::class.java,
            "newsresponseitem_db.db"
        ).build()
    }

}