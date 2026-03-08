package com.example.mycart;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        // جدول المستخدمين
        User.class,

        // جداول التصنيفات
        FirstCategory.class,
        SecondCategory.class,
        CategorisInside.class,

        // جدول المنتجات
        table_product.class,

        // جداول المقاسات
        Sizes.class,
        table_productSizes.class,

        // جداول السلة والمفضلة
        table_cart.class,
        table_faivorate.class,

        // جداول العناوين
        Address.class,

        // جداول الطلبات
        table_order.class,
        order_item.class,

        // جداول البحث والإشعارات
        table_search.class,
        table_notifications.class,

        // جداول الدفع
        table_paymentMethode.class,
        table_visa.class
}, version = 2, exportSchema = false)

@TypeConverters({Converters.class})  // للتعامل مع أنواع البيانات المعقدة
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract table_firstCategoryDao firstCategoryDao();
    public abstract table_secondCategoryDao secondCategoryDao();
    public abstract table_CategorisInside daoTable_categorisInside();
    public abstract dao_product productDao();
    public abstract dao_cart cartDao();
    public abstract dao_favoraite favoriteDao();
    public abstract dao_order orderDao();
    public abstract dao_orderItem orderItemDao();
    public abstract dao_address addressDao();
    public abstract dao_search searchDao();
    public abstract dao_notification notificationDao();
    public abstract dao_paymentMethodde paymentMethodDao();
    public abstract dao_visa visaDao();
    public abstract dao_size sizeDao();
    public abstract dao_productSize productSizeDao();
    private static volatile AppDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDataBase.class,
                                    "MyCartDatabase")
                            .fallbackToDestructiveMigration()  // للتطوير فقط
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    }

