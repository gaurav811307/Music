package com.example.musicplayer.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import com.example.musicplayer.data.model.Song
import com.google.accompanist.pager.*

@Composable
fun SongCarousel(songs: List<Song>) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = songs.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 48.dp),
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        SongItem(song = songs[page])
    }
}
