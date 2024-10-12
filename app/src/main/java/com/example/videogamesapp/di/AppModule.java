package com.example.videogamesapp.di;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.videogamesapp.data.local.dao.BookDateListDao;
import com.example.videogamesapp.data.local.databases.BookDateListDatabase;
import com.example.videogamesapp.data.remote.services.BookDateListService;
import com.example.videogamesapp.data.repositories.BookDateListRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public BookDateListDatabase provideDatabase(@ApplicationContext Context context) {
        BookDateListDatabase db = Room.databaseBuilder(
                        context,
                        BookDateListDatabase.class,
                        "GameDatabase"
                ).fallbackToDestructiveMigration() // Optional: this helps during development
                .build();

        Log.d("AppModule", "Database created: " + db);
        return db;
    }

    @Provides
    @Singleton
    public BookDateListDao provideGameDao(@NonNull BookDateListDatabase db) {
        return db.bookDateListDao();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public BookDateListService provideBookDateListService(@NonNull Retrofit client) {
        return client.create(BookDateListService.class);
    }

    @Provides
    @Singleton
    public BookDateListRepository provideBookDateListRepository(BookDateListService bookDateListService, BookDateListDao bookDateListDao) {
        return new BookDateListRepository(bookDateListService, bookDateListDao);
    }
}


