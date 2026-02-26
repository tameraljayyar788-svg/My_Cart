package com.example.mycart;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface InnerCategoryDao {

    @Insert
    long insert(InnerCategory innerCategory);

    @Update
    void update(InnerCategory innerCategory);

    @Delete
    void delete(InnerCategory innerCategory);

    @Query("SELECT * FROM inner_categories WHERE sub_category_id = :subCategoryId")
    LiveData<List<InnerCategory>> getInnerCategoriesBySubId(int subCategoryId);

    @Query("SELECT * FROM inner_categories WHERE id = :id")
    LiveData<InnerCategory> getInnerCategoryById(int id);

    @Query("DELETE FROM inner_categories WHERE sub_category_id = :subCategoryId")
    void deleteBySubCategoryId(int subCategoryId);
}

