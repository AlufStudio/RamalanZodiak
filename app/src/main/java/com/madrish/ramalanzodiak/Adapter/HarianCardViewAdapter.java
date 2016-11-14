package com.madrish.ramalanzodiak.Adapter;

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
import com.madrish.ramalanzodiak.Activity.HasilRamal;
import com.madrish.ramalanzodiak.R;

import java.util.List;

public class HarianCardViewAdapter extends RecyclerView.Adapter<HarianCardViewAdapter.MyViewHolder> {
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


    public HarianCardViewAdapter(Context mContext, List<CardSquare> albumList) {
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
        CardSquare album = cardSquareList.get(position);
        holder.title.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(mContext, HasilRamal.class);
                a.putExtra("bulan", String.valueOf(position+1));
                mContext.startActivity(a);
            }
        });
    }

    @Override
    public int getItemCount() {

        return cardSquareList.size();
    }
}