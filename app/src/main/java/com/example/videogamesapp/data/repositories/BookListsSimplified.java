package com.example.videogamesapp.data.repositories;

public class BookListsSimplified {
    private String listName;
    private String listDiplayName;

    public String getListName() {
        return listName;
    }

    public BookListsSimplified setListName(String listName) {
        this.listName = listName;
        return this;
    }

    public String getListDiplayName() {
        return listDiplayName;
    }

    public BookListsSimplified setListDiplayName(String listDiplayName) {
        this.listDiplayName = listDiplayName;
        return this;
    }
}
