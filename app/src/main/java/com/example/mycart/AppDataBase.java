package com.example.mycart;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {
                User.class,
                Address.class,
                table_firstCategory.class,
                table_secondCategory.class,
                table_CategorisInside.class,
                table_category.class,
                table_product.class,
                table_sizes.class,
                table_productSizes.class,
                table_cart.class,
                table_faivorate.class,
                table_order.class,
                order_item.class,
                table_paymentMethode.class,
                table_visa.class,
                table_search.class,
                table_notifications.class
        },
        version = 1,
        exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {

    // DAOs
    public abstract UserDao userDao();
    public abstract AddressDao addressDao();
    public abstract FirstCategoryDao firstCategoryDao();
    public abstract SecondCategoryDao secondCategoryDao();
    public abstract CategorisInsideDao categorisInsideDao();
    public abstract CategoryDao categoryDao();
    public abstract ProductDao productDao();
    public abstract SizeDao sizeDao();
    public abstract ProductSizeDao productSizeDao();
    public abstract CartDao cartDao();
    public abstract FavoriteDao favoriteDao();
    public abstract OrderDao orderDao();
    public abstract OrderItemDao orderItemDao();
    public abstract PaymentMethodDao paymentMethodDao();
    public abstract VisaDao visaDao();
    public abstract SearchDao searchDao();
    public abstract NotificationDao notificationDao();

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
                                    "my_cart_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}