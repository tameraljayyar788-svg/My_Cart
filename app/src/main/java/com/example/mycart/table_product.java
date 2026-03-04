package com.example.mycart;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "products",
        foreignKeys = {
                @ForeignKey(
                        entity = table_category.class,
                        parentColumns = "id",
                        childColumns = "categoryId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("categoryId")}
)
public class table_product {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String description;

    public double price;

    public double discount;

    public int quantity;

    public String image;

    public int categoryId;
    public int rate;
    public String size;

    public boolean isActive;

    public long createdAt;
}
