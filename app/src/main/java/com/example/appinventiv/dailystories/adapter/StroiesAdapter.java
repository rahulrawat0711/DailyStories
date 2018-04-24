package com.example.appinventiv.dailystories.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appinventiv.dailystories.R;
import com.example.appinventiv.dailystories.interfaces.StorySelectedListener;
import com.example.appinventiv.dailystories.pojo.Stories;

import java.util.ArrayList;

/**
 * Created by appinventiv on 18/4/18.
 */

public class StroiesAdapter extends RecyclerView.Adapter<StroiesAdapter.StoriesViewHolder> {
    ArrayList<Stories> arrayList;
    StorySelectedListener storySelectedListener;
    public StroiesAdapter(ArrayList<Stories> value, StorySelectedListener storySelectedListener)
    {
        arrayList=value;
        this.storySelectedListener=storySelectedListener;
    }
    @Override
    public StoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_stories,parent,false);
        return new StoriesViewHolder(view);
    }
    @Override
    public void onBindViewHolder(StoriesViewHolder holder, int position) {
        holder.tvStories.setText(arrayList.get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
     class StoriesViewHolder extends RecyclerView.ViewHolder
    {
    public TextView tvStories;
        public StoriesViewHolder(View itemView) {
            super(itemView);
            tvStories=itemView.findViewById(R.id.tv_stories);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    storySelectedListener.onStoryClickedListener(getAdapterPosition());
                }
            });
        }
    }
}
