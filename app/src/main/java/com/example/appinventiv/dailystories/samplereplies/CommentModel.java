package com.example.appinventiv.dailystories.samplereplies;

import com.example.appinventiv.dailystories.base.BaseModel;
import com.example.appinventiv.dailystories.network.NetworkResponse;
import com.example.appinventiv.dailystories.pojo.Comments;
import com.example.appinventiv.dailystories.pojo.Example;
import com.example.appinventiv.dailystories.pojo.FailureResponse;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class CommentModel extends BaseModel<CommentsModelListener> {
    private ArrayList<Comments> commentArrayList;
    private String comment,reply;
    public CommentModel(CommentsModelListener listener) {
        super(listener);
        commentArrayList=new ArrayList<>();
    }

    public void fetchRandomComments(final ArrayList<Integer> comments)
    {
        getDataManager().getRandomCommentsAndReply("item/"+comments.get(0)+".json").enqueue(new NetworkResponse<Example>(this) {
            @Override
            public void onSuccess(Example body) {
                    if(body.getText()!=null)
                    {
                        comment=body.getText();
                    }
                    if(body.getKids()!=null)
                    {
                        showReply(body.getKids().get(0));
                    }
            }

            @Override
            public void onFailure(int code, FailureResponse failureResponse) {
                    getListener().onErrorOccured(failureResponse);
            }

            @Override
            public void onError(Throwable t) {
                    getListener().noNetworkError();
            }
        });
    }

    private void showReply(Integer integer) {
        getDataManager().getRandomCommentsAndReply("item/"+integer+".json").enqueue(new NetworkResponse<Example>(this) {
            @Override
            public void onSuccess(Example body) {
                Comments comments=new Comments();
                if(body.getText()!=null)
                {
                    reply=body.getText();
                    comments.setReply(reply);
                    comments.setComment(comment);
                }
                commentArrayList.add(comments);
                getListener().getRandomCommentsFromApi(comments);
            }

            @Override
            public void onFailure(int code, FailureResponse failureResponse) {
                getListener().onErrorOccured(failureResponse);
            }

            @Override
            public void onError(Throwable t) {
            }
        });
    }
}
