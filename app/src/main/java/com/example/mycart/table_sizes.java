package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sizes")

public class table_sizes {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "sizeName")
    public String sizeName;  // S, M, L, XL, etc.

    @ColumnInfo(name = "category")
    public String category;  // ملابس، أحذية، إلخ

    // Constructors
    public table_sizes() {}

    public table_sizes(String sizeName, String category) {
        this.sizeName = sizeName;
        this.category = category;
    }
}
