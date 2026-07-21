package com.litify.musicplayer.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.os.Build
import androidx.core.app.NotificationCompat
import com.litify.musicplayer.R
import com.litify.musicplayer.ui.activity.MainActivity
import timber.log.Timber

class MusicService : Service() {

    private val binder = MusicBinder()
    private var mediaPlayer: MediaPlayer? = null
    private var currentSpeed = 1.0f
    private var listeners = mutableListOf<PlayerListener>()

    inner class MusicBinder : Binder() {
        fun getService() = this@MusicService
    }

    interface PlayerListener {
        fun onPlaybackStateChanged(isPlaying: Boolean)
        fun onDurationChanged(duration: Long)
        fun onProgressChanged(progress: Long)
        fun onSongFinished()
        fun onError(message: String)
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        return START_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Music Playback",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }
    }

    fun playSong(filePath: String) {
        try {
            if (mediaPlayer != null) {
                mediaPlayer?.release()
            }

            mediaPlayer = MediaPlayer().apply {
                setDataSource(filePath)
                prepare()
                start()
                setSpeed(currentSpeed)
            }

            notifyListeners { it.onPlaybackStateChanged(true) }
            notifyListeners { it.onDurationChanged(mediaPlayer?.duration?.toLong() ?: 0) }

            mediaPlayer?.setOnCompletionListener {
                notifyListeners { it.onSongFinished() }
            }

        } catch (e: Exception) {
            Timber.e(e)
            notifyListeners { it.onError(e.message ?: "Unknown error") }
        }
    }

    fun pause() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
            notifyListeners { it.onPlaybackStateChanged(false) }
        }
    }

    fun resume() {
        if (mediaPlayer != null && !mediaPlayer!!.isPlaying) {
            mediaPlayer?.start()
            notifyListeners { it.onPlaybackStateChanged(true) }
        }
    }

    fun stop() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        notifyListeners { it.onPlaybackStateChanged(false) }
    }

    fun setSpeed(speed: Float) {
        currentSpeed = speed.coerceIn(0.5f, 2.0f)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                mediaPlayer?.playbackParams = mediaPlayer?.playbackParams?.setSpeed(currentSpeed)!!
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun seek(position: Long) {
        mediaPlayer?.seekTo(position.toInt())
    }

    fun getDuration(): Long = mediaPlayer?.duration?.toLong() ?: 0

    fun getCurrentPosition(): Long = mediaPlayer?.currentPosition?.toLong() ?: 0

    fun isPlaying(): Boolean = mediaPlayer?.isPlaying ?: false

    fun addListener(listener: PlayerListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: PlayerListener) {
        listeners.remove(listener)
    }

    private fun notifyListeners(action: (PlayerListener) -> Unit) {
        listeners.forEach { action(it) }
    }

    companion object {
        private const val CHANNEL_ID = "litify_music"
        private const val NOTIFICATION_ID = 1
    }
}