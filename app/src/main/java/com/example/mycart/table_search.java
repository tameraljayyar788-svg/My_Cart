package com.example.mycart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class table_search {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String query;

    private long searchedAt;

    public table_search(int id, String query, long searchedAt) {
        this.id = id;
        this.query = query;
        this.searchedAt = searchedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public long getSearchedAt() {
        return searchedAt;
    }

    public void setSearchedAt(long searchedAt) {
        this.searchedAt = searchedAt;
    }
}
