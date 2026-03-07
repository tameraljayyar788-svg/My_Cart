package com.example.mycart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class table_visa {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int country;
    private String F_name;
    private String L_name;
    private int phone;
    private String email;
    private String address1;
    private String address2;
    private String city;

    public table_visa(int id, int country, String f_name, String l_name, int phone, String email, String address1, String address2, String city) {
        this.id = id;
        this.country = country;
        F_name = f_name;
        L_name = l_name;
        this.phone = phone;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String l_name) {
        L_name = l_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
