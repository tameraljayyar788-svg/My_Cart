package com.example.mycart;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MainCategoryTypeDao {

    @Insert
    void insert(MainCategoryType category);

    @Insert
    void insertAll(List<MainCategoryType> categories);

    @Update
    void update(MainCategoryType category);

    @Delete
    void delete(MainCategoryType category);

    @Query("SELECT * FROM main_categories ORDER BY id ASC")
    LiveData<List<MainCategoryType>> getAllCategories();

    @Query("SELECT * FROM main_categories WHERE id = :id")
    LiveData<MainCategoryType> getCategoryById(int id);
}
