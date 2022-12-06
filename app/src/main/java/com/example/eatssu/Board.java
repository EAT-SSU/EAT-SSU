package com.example.eatssu;

//제목, 본문 내용, 시간, 아이디, 좋아요 개수, 메시지 개수

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.ArrayList;
import java.util.Date;

public class Board {
    private String mTitle;
    private String mContent;
    private String mUid;
    private int mLikeCount;
    private int mMessageCount;
    private String mTimestamp;
    private String mTrimUID;
    //private int datetime;n
    //alt insert 하면 게터 세터 한번에 굿!

    private Board(){}


    public Board(String title, String content,String trimUID, int likeCount,int messageCount) {

        mTitle= title;
        mContent = content;
        mLikeCount=likeCount;
        mMessageCount=messageCount;
        mTrimUID=trimUID;
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
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getUid() {
        return mUid;
    }

    public void setUid(String mUid) {
        this.mUid = mUid;
    }

    public int getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(int mLikeCount) {
        this.mLikeCount = mLikeCount;
    }

    public int getMessageCount() {
        return mMessageCount;
    }

    public void setMessageCount(int mMessageCount) {
        this.mMessageCount = mMessageCount;
    }


    public String getTrimUID() {
        return mTrimUID;
    }

    public void setTrimUID(String mTrimUID) {
        this.mTrimUID = mTrimUID;
    }

    public String getTimestamp() { return mTimestamp; }

    public void setTimestamp(String timestamp) { mTimestamp = timestamp; }

}
