package com.example.mycart;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "categories",
        foreignKeys = {
                @ForeignKey(
                        entity = table_category.class,
                        parentColumns = "id",
                        childColumns = "parentId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("parentId")}
)


public class table_category {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public Integer parentId;

    public String image;

    public Integer position;

    public Boolean isActive;

    public boolean isSystem;

    public long createdAt;
}
