package com.example.appinventiv.dailystories.samplereplies;

import com.example.appinventiv.dailystories.base.BaseModelListener;
import com.example.appinventiv.dailystories.pojo.Comments;

import org.w3c.dom.Comment;

public interface CommentsModelListener extends BaseModelListener {
    public void getRandomCommentsFromApi(Comments comment);
}
