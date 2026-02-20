package com.example.mycart;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class UserRepositry {
    private UserDao userDao;

    public UserRepositry(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        userDao = db.userDao();
    }

    public Long insertUser(User user){
       return userDao.insertUser(user);

    }
    public void updateUser(User user){
       userDao.updateUser(user);
    }
    public void deleteUser(User user){
        userDao.deleteUser(user);
    }

    public User loginUser(String Email , String Password){
        return userDao.loginUser(Email,Password);
    }
    public User getUserByEmail(String Email){
        return userDao.getUserByEmail(Email);
    }

    public LiveData<User> getUserId(Long Id){
        return userDao.getUserId(Id);
    }
}
