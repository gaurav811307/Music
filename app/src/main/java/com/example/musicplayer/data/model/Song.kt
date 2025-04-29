package com.example.musicplayer.data.model


data class Song(
    val id: Long,
    val title: String,
    val artist: String,
    val album: String,
    val preview: String
)

data class Artist(
    val name: String
)

data class Album(
    val cover_medium: String
)