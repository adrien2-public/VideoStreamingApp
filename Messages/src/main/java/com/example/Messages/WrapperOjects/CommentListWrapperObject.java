package com.example.Messages.WrapperOjects;

import com.example.Messages.Entity.Comment;

import java.util.List;

public class CommentListWrapperObject {

    private List<Comment> commentList;

    public CommentListWrapperObject(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public CommentListWrapperObject() {

    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addCommentList( Comment comment) {
        this.commentList.add(comment);
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
