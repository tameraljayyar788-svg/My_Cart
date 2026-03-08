package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "table_CategorisInside",  // اسم الجدول الجديد
        foreignKeys = @ForeignKey(
                entity = table_secondCategory.class,  // تأكد من وجود هذا الـ Entity
                parentColumns = "id",
                childColumns = "secondCategoryId",
                onDelete = ForeignKey.CASCADE
        ),
        indices = @Index("secondCategoryId")
)
public class table_CategorisInside {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "secondCategoryId")
    public int secondCategoryId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "icon")
    public String icon;

    @ColumnInfo(name = "position")
    public int position;

    @ColumnInfo(name = "isActive")
    public boolean isActive = true;

    @ColumnInfo(name = "createdAt")
    public long createdAt = System.currentTimeMillis();

    // Constructors
    public table_CategorisInside() {}

    public table_CategorisInside(int secondCategoryId, String name, String icon, int position) {
        this.secondCategoryId = secondCategoryId;
        this.name = name;
        this.icon = icon;
        this.position = position;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSecondCategoryId() { return secondCategoryId; }
    public void setSecondCategoryId(int secondCategoryId) { this.secondCategoryId = secondCategoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }
}