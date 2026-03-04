package com.example.mycart;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "cart",
        foreignKeys = {
                @ForeignKey(
                        entity = table_product.class,
                        parentColumns = "id",
                        childColumns = "productId",
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {@Index("productId")}
)
public class table_cart {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int productId;

    public String name;

    public double price;

    public String image;

    public int quantity;

    public String size;

}
