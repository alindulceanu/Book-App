package com.example.videogamesapp.data.remote.dto.responses;

import com.example.videogamesapp.data.local.entities.BookDateListEntity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class BookDateListResponse implements Serializable {
    private String copyright;

    private String last_modified;

    private Results results;

    private Integer num_results;

    private String status;

    public List<BookDateListEntity> toEntity() {
        List<BookDateListEntity> entities = new ArrayList<>();

        String category = this.getResults().getList_name();

        for (Results.Books book : this.getResults().getBooks()) {
            BookDateListEntity entity = new BookDateListEntity()
                    .withCategory(category)
                    .withRank(book.getRank())
                    .withPublisher(book.getPublisher())
                    .withDescription(book.getDescription())
                    .withPrice(book.getPrice())
                    .withTitle(book.getTitle())
                    .withAuthor(book.getAuthor())
                    .withBookImage(new BookDateListEntity.BookImage().withImage(book.book_image).withHeight(book.getBook_image_height()).withWidth(book.getBook_image_width()))
                    .withAmazonUrl(book.getAmazon_product_url())
                    .withBookReviewUrl(book.getBook_review_link())
                    .withBookReviewSundayUrl(book.getSunday_review_link());

            entities.add(entity);
        }

        return entities;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLast_modified() {
        return this.last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public Results getResults() {
        return this.results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public Integer getNum_results() {
        return this.num_results;
    }

    public void setNum_results(Integer num_results) {
        this.num_results = num_results;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Results implements Serializable {
        private String next_published_date;

        private String bestsellers_date;

        private List<Books> books;

        private String published_date_description;

        private Integer normal_list_ends_at;

        private String list_name;

        private String list_name_encoded;

        private String previous_published_date;

        private String display_name;

        private String published_date;

        private String updated;

        public String getNext_published_date() {
            return this.next_published_date;
        }

        public void setNext_published_date(String next_published_date) {
            this.next_published_date = next_published_date;
        }

        public String getBestsellers_date() {
            return this.bestsellers_date;
        }

        public void setBestsellers_date(String bestsellers_date) {
            this.bestsellers_date = bestsellers_date;
        }

        public List<Books> getBooks() {
            return this.books;
        }

        public void setBooks(List<Books> books) {
            this.books = books;
        }

        public String getPublished_date_description() {
            return this.published_date_description;
        }

        public void setPublished_date_description(String published_date_description) {
            this.published_date_description = published_date_description;
        }

        public Integer getNormal_list_ends_at() {
            return this.normal_list_ends_at;
        }

        public void setNormal_list_ends_at(Integer normal_list_ends_at) {
            this.normal_list_ends_at = normal_list_ends_at;
        }

        public String getList_name() {
            return this.list_name;
        }

        public void setList_name(String list_name) {
            this.list_name = list_name;
        }

        public String getList_name_encoded() {
            return this.list_name_encoded;
        }

        public void setList_name_encoded(String list_name_encoded) {
            this.list_name_encoded = list_name_encoded;
        }

        public String getPrevious_published_date() {
            return this.previous_published_date;
        }

        public void setPrevious_published_date(String previous_published_date) {
            this.previous_published_date = previous_published_date;
        }

        public String getDisplay_name() {
            return this.display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getPublished_date() {
            return this.published_date;
        }

        public void setPublished_date(String published_date) {
            this.published_date = published_date;
        }

        public String getUpdated() {
            return this.updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public static class Books implements Serializable {
            private List<Isbns> isbns;

            private String contributor_note;

            private Integer asterisk;

            private String description;

            private String primary_isbn10;

            private String primary_isbn13;

            private String title;

            private Integer weeks_on_list;

            private String article_chapter_link;

            private Integer book_image_width;

            private String contributor;

            private String amazon_product_url;

            private String price;

            private String book_uri;

            private Integer rank;

            private Integer dagger;

            private String author;

            private String age_group;

            private List<Buy_links> buy_links;

            private String sunday_review_link;

            private String book_review_link;

            private Integer book_image_height;

            private String book_image;

            private String publisher;

            private Integer rank_last_week;

            private String first_chapter_link;

            public List<Isbns> getIsbns() {
                return this.isbns;
            }

            public void setIsbns(List<Isbns> isbns) {
                this.isbns = isbns;
            }

            public String getContributor_note() {
                return this.contributor_note;
            }

            public void setContributor_note(String contributor_note) {
                this.contributor_note = contributor_note;
            }

            public Integer getAsterisk() {
                return this.asterisk;
            }

            public void setAsterisk(Integer asterisk) {
                this.asterisk = asterisk;
            }

            public String getDescription() {
                return this.description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPrimary_isbn10() {
                return this.primary_isbn10;
            }

            public void setPrimary_isbn10(String primary_isbn10) {
                this.primary_isbn10 = primary_isbn10;
            }

            public String getPrimary_isbn13() {
                return this.primary_isbn13;
            }

            public void setPrimary_isbn13(String primary_isbn13) {
                this.primary_isbn13 = primary_isbn13;
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getWeeks_on_list() {
                return this.weeks_on_list;
            }

            public void setWeeks_on_list(Integer weeks_on_list) {
                this.weeks_on_list = weeks_on_list;
            }

            public String getArticle_chapter_link() {
                return this.article_chapter_link;
            }

            public void setArticle_chapter_link(String article_chapter_link) {
                this.article_chapter_link = article_chapter_link;
            }

            public Integer getBook_image_width() {
                return this.book_image_width;
            }

            public void setBook_image_width(Integer book_image_width) {
                this.book_image_width = book_image_width;
            }

            public String getContributor() {
                return this.contributor;
            }

            public void setContributor(String contributor) {
                this.contributor = contributor;
            }

            public String getAmazon_product_url() {
                return this.amazon_product_url;
            }

            public void setAmazon_product_url(String amazon_product_url) {
                this.amazon_product_url = amazon_product_url;
            }

            public String getPrice() {
                return this.price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getBook_uri() {
                return this.book_uri;
            }

            public void setBook_uri(String book_uri) {
                this.book_uri = book_uri;
            }

            public Integer getRank() {
                return this.rank;
            }

            public void setRank(Integer rank) {
                this.rank = rank;
            }

            public Integer getDagger() {
                return this.dagger;
            }

            public void setDagger(Integer dagger) {
                this.dagger = dagger;
            }

            public String getAuthor() {
                return this.author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getAge_group() {
                return this.age_group;
            }

            public void setAge_group(String age_group) {
                this.age_group = age_group;
            }

            public List<Buy_links> getBuy_links() {
                return this.buy_links;
            }

            public void setBuy_links(List<Buy_links> buy_links) {
                this.buy_links = buy_links;
            }

            public String getSunday_review_link() {
                return this.sunday_review_link;
            }

            public void setSunday_review_link(String sunday_review_link) {
                this.sunday_review_link = sunday_review_link;
            }

            public String getBook_review_link() {
                return this.book_review_link;
            }

            public void setBook_review_link(String book_review_link) {
                this.book_review_link = book_review_link;
            }

            public Integer getBook_image_height() {
                return this.book_image_height;
            }

            public void setBook_image_height(Integer book_image_height) {
                this.book_image_height = book_image_height;
            }

            public String getBook_image() {
                return this.book_image;
            }

            public void setBook_image(String book_image) {
                this.book_image = book_image;
            }

            public String getPublisher() {
                return this.publisher;
            }

            public void setPublisher(String publisher) {
                this.publisher = publisher;
            }

            public Integer getRank_last_week() {
                return this.rank_last_week;
            }

            public void setRank_last_week(Integer rank_last_week) {
                this.rank_last_week = rank_last_week;
            }

            public String getFirst_chapter_link() {
                return this.first_chapter_link;
            }

            public void setFirst_chapter_link(String first_chapter_link) {
                this.first_chapter_link = first_chapter_link;
            }

            public static class Isbns implements Serializable {
                private String isbn13;

                private String isbn10;

                public String getIsbn13() {
                    return this.isbn13;
                }

                public void setIsbn13(String isbn13) {
                    this.isbn13 = isbn13;
                }

                public String getIsbn10() {
                    return this.isbn10;
                }

                public void setIsbn10(String isbn10) {
                    this.isbn10 = isbn10;
                }
            }

            public static class Buy_links implements Serializable {
                private String name;

                private String url;

                public String getName() {
                    return this.name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return this.url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
