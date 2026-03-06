package com.example.mycart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addresses")
public class Address {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String fullName;

    public String phone;

    public String city;

    public String street;

    public String details;
}
