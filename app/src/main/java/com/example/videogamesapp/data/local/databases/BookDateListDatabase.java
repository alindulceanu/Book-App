package com.example.videogamesapp.data.local.databases;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.videogamesapp.data.local.dao.BookDateListDao;
import com.example.videogamesapp.data.local.entities.BookDateListEntity;

@Database(entities = {BookDateListEntity.class}, version = 1)
public abstract class BookDateListDatabase extends RoomDatabase {
    public abstract BookDateListDao bookDateListDao();
}
