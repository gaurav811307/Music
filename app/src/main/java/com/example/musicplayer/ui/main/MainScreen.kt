package com.example.musicplayer.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicplayer.ui.components.BottomMusicController
import com.example.musicplayer.ui.components.SongCarousel


@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {

    val songs by viewModel.songs.observeAsState(initial = emptyList())
    val isPlaying by viewModel.isPlaying.observeAsState(initial = false)
    val playbackProgress by viewModel.playbackProgress.observeAsState(initial = 0f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Spacer(modifier = Modifier.weight(1f))

        if (songs.isNotEmpty()) {
            SongCarousel(songs = songs)
        }
        Spacer(modifier = Modifier.weight(1f))
        BottomMusicController(
            isPlaying = isPlaying,
            onPlayPauseClick = { viewModel.togglePlayPause() },
            onNextClick = { /* TODO */ },
            onPreviousClick = { /* TODO */ },
            progress = playbackProgress
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Demo() {
    MainScreen()
}