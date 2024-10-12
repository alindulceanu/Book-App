package com.example.videogamesapp.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.videogamesapp.data.local.entities.BookDateListEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface BookDateListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertBooks(List<BookDateListEntity> Books);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBook(BookDateListEntity Book);

    @Query("DELETE FROM BookDateListEntity")
    void deleteAllBooks();

}
