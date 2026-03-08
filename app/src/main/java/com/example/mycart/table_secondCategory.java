package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "second_categories",
        foreignKeys = @ForeignKey(
                entity = FirstCategory.class,
                parentColumns = "id",
                childColumns = "firstCategoryId",
                onDelete = ForeignKey.CASCADE
        ),
        indices = @Index("firstCategoryId")
)
public class table_secondCategory {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "firstCategoryId")
    public int firstCategoryId;

    @ColumnInfo(name = "icon")
    public String icon;

    @ColumnInfo(name = "isActive")
    public boolean isActive = true;

    @ColumnInfo(name = "createdAt")
    public long createdAt = System.currentTimeMillis();

    // Constructors
    public table_secondCategory() {}

    public table_secondCategory(String name, int firstCategoryId, String icon) {
        this.name = name;
        this.firstCategoryId = firstCategoryId;
        this.icon = icon;
    }
}
