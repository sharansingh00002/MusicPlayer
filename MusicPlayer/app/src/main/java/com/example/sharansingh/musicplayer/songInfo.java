package com.example.sharansingh.musicplayer;

import android.content.Context;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

public class songInfo extends ActivityCompat {

    private String songName,artistName,url;

    public songInfo(String songName, String artistName, String url) {
        this.songName = songName;
        this.artistName = artistName;
        this.url = url;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongUrl() {
        return url;
    }
}
