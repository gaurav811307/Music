package com.example.musicplayer.data.api

import android.telecom.Call
import com.example.musicplayer.data.MyData.myData
import com.example.musicplayer.data.model.Song
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MusicApiService {

    @Headers("x-rapidapi-key", "730450b039msh8f932efad1cc824p10f891jsn362ac0ad9be6",
        "x-rapidapi-host", "deezerdevs-deezer.p.rapidapi.com")

    @GET("search")

}