package com.madrish.rz.Adapter;

/**
 * Created by A MADRISH on 10/15/2016
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.madrish.rz.Activity.HasilWatak;
import com.madrish.rz.R;

import java.util.List;

public class WatakCardViewAdapter extends RecyclerView.Adapter<WatakCardViewAdapter.MyViewHolder> {

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


    public WatakCardViewAdapter(Context mContext, List<CardSquare> albumList) {
        this.mContext = mContext;
        this.cardSquareList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.zodiak_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final CardSquare album = cardSquareList.get(position);
        holder.title.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(mContext, HasilWatak.class);
                a.putExtra("bulan", position);
                a.putExtra("zodiak", album.getName());
                mContext.startActivity(a);
            }
        });
    }

    @Override
    public int getItemCount() {

        return cardSquareList.size();
    }
}