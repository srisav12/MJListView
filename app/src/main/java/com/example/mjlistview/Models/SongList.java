package com.example.mjlistview.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SongList {
    @SerializedName("results")
    private List<Song> songDetails;

    public List<Song> getSongDetails() {
        return songDetails;
    }

    public void setSongDetails(List<Song> songDetails) {
        this.songDetails = songDetails;
    }


}
