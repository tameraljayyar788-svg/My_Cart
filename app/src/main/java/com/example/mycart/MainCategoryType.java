package com.example.mycart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "main_categories")
    public class MainCategoryType {

        @PrimaryKey
        private int id;

        private String name;
        private String icon;

        // Constructor
        public MainCategoryType(int id, String name, String icon) {
            this.id = id;
            this.name = name;
            this.icon = icon;
        }

        // Getters and Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }
