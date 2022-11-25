package com.example.eatssu;

//제목, 본문 내용, 시간, 아이디, 좋아요 개수, 메시지 개수

class Board {
    String title;
    String content;
    int id;
    int likeCount;
    int messageCount;
    int datetime;


    Board(){}

    Board(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){return title;}
    public String getContent(){return content;}
}
