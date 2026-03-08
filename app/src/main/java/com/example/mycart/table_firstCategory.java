package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "first_categories")

public class table_firstCategory {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "icon")
    public String icon;

    @ColumnInfo(name = "position")
    public int position;

    @ColumnInfo(name = "isActive")
    public boolean isActive;

    @ColumnInfo(name = "createdAt")
    public long createdAt;

    // Constructor
    public table_firstCategory() {
        this.createdAt = System.currentTimeMillis();
        this.isActive = true;
    }
}