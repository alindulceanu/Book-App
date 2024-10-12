package com.example.videogamesapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.videogamesapp.data.remote.services.BookDateListService;
import com.example.videogamesapp.data.repositories.BookDateListRepository;
import com.example.videogamesapp.data.repositories.BookListsSimplified;
import com.example.videogamesapp.tools.commons.HttpRoutes;
import com.example.videogamesapp.ui.fragment_first.FragmentFirst;
import com.example.videogamesapp.ui.fragment_second.FragmentSecond;
import com.google.gson.internal.GsonBuildConfig;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    Button buttonFragmentFirst, buttonFragmentSecond;
    FragmentFirst firstFragment;
    FragmentSecond secondFragment;
    FragmentManager fragmentManager;

    @Inject
    BookDateListRepository bookDateListRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFragmentFirst = findViewById(R.id.btnFragment1);
        buttonFragmentSecond = findViewById(R.id.btnFragment2);

        firstFragment = new FragmentFirst();
        secondFragment = new FragmentSecond();

        fragmentManager = getSupportFragmentManager();

        buttonFragmentFirst.setOnClickListener(v -> { replaceFragment(R.id.fragment, firstFragment); });

        buttonFragmentSecond.setOnClickListener(v -> { replaceFragment(R.id.fragment, secondFragment); });

        if (savedInstanceState == null) {
            replaceFragment(R.id.fragment, firstFragment);
        }

        BookListsSimplified bookListsSimplified = new BookListsSimplified()
                .setListName("Combined Print and E-Book Fiction")
                .setListDiplayName("Combined Print & E-Book Fiction");

        bookDateListRepository.addMoreMovies(bookListsSimplified)
                .subscribe(() -> Log.d("MainActivity", "Books added successfully"),
                        throwable -> Log.e("MainActivity", "Error adding books: " + throwable.getMessage()));

    }

    private void replaceFragment(int fragmentViewId, Fragment newFragment) {
        fragmentManager.beginTransaction()
                .replace(fragmentViewId, newFragment)
                .commit();
    }
}

