package com.example.mycart;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "order_items",
        foreignKeys = {
                @ForeignKey(
                        entity = table_order.class,
                        parentColumns = "id",
                        childColumns = "orderId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = table_product.class,
                        parentColumns = "id",
                        childColumns = "productId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("orderId"), @Index("productId")}
)

public class order_item {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int orderId;

    public int productId;

    public String name;
    public double price;
    public String image;
    public int quantity;
    public String size;
}
