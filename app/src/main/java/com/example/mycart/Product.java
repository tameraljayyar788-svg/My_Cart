package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "products" , foreignKeys = @ForeignKey(entity = CategorisInside.class,parentColumns = "id",
childColumns = "CategoryInside",onDelete = ForeignKey.CASCADE),indices = @Index("CategoryInside"))
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nameProduct")
    public String nameProduct;

    @ColumnInfo(name = "NewPrice")
    public double Newprice;

    @ColumnInfo(name = "OldPrice")
    public double Oldprice;

    @ColumnInfo(name = "rateProduct")
    public float rate;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "imgProduct")
    public String ImgProduct;

    @ColumnInfo(name = "CategoryInside")
    public int CategoryInside;

}


