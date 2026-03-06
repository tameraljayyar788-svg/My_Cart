package com.example.mycart;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "orders")
public class table_order {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String customerName;

    public double totalPrice;

    public String status;

    public String address;

    public String phone;

    public long createdAt;
}
