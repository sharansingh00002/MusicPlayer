package com.example.sharansingh.musicplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.SongHolder> {
    MediaMetadataRetriever mmr=new MediaMetadataRetriever();
    Bitmap bitmap;
    OnItemClickListener onItemClickListener;
    Context context;
    private ArrayList<songInfo> arrayList;
    public recyclerAdapter(Context c, ArrayList<songInfo> arrayList) {
    context=c;
    this.arrayList = arrayList;
    }



    public interface OnItemClickListener{

        void onItemClick(LinearLayout b, View v, songInfo songinfo, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View myView = LayoutInflater.from(context).inflate(R.layout.songs, parent, false);

        return (new SongHolder(myView));
    }

    @Override
    public void onBindViewHolder(@NonNull final SongHolder holder, final int position) {

        final songInfo c=arrayList.get(position);
        holder.artistName.setText(c.getArtistName().toString());
        holder.songName.setText(c.getSongName().toString());


        mmr.setDataSource(c.getSongUrl());
        byte[] data = mmr.getEmbeddedPicture();
        if(data!=null){
        bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
        holder.albpic.setImageBitmap(bitmap);
        }
        else {
            holder.albpic.setBackgroundResource(R.drawable.playy);
        }



        holder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null)
                {
                    onItemClickListener.onItemClick(holder.linearlayout,v,c,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView songName,artistName;
        Button btnAction;
        ImageView albpic;
        LinearLayout linearlayout;
        public SongHolder(View itemView) {
            super(itemView);
            songName=(TextView)itemView.findViewById(R.id.songName);
            artistName=(TextView)itemView.findViewById(R.id.artistName);
            albpic=(ImageView)itemView.findViewById(R.id.albpic);
            linearlayout=(LinearLayout)itemView.findViewById(R.id.linearlayoutsongs);

        }
    }
}
