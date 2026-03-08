package com.example.mycart;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class repositry_insideCategory {
    private dao_CategorisInside dao;
    private ExecutorService executorService;

    public repositry_insideCategory(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        dao = dao_CategorisInside();
        executorService = Executors.newSingleThreadExecutor();
    }

    // Insert
    public void insert(table_CategorisInside category) {
        executorService.execute(() -> dao.insert(category));
    }

    public void insert(int secondCategoryId, String name, String icon, int position) {
        table_CategorisInside category = new table_CategorisInside(secondCategoryId, name, icon, position);
        executorService.execute(() -> dao.insert(category));
    }

    public void insertAll(List<table_CategorisInside> categories) {
        executorService.execute(() -> {
            for (table_CategorisInside category : categories) {
                dao.insert(category);
            }
        });
    }

    // Update
    public void update(table_CategorisInside category) {
        executorService.execute(() -> dao.update(category));
    }

    public void updateCategoryStatus(int categoryId, boolean isActive) {
        executorService.execute(() -> dao.updateCategoryStatus(categoryId, isActive));
    }

    public void updatePosition(int categoryId, int position) {
        executorService.execute(() -> dao.updatePosition(categoryId, position));
    }

    // Delete
    public void delete(table_CategorisInside category) {
        executorService.execute(() -> dao.delete(category));
    }

    public void deleteById(int categoryId) {
        executorService.execute(() -> dao.deleteById(categoryId));
    }

    public void deleteBySecondCategory(int secondCategoryId) {
        executorService.execute(() -> dao.deleteBySecondCategory(secondCategoryId));
    }

    // Read
    public LiveData<List<table_CategorisInside>> getCategoriesBySecondCategory(int secondCategoryId) {
        return dao.getCategoriesBySecondCategory(secondCategoryId);
    }

    public LiveData<table_CategorisInside> getCategoryById(int categoryId) {
        return dao.getCategoryById(categoryId);
    }

    public LiveData<List<table_CategorisInside>> getAllCategoriesBySecondCategory(int secondCategoryId) {
        return dao.getAllCategoriesBySecondCategory(secondCategoryId);
    }

    // Callback methods
    public void getActiveCountBySecondCategory(int secondCategoryId, CountCallback callback) {
        executorService.execute(() -> {
            int count = dao.getActiveCountBySecondCategory(secondCategoryId);
            callback.onResult(count);
        });
    }

    public void getMaxPositionBySecondCategory(int secondCategoryId, PositionCallback callback) {
        executorService.execute(() -> {
            int max = dao.getMaxPositionBySecondCategory(secondCategoryId);
            callback.onResult(max);
        });
    }

    public void insertWithAutoPosition(int secondCategoryId, String name, String icon) {
        executorService.execute(() -> {
            int maxPosition = dao.getMaxPositionBySecondCategory(secondCategoryId);
            table_CategorisInside newCategory = new table_CategorisInside(
                    secondCategoryId, name, icon, maxPosition + 1
            );
            dao.insert(newCategory);
        });
    }

    // Callback interfaces
    public interface CountCallback { void onResult(int count); }
    public interface PositionCallback { void onResult(int position); }
}
