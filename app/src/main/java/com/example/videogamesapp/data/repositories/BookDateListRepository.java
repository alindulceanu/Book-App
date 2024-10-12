package com.example.videogamesapp.data.repositories;

import static java.sql.Date.valueOf;
import android.os.Build;
import android.util.Log;

import com.example.videogamesapp.BuildConfig;
import com.example.videogamesapp.data.local.dao.BookDateListDao;
import com.example.videogamesapp.data.remote.dto.responses.BookDateListResponse;
import com.example.videogamesapp.data.remote.dto.responses.BookLists;
import com.example.videogamesapp.data.remote.services.BookDateListService;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

import javax.inject.Inject;

public class BookDateListRepository {

    private final BookDateListService service;
    private Date currentDate;
    private BookDateListDao bookDateListDao;
    private String lastDate;
    private Map<String, String> lastDates = new HashMap<>();

    @Inject
    public BookDateListRepository(BookDateListService service, BookDateListDao bookDateListDao) {
        this.service = service;
        this.bookDateListDao = bookDateListDao;
        currentDate = fetchCurrentDate();
    }

    private Date fetchCurrentDate() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                ? valueOf(String.valueOf(LocalDate.now()))
                : Calendar.getInstance().getTime();
    }

    private Completable fillBookDateListDatabase(Single<BookDateListResponse> single) {
        return single
                .flatMapCompletable(books -> bookDateListDao.insertBooks(books.toEntity()))
                .doOnComplete(() -> {
                    Log.d("MyRepo", "fill worked");})
                .doOnError(e -> {Log.d("MyRepo", "Error filling db" + e.getMessage());});
    }

    public Single<List<BookListsSimplified>> getBookLists() {
        return service.getBookLists(BuildConfig.apiKey)
                .flatMap(BookLists::simplify);
    }

    public Completable addMoreMovies(BookListsSimplified bookListsSimplified) {
        String listName = bookListsSimplified.getListName();
        if (!lastDates.containsKey(listName)) {
            lastDates.put(listName, currentDate.toString());
        }

        return service.getBooksByDateAndList(lastDates.get(listName), listName, BuildConfig.apiKey)
                .flatMapCompletable( bookDateListResponse -> {
                    lastDates.put(listName, bookDateListResponse.getLast_modified());

                    return fillBookDateListDatabase(Single.just(bookDateListResponse));
                });
    }
}
