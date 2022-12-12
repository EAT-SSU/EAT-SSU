package com.example.eatssu;

//제목, 본문 내용, 시간, 아이디, 좋아요 개수, 메시지 개수

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.ArrayList;
import java.util.Date;

public class Board {
    private String title;
    private String content;
    private String uid;
    private int likeCount;
    private int messageCount;
    private String timestamp;
    private String trimUid;
    //private int datetime;n
    //alt insert 하면 게터 세터 한번에 굿!

    private Board(){}

    public Board(String title, String content,String trimUid, int likeCount,int messageCount) {
        this.title= title;
        this.content = content;
        this.likeCount=likeCount;
        this.messageCount=messageCount;
        this.trimUid=trimUid;
    }
/*
    public static ArrayList<Board> createContactsList(int numContacts) {
        ArrayList<Board> contacts = new ArrayList<Board>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Board("오늘은 ", "배고파요","1799",2,3));
        }

        return contacts;
    }*/

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUid() {
        return uid;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTrimUid() {
        return trimUid;
    }
}