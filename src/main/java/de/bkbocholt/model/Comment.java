package de.bkbocholt.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;


public class Comment {
    public int commentID;
    public String createdBy;
    public String content;
    public Date createdOn;
    public Date updatedOn;
    public boolean visible;
    public ArrayList<File> attachments;
    public ArrayList<Comment> history;

    public Comment(int commentID, String createdBy, String content, Date createdOn, Date updatedOn, boolean visible) {
        this.commentID = commentID;
        this.createdBy = createdBy;
        this.content = content;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.visible = visible;
        this.attachments = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public void addAttachment(File attachment){
        this.attachments.add(attachment);
    }

    public void addHistory(Comment comment){
        this.history.add(comment);
    }

    public Comment addComment(String content, String createdBy){
        Comment comment = new Comment(this.history.size() + 1, createdBy, content, new Date(), new Date(), true);
        this.history.add(comment);
        return comment;
    }

}