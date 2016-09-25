package com.borombo.life.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.borombo.life.R;
import com.borombo.life.model.Post;

import java.util.ArrayList;

/**
 * Created by Phantom on 26/09/2016.
 */

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.DataObjectHolder> {

    private ArrayList<Post> posts;
    private static MyClickListener myClickListener;

    public RecyclerViewAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView label;
        TextView dateTime;

        DataObjectHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        RecyclerViewAdapter.myClickListener = myClickListener;
    }

    @Override
    public RecyclerViewAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_card, parent, false);

        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.DataObjectHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    interface MyClickListener {
        void onItemClick(int position, View v);
    }
}
