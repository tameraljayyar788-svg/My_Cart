package com.example.mycart;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Converters {

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    /**
     * يحول Long (timestamp) إلى Date للاستخدام في التطبيق
     * مثال: 1704067200000 → Date(2024-01-01)
     */
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    // ========== محولات القوائم النصية ==========

    /**
     * يحول List<String> إلى String مفصول بفواصل
     * مثال: ["صورة1.jpg", "صورة2.jpg"] → "صورة1.jpg,صورة2.jpg"
     */
    @TypeConverter
    public static String fromList(List<String> list) {
        if (list == null) return null;
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            if (sb.length() > 0) sb.append(",");
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * يحول String مفصول بفواصل إلى List<String>
     * مثال: "صورة1.jpg,صورة2.jpg" → ["صورة1.jpg", "صورة2.jpg"]
     */
    @TypeConverter
    public static List<String> toList(String data) {
        if (data == null) return null;
        return Arrays.asList(data.split(","));
    }

    // ========== محولات القوائم الرقمية ==========

    /**
     * يحول List<Integer> إلى String مفصول بفواصل
     * مثال: [1, 2, 3] → "1,2,3"
     */
    @TypeConverter
    public static String fromIntList(List<Integer> list) {
        if (list == null) return null;
        StringBuilder sb = new StringBuilder();
        for (Integer item : list) {
            if (sb.length() > 0) sb.append(",");
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * يحول String مفصول بفواصل إلى List<Integer>
     * مثال: "1,2,3" → [1, 2, 3]
     */
    @TypeConverter
    public static List<Integer> toIntList(String data) {
        if (data == null) return null;
        String[] items = data.split(",");
        Integer[] result = new Integer[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = Integer.parseInt(items[i]);
        }
        return Arrays.asList(result);
    }
}
