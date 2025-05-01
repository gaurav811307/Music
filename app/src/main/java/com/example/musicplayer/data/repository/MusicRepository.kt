package com.example.musicplayer.data.repository

import com.example.musicplayer.data.api.RetrofitInstance
import com.example.musicplayer.data.model.Song

class MusicRepository {
    suspend fun fetchSongs(): List<Song> {
        return RetrofitInstance.api.getData("eminem").data1.map { apiSong ->
            Song(
                id = apiSong.id,
                title = apiSong.title,
                artist = apiSong.artist.name,
                album = apiSong.album.cover_medium,
                preview = apiSong.preview
            )
        }
    }
}