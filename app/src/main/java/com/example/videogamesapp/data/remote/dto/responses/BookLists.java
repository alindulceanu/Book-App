package com.example.videogamesapp.data.remote.dto.responses;

import com.example.videogamesapp.data.repositories.BookListsSimplified;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class BookLists implements Serializable {
    private String copyright;

    private List<Result> results;

    private Integer num_results;

    private String status;

    public Single<List<BookListsSimplified>> simplify() {
        List<BookListsSimplified> entities = new ArrayList<>();

        for(Result result : this.getResults()) {
            BookListsSimplified entity = new BookListsSimplified()
                    .setListName(result.getList_name())
                    .setListDiplayName(result.getDisplay_name());

            entities.add(entity);
        }

        return Single.just(entities);
    }

    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
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

    public static class Result implements Serializable {
        private String newest_published_date;

        private String oldest_published_date;

        private String list_name;

        private String list_name_encoded;

        private String display_name;

        private String updated;

        public String getNewest_published_date() {
            return this.newest_published_date;
        }

        public void setNewest_published_date(String newest_published_date) {
            this.newest_published_date = newest_published_date;
        }

        public String getOldest_published_date() {
            return this.oldest_published_date;
        }

        public void setOldest_published_date(String oldest_published_date) {
            this.oldest_published_date = oldest_published_date;
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

        public String getDisplay_name() {
            return this.display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getUpdated() {
            return this.updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }
    }
}
