package com.example.mycart;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert
    Long insertUser(User user);
     @Update
    void updateUser(User user);
    @Delete
    void deleteUser(User user);

    @Query("select * from User where email = :Email and password = :Password limit 1")
    User loginUser(String Email , String Password);
    @Query("select * from User where email = :Email limit 1")
    User getUserByEmail(String Email);

    @Query("select * from User where id = :Id limit 1")
    LiveData<User> getUserId(Long Id);

}
