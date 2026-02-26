package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "sub_categories",
        foreignKeys = @ForeignKey(
                entity = MainCategoryType.class,
                parentColumns = "id",
                childColumns = "main_category_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = @Index("main_category_id"))
public class SubCategory {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "main_category_id")
    private int mainCategoryId;

    // Constructor
    public SubCategory(String name, int mainCategoryId) {
        this.name = name;
        this.mainCategoryId = mainCategoryId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(int mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }
}