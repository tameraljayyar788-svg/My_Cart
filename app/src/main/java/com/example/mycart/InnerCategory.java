package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "inner_categories",
        foreignKeys = @ForeignKey(
                entity = SubCategory.class,
                parentColumns = "id",
                childColumns = "sub_category_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = @Index("sub_category_id"))
public class InnerCategory {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "sub_category_id")
    private int subCategoryId;

    // Constructor
    public InnerCategory(String name, int subCategoryId) {
        this.name = name;
        this.subCategoryId = subCategoryId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSubCategoryId() { return subCategoryId; }
    public void setSubCategoryId(int subCategoryId) { this.subCategoryId = subCategoryId; }
}
