package com.madrish.ramalanzodiak.Adapter;

/**
 * Created by A MADRISH on 10/15/2016
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.madrish.ramalanzodiak.Activity.HasilRamal;
import com.madrish.ramalanzodiak.Activity.SejarahZodiak;
import com.madrish.ramalanzodiak.Activity.SettingsActivity;
import com.madrish.ramalanzodiak.Activity.WatakActivity;
import com.madrish.ramalanzodiak.Activity.ZodiakActivity;
import com.madrish.ramalanzodiak.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<CardSquare> cardSquareList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public MainAdapter(Context mContext, List<CardSquare> albumList) {
        this.mContext = mContext;
        this.cardSquareList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        CardSquare album = cardSquareList.get(position);
        holder.title.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                Intent a = null;
                switch (position){
                    case 0:
                        a = new Intent(mContext, SejarahZodiak.class);
                        mContext.startActivity(a);
                        break;
                    case 1:
                        a = new Intent(mContext, ZodiakActivity.class);
                        a.putExtra("menu", position);
                        mContext.startActivity(a);
                        break;
                    case 2:
                        a = new Intent(mContext, WatakActivity.class);
                        a.putExtra("menu", position);
                        mContext.startActivity(a);
                        break;
                    case 3:
                        //a = new Intent(mContext, SettingsActivity.class);
                        //mContext.startActivity(a);
                        break;
                    case 4:
                        a = new Intent(mContext, SettingsActivity.class);
                        mContext.startActivity(a);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return cardSquareList.size();
    }
}