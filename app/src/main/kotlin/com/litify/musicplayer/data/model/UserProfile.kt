package com.litify.musicplayer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey
    val id: Int = 1,
    val username: String = "User",
    val avatarPath: String? = null,
    val playbackSpeed: Float = 1.0f,
    val volumeLevel: Float = 0.7f,
    val favoriteSongId: Long? = null,
    val themeMode: Int = 0,
    val accentColor: Int = -11026089
)