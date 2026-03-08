package com.example.mycart;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface dao_size {

    @Insert
    long insert(table_sizes size);

    @Query("SELECT * FROM sizes ORDER BY sizeName")
    LiveData<List<table_sizes>> getAllSizes();

    @Query("SELECT * FROM sizes WHERE sizeName = :category ORDER BY sizeName")
    LiveData<List<table_sizes>> getSizesByCategory(String category);

    @Query("SELECT * FROM sizes WHERE sizeName = :sizeName")
    LiveData<table_sizes> getSizeByName(String sizeName);
}
