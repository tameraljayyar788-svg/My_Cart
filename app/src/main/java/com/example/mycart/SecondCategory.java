package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "SecondCategories",foreignKeys = @ForeignKey(entity = FirstCategory.class,parentColumns = "id"
        ,childColumns = "firstCategoryId",onDelete = ForeignKey.CASCADE),indices = @Index("firstCategoryId"))
public class SecondCategory {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nameSCategory")
    public String nameSCtegory;

    @ColumnInfo(name = "firstCategoryId")
    public int firstCategoryId;
}