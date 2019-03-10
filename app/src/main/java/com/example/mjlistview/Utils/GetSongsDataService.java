package com.example.mjlistview.Utils;

import com.example.mjlistview.Models.SongList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSongsDataService {

    @GET("/search?term=Michael+jackson")
    Call<SongList> getAllUsers();

}
