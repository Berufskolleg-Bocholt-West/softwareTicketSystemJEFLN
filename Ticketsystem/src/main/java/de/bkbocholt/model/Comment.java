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

    public void Comment(int commentID, String createdBy, String content, Date createdOn, Date updatedOn, boolean visible) {
        this.commentID = commentID;
        this.createdBy = createdBy;
        this.content = content;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.visible = visible;
        this.attachments = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public void getCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void getCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void getContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void getCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void getUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void getVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible() {
        return visible;
    }

    public void getAttachments(ArrayList<File> attachments) {
        this.attachments = attachments;
    }

    public void getHistory(ArrayList<Comment> history) {
        this.history = history;
    }
}
