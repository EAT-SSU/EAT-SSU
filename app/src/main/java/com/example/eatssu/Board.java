package com.example.eatssu;

class Board {
    String title;
    String content;

    Board(){}

    Board(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){return title;}
    public String getContent(){return content;}
}
