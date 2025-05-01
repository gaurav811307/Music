package com.example.musicplayer.ui.main

import androidx.compose.foundation.layout.add
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayer.data.api.RetrofitInstance
import com.example.musicplayer.data.model.Song
import com.example.musicplayer.data.repository.MusicRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = MusicRepository()

    private val _songs = MutableLiveData<List<Song>>()
    val songs: LiveData<List<Song>> = _songs

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    private val _isPlaying = MutableLiveData(false)
    val isPlaying: LiveData<Boolean> = _isPlaying

    private val _playbackProgress = MutableLiveData(0f)
    val playbackProgress: LiveData<Float> = _playbackProgress

    init {
        fetchSongs()
        updateProgress()
    }


    private fun fetchSongs() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getData("eminem") // You can make this dynamic later
                val currentList = _songs.value.orEmpty().toMutableList() // Get the current list (or an empty one), and make it mutable
                currentList.add(
                    Song(
                        id = response.id,
                        title = response.title,
                        artist = response.artist,
                        album = response.album,
                        preview = response.preview
                    )
                )
                _songs.postValue(currentList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun togglePlayPause() {
        _isPlaying.value = !(_isPlaying.value ?: false)
    }

    private fun updateProgress() {
        viewModelScope.launch {
            while (true) {
                delay(1000L)
                _playbackProgress.value = (_playbackProgress.value ?: 0f) + 0.01f
            }
        }
    }
}