package com.example.mycart;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SubCategoryDao {

    @Insert
    long insert(SubCategory subCategory);

    @Update
    void update(SubCategory subCategory);

    @Delete
    void delete(SubCategory subCategory);

    @Query("SELECT * FROM sub_categories WHERE main_category_id = :mainCategoryId")
    LiveData<List<SubCategory>> getSubCategoriesByMainId(int mainCategoryId);

    @Query("SELECT * FROM sub_categories WHERE id = :id")
    LiveData<SubCategory> getSubCategoryById(int id);

    @Query("DELETE FROM sub_categories WHERE main_category_id = :mainCategoryId")
    void deleteByMainCategoryId(int mainCategoryId);
}
