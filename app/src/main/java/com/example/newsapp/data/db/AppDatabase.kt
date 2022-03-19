package com.example.newsapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsItemDbModel::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    companion object {

        private lateinit var INSTANCE: NewsDatabase
        private const val DB_NAME = "news.db"

        fun getDatabase(context: Context): NewsDatabase{
            synchronized(NewsDatabase::class.java){
                if (!::INSTANCE.isInitialized){
                    INSTANCE=Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        DB_NAME
                    )
                        .build()
                }
            }
            return INSTANCE
        }
    }
    abstract fun newsDao():NewsDAO
}