package com.example.videogamesapp.data.local.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BookDateListEntity")
public class BookDateListEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String category;
    private int rank;
    private String publisher;
    private String description;
    private String price;
    private String title;
    private String author;
    @Embedded private BookImage bookImage;
    private String amazonUrl;
    private String bookReviewUrl;
    private String bookReviewSundayUrl;

    public static class BookImage {
        private String image;
        private int width;
        private int height;

        public String getImage() {
            return image;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public BookImage withImage(String image) {
            this.image = image;
            return this;
        }

        public BookImage withWidth(int width) {
            this.width = width;
            return this;
        }

        public BookImage withHeight(int height) {
            this.height = height;
            return this;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookImage(BookImage bookImage) {
        this.bookImage = bookImage;
    }

    public void setAmazonUrl(String amazonUrl) {
        this.amazonUrl = amazonUrl;
    }

    public void setBookReviewUrl(String bookReviewUrl) {
        this.bookReviewUrl = bookReviewUrl;
    }

    public void setBookReviewSundayUrl(String bookReviewSundayUrl) {
        this.bookReviewSundayUrl = bookReviewSundayUrl;
    }

    public BookDateListEntity withCategory(String category) {
        this.category = category;
            return this;
    }
    public BookDateListEntity withRank(int rank) {
        this.rank = rank;
            return this;
    }
    public BookDateListEntity withPublisher(String publisher) {
        this.publisher = publisher;
            return this;
    }
    public BookDateListEntity withDescription(String description) {
        this.description = description;
            return this;
    }
    public BookDateListEntity withPrice(String price) {
        this.price = price;
            return this;
    }
    public BookDateListEntity withTitle(String title) {
        this.title = title;
            return this;
    }
    public BookDateListEntity withAuthor(String author) {
        this.author = author;
            return this;
    }
    public BookDateListEntity withBookImage(BookImage bookImage) {
        this.bookImage = bookImage;
            return this;
    }
    public BookDateListEntity withAmazonUrl(String amazonUrl) {
        this.amazonUrl = amazonUrl;
            return this;
    }
    public BookDateListEntity withBookReviewUrl(String bookReviewUrl) {
        this.bookReviewUrl = bookReviewUrl;
            return this;
    }
    public BookDateListEntity withBookReviewSundayUrl(String bookReviewSundayUrl) {
        this.bookReviewSundayUrl = bookReviewSundayUrl;
            return this;
    }
    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getRank() {
        return rank;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookImage getBookImage() {
        return bookImage;
    }

    public String getAmazonUrl() {
        return amazonUrl;
    }

    public String getBookReviewUrl() {
        return bookReviewUrl;
    }

    public String getBookReviewSundayUrl() {
        return bookReviewSundayUrl;
    }
}
