package com.example.instagramreplica.models;

public class PostModel {

    private String postBy;
    private String caption;
    private String post;
    private String authorPic, subHead;


    public PostModel(String postBy, String caption, String post, String authorPic, String subHead) {
        this.postBy = postBy;
        this.caption = caption;
        this.post = post;
        this.subHead = subHead;
        this.authorPic = authorPic;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAuthorPic() {
        return authorPic;
    }

    public void setAuthorPic(String authorPic) {
        this.authorPic = authorPic;
    }

    public String getSubHead() {
        return subHead;
    }

    public void setSubHead(String subHead) {
        this.subHead = subHead;
    }
}
