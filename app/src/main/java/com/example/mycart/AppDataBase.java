package com.example.mycart;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        MainCategoryType.class,
        SubCategory.class,
        InnerCategory.class,
        Product.class
        , User.class
}, version = 1)

public abstract class AppDataBase extends RoomDatabase {

    public abstract MainCategoryTypeDao mainCategoryTypeDao();
    public abstract SubCategoryDao subCategoryDao();
    public abstract InnerCategoryDao innerCategoryDao();
    public abstract ProductDao productDao();
    public abstract UserDao userDao();


    private static volatile AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDataBase.class,
                            "MyCartDatabase"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}

