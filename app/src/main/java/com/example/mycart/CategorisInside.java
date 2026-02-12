package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "isideCategory",foreignKeys = @ForeignKey(entity = SecondCategory.class,parentColumns = "id",
        childColumns = "SecondCategoryId",onDelete = ForeignKey.CASCADE),indices = @Index("SecondCategoryId"))
public class CategorisInside {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "SecondCategory")
    public int SecondCategory;
}
