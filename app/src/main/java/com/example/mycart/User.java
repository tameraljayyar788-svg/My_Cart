package com.example.mycart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Table User
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String imageProfile;

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
