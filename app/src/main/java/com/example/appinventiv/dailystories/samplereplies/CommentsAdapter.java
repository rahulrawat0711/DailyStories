package com.example.appinventiv.dailystories.samplereplies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appinventiv.dailystories.R;

/**
 * Created by appinventiv on 18/4/18.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentAdapterViewHolder> {
        private String title,comment,reply;

    public CommentsAdapter(String title, String comment, String reply)
    {
    this.title=title;
    this.comment=comment;
    this.reply=reply;
    }

    @Override
    public CommentAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.show_comments,parent,false));
    }

    @Override
    public void onBindViewHolder(CommentAdapterViewHolder holder, int position) {
            if(title!=null  && position==0 )
            {
                holder.tvComment.setText(title);
            }
            else if(position==1 && comment!=null)
            {
                holder.tvComment.setText(comment);
            }
            else
            {
                holder.tvComment.setText(reply);
            }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class CommentAdapterViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvComment;
         CommentAdapterViewHolder(View itemView) {
            super(itemView);
            tvComment=itemView.findViewById(R.id.tv_comments);
        }
    }
}
