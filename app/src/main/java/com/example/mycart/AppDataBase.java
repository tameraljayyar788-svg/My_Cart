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
        // User Related Entities
        User.class,
        Address.class,
        
        // Category Entities
        table_firstCategory.class,
        table_secondCategory.class,
        table_CategorisInside.class,
        table_category.class,
        
        // Product Entities
        table_product.class,
        table_sizes.class,
        table_productSizes.class,
        
        // Cart & Favorite Entities
        table_cart.class,
        table_faivorate.class,
        
        // Order Entities
        table_order.class,
        order_item.class,
        
        // Payment Entities
        table_paymentMethode.class,
        table_visa.class,
        
        // Other Entities
        table_search.class,
        table_notifications.class
    },
    version = 1,
    exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {
    
    // ============= User DAOs =============
    public abstract UserDao userDao();
    public abstract AddressDao addressDao();
    
    // ============= Category DAOs =============
    public abstract FirstCategoryDao firstCategoryDao();
    public abstract SecondCategoryDao secondCategoryDao();
    public abstract CategorisInsideDao categorisInsideDao();
    public abstract CategoryDao categoryDao();
    
    // ============= Product DAOs =============
    public abstract ProductDao productDao();
    public abstract SizeDao sizeDao();
    public abstract ProductSizeDao productSizeDao();
    
    // ============= Cart & Favorite DAOs =============
    public abstract CartDao cartDao();
    public abstract FavoriteDao favoriteDao();
    
    // ============= Order DAOs =============
    public abstract OrderDao orderDao();
    public abstract OrderItemDao orderItemDao();
    
    // ============= Payment DAOs =============
    public abstract PaymentMethodDao paymentMethodDao();
    public abstract VisaDao visaDao();
    
    // ============= Other DAOs =============
    public abstract SearchDao searchDao();
    public abstract NotificationDao notificationDao();
    
    // ============= Singleton Pattern =============
    private static volatile AppDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    
    // ============= Get Instance Method =============
    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDataBase.class,
                                    "my_cart_database")
                            .fallbackToDestructiveMigration()  // For development only
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}