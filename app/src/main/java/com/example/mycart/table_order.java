package com.example.mycart;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "orders")
public class table_order {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String customerName;

    private double totalPrice;

    private String status;

    private String address;

    private String phone;

    private long createdAt;

    public table_order(long id, String customerName, double totalPrice, String status, String address, String phone, long createdAt) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
