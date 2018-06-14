package com.example.sharansingh.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class CurrentSong extends AppCompatActivity {


 static songInfo songInfo1;

    static MediaPlayer mediaPlayer;
TextView songname;
ImageView albumimage;
Button playsong;
static int count;
Bitmap bitmap;
MediaMetadataRetriever mmr=new MediaMetadataRetriever();
int position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_play);
        songname=(TextView)findViewById(R.id.csongtext);
        playsong=(Button)findViewById(R.id.play_button);
        albumimage=(ImageView)findViewById(R.id.albumpic);
        mediaPlayer=new MediaPlayer();
        songname.setText(songInfo1.getSongName());

        mmr.setDataSource(songInfo1.getSongUrl());
        byte[] data = mmr.getEmbeddedPicture();
        bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
        albumimage.setImageBitmap(bitmap);

    }

    void playsong(View view)
    {if(count==-1){
       if(mediaPlayer!=null){

            mediaPlayer.stop();
            mediaPlayer = null;
            Toast.makeText(this,"chala yeh ",Toast.LENGTH_SHORT).show();

       }}
        count=count+1;
    if(count!=-1 && count%2==0){
        Toast.makeText(this,"cond one ",Toast.LENGTH_SHORT).show();


            mediaPlayer=new MediaPlayer();
            try {
                mediaPlayer.setDataSource(songInfo1.getSongUrl());

            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                mediaPlayer.prepare();
                Toast.makeText(this,"chala yeh2 ",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this,"chala yeh3 ",Toast.LENGTH_SHORT).show();

            }
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    mediaPlayer.start();


                }
            });

    }
else if(count!=-1)
    {
        Toast.makeText(this,"cond two ",Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();

        mediaPlayer = null;
    }



}



}

