package com.example.videogamesapp.data.remote.services;

import com.example.videogamesapp.data.remote.dto.responses.BookDateListResponse;
import com.example.videogamesapp.data.remote.dto.responses.BookLists;
import com.example.videogamesapp.data.remote.dto.responses.MyBookResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookDateListService {

    @GET("/svc/books/v3/lists/{date}/{list}.json")
    Single<BookDateListResponse> getBooksByDateAndList(
            @Path("date") String date,
            @Path("list") String list,
            @Query("api-key") String apiKey
    );

    @GET("/svc/books/v3/lists/names.json")
    Single<BookLists> getBookLists(
            @Query("api-key") String apiKey
    );
}
