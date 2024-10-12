package com.example.videogamesapp.data.remote.dto.responses;

import java.util.List;

public class MyBookResponse {
    private String status;
    private String copyright;
    private int num_results;
    private String last_modified;
    private Results results;

    public static class Results {
        private String list_name;
        private String list_name_encoded;
        private String bestsellers_date;
        private String published_date;
        private String published_date_description;
        private String next_published_date;
        private String previous_published_date;
        private String display_name;
        private int normal_list_ends_at;
        private String updated;
        private List<Book> books;

        public static class Book {
            private int rank;
            private int rank_last_week;
            private int weeks_on_list;
            private int asterisk;
            private int dagger;
            private String primary_isbn10;
            private String getPrimary_isbn13;
            private String publisher;
            private String description;
            private String price;
            private String title;
            private String author;
            private String contributor;
            private String contributor_note;
            private String book_image;
            private int book_image_width;
            private int book_image_height;
            private String amazon_product_url;
            private String age_group;
            private String book_review_link;
            private String first_chapter_link;
            private String sunday_review_link;
            private List<Isbns> isbns;
            private List<BuyLinks> buy_links;
            private String book_uri;

            public static class Isbns {
                private String isbn10;
                private String isbn13;
            }

            public static class BuyLinks {
                private String name;
                private String url;
            }

        }
    }
}

