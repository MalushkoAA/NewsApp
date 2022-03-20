package com.example.newsapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsItemDbModel::class], version = 2, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    companion object {

        private var db: NewsDatabase? = null
        private const val DB_NAME = "news.db"

        fun getDatabase(context: Context): NewsDatabase {
            synchronized(NewsDatabase::class.java) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        NewsDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun newsDao(): NewsDAO
}