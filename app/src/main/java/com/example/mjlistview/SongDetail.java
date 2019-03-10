package com.example.mjlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mjlistview.Models.Song;

public class SongDetail extends Activity {
    
    private ImageView ivSongImage;
    private TextView tvSongName;
    private TextView tvSongAlbum;
    private Song song;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songdetail);
        init();
    }

    private void init() {
        song = getIntent().getExtras().getParcelable("data");
        ivSongImage = findViewById(R.id.iv_songimage);
        tvSongName = findViewById(R.id.tv_songname);
        tvSongAlbum = findViewById(R.id.tv_songalbum);
        loadData();
    }

    private void loadData() {
        tvSongName.setText(song.getTrackName());
        tvSongAlbum.setText(song.getTrackViewUrl());
        Glide.with(SongDetail.this).load(song.getPreviewUrl()).into(ivSongImage);
    }
}
