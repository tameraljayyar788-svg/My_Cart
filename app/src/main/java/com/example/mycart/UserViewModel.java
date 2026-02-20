package com.example.mycart;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UserViewModel extends AndroidViewModel {
    private UserRepositry userRepositry;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepositry = new UserRepositry(application);
    }
    public Long insertUser(User user){
        return userRepositry.insertUser(user);

    }
    public void updateUser(User user){
        new Thread(()->
                userRepositry.updateUser(user)).start();
    }
    public void deleteUser(User user){
        new Thread(()->
                userRepositry.deleteUser(user)).start();
    }

    public LiveData<User> loginUser(String Email , String Password) {
        MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
        new Thread(() -> {
        User user = userRepositry.loginUser(Email,Password);
        userMutableLiveData.postValue(user);
        }).start();
        return userMutableLiveData;
    }
    public User getUserByEmail(String Email){
        return userRepositry.getUserByEmail(Email);
    }

    public LiveData<User> getUserId(Long Id){
        return userRepositry.getUserId(Id);
    }
}
