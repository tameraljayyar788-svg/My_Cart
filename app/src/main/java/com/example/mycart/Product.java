package com.example.mycart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "products",
        foreignKeys = @ForeignKey(
                entity = InnerCategory.class,
                parentColumns = "id",
                childColumns = "inner_category_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = @Index("inner_category_id"))
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "price")
    private double price;

    @ColumnInfo(name = "old_price")
    private double oldPrice;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "rating")
    private float rating;

    @ColumnInfo(name = "inner_category_id")
    private int innerCategoryId;

    // Constructor
    public Product(String name, double price, double oldPrice,
                   String description, String image, float rating, int innerCategoryId) {
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.innerCategoryId = innerCategoryId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getOldPrice() { return oldPrice; }
    public void setOldPrice(double oldPrice) { this.oldPrice = oldPrice; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    public int getInnerCategoryId() { return innerCategoryId; }
    public void setInnerCategoryId(int innerCategoryId) { this.innerCategoryId = innerCategoryId; }
}


