package com.litify.musicplayer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.litify.musicplayer.data.dao.SongDao
import com.litify.musicplayer.data.dao.UserProfileDao
import com.litify.musicplayer.data.model.Song
import com.litify.musicplayer.data.model.UserProfile

@Database(
    entities = [Song::class, UserProfile::class],
    version = 1,
    exportSchema = false
)
abstract class LitifyDatabase : RoomDatabase() {
    
    abstract fun songDao(): SongDao
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        @Volatile
        private var INSTANCE: LitifyDatabase? = null

        fun getInstance(context: Context): LitifyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LitifyDatabase::class.java,
                    "litify_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}