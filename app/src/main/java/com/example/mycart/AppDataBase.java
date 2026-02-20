package com.example.mycart;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class},
        version = 1,exportSchema = false)


public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    private static final ExecutorService DB_Executor= Executors.newFixedThreadPool(1);

    public static volatile AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (AppDataBase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,"CourseHubRDB").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public static  ExecutorService getEcecutor(){
        return DB_Executor;
    }
    public static final ExecutorService dataWriteExcuter = Executors.newFixedThreadPool(4);
}

