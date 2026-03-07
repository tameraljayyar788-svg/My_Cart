package com.example.mycart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class table_notifications {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String title;
    private String message;
    private Long timetamp;
    private String type;
    private String icon;


    public table_notifications(Long id, String title, String message, Long timetamp, String type, String icon) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.timetamp = timetamp;
        this.type = type;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(Long timetamp) {
        this.timetamp = timetamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
