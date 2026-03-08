package com.example.mycart;
import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class repositry_product {
    private dao_product dao;
    private ExecutorService executorService;

    public repositry_product(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        dao = db.productDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    // Insert
    public void insert(table_product product) {
        executorService.execute(() -> dao.insertProduct(product));
    }

    // Update
    public void update(table_product product) {
        executorService.execute(() -> dao.updateProduct(product));
    }

    // Delete
    public void delete(table_product product) {
        executorService.execute(() -> dao.deleteProduct(product));
    }

    // Read
    public LiveData<table_product> getProductById(long productId) {
        return dao.getProductById(productId);
    }

    public LiveData<List<table_product>> getProductsByFirstCategory(int categoryId) {
        return dao.getProductsByFirstCategory(categoryId);
    }

    public LiveData<List<table_product>> getProductsBySecondCategory(int categoryId) {
        return dao.getProductsBySecondCategory(categoryId);
    }

    public LiveData<List<table_product>> getProductsByInsideCategory(int categoryId) {
        return dao.getProductsByInsideCategory(categoryId);
    }

    public LiveData<List<table_product>> getDiscountedProducts() {
        return dao.getProductsWithDiscount();
    }

    public LiveData<List<table_product>> getFeaturedProducts() {
        return dao.getFeaturedProducts();
    }

    public LiveData<List<table_product>> getBestSellingProducts() {
        return dao.getBestSellingProducts();
    }

    public LiveData<List<table_product>> getTopRatedProducts() {
        return dao.getTopRatedProducts();
    }

    public LiveData<List<table_product>> searchProducts(String query) {
        return dao.searchProducts(query);
    }

    public LiveData<List<table_product>> getAllActiveProducts() {
        return dao.getAllActiveProducts();
    }

    // Callback methods
    public void incrementSoldCount(long productId) {
        executorService.execute(() -> dao.incrementSoldCount(productId));
    }

    public void decreaseQuantity(long productId, int quantity) {
        executorService.execute(() -> dao.decreaseQuantity(productId, quantity));
    }

    public void getProductCountByFirstCategory(int categoryId, CountCallback callback) {
        executorService.execute(() -> {
            int count = dao.getProductCountByFirstCategory(categoryId);
            callback.onResult(count);
        });
    }

    public interface CountCallback {
        void onResult(int count);
    }
}
