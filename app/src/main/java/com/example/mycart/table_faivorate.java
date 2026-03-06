package com.example.mycart;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "favorites",
        foreignKeys = {
                @ForeignKey(
                        entity = table_product.class,
                        parentColumns = "id",
                        childColumns = "productId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("productId")}
)
public class table_faivorate {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int productId;

    public long addedAt;
}
