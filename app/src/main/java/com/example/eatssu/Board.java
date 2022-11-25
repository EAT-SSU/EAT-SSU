package com.example.eatssu;

//제목, 본문 내용, 시간, 아이디, 좋아요 개수, 메시지 개수

class Board {
    private String title;
    private String content;
    private int id;
    private int likeCount;
    private int messageCount;
    private int datetime;
//alt insert

    Board(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    //
//    Board(String title, String content){
//        this.title=title;
//        this.content=content;
//    }
//
//    public String getTitle(){return title;}
//    public String getContent(){return content;}
}
