package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "product_sizes",
        foreignKeys = {
                @ForeignKey(
                        entity = table_product.class,
                        parentColumns = "id",
                        childColumns = "productId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Sizes.class,
                        parentColumns = "id",
                        childColumns = "sizeId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("productId"), @Index("sizeId")}
)
public class table_productSizes {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "productId")
    public long productId;

    @ColumnInfo(name = "sizeId")
    public int sizeId;

    @ColumnInfo(name = "quantity")
    public int quantity;  // الكمية المتوفرة من هذا المقاس

    // Constructors
    public table_productSizes() {}

    public table_productSizes(long productId, int sizeId, int quantity) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.quantity = quantity;
    }
    }