package com.example.videogamesapp.tools.commons;

public class HttpRoutes {
    private static HttpRoutes instance = null;
    private static String bookDateListBaseUrl;

    private HttpRoutes() {
        bookDateListBaseUrl = "https://api.nytimes.com/svc/books/v3/lists/";
    }

    public static synchronized HttpRoutes getInstance() {
        if (instance == null)
            instance = new HttpRoutes();

        return instance;
    }
}
