package com.example.eatssu;

//제목, 본문 내용, 시간, 아이디, 좋아요 개수, 메시지 개수

import java.util.ArrayList;

class Board {
    private String title;
    private String content;
    private String id;
    private int likeCount;
    private int messageCount;
    //private int datetime;
//alt insert

    private Board(){}

    public Board(String title, String content,String id, int likeCount,int messageCount) {
        this.title = title;
        this.content = content;
        this.likeCount=likeCount;
        this.messageCount=messageCount;
        this.id=id;
    }

    public static ArrayList<Board> createContactsList(int numContacts) {
        ArrayList<Board> contacts = new ArrayList<Board>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Board("오늘은 ", "배고파요","1799",2,3));
        }

        return contacts;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
/*
    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }*/
}
