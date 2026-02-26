package com.example.mycart;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    long insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("SELECT * FROM products WHERE inner_category_id = :innerCategoryId")
    LiveData<List<Product>> getProductsByInnerId(int innerCategoryId);

    @Query("SELECT * FROM products WHERE id = :id")
    LiveData<Product> getProductById(int id);

    @Query("SELECT * FROM products WHERE name LIKE '%' || :searchText || '%'")
    LiveData<List<Product>> searchProducts(String searchText);

    @Query("SELECT * FROM products WHERE old_price > price")
    LiveData<List<Product>> getDiscountedProducts();

    @Query("DELETE FROM products WHERE inner_category_id = :innerCategoryId")
    void deleteByInnerCategoryId(int innerCategoryId);
}

