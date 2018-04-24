package com.example.appinventiv.dailystories.samplereplies;

import com.example.appinventiv.dailystories.base.BasePresenter;
import com.example.appinventiv.dailystories.pojo.Comments;

import org.w3c.dom.Comment;

import java.util.ArrayList;

/**
 * Created by appinventiv on 23/4/18.
 */

public class CommentsPresenter extends BasePresenter<CommentsView> implements CommentsModelListener{
    private CommentModel mCommentModel;
    public CommentsPresenter(CommentsView view) {
        super(view);
    }

    @Override
    public void addModel() {
        mCommentModel=new CommentModel(this);
    }

    @Override
    public void destory() {
        mCommentModel.detachListener();
        mCommentModel=null;
    }

    public void kidsCommented(ArrayList<Integer> kids)
    {
        mCommentModel.fetchRandomComments(kids);
    }

    @Override
    public void getRandomCommentsFromApi(Comments comment) {
        getView().showRandomComments(comment);
    }
}
