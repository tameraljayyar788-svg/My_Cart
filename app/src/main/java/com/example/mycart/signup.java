package com.example.mycart;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycart.databinding.ActivitySignupBinding;

public class signup extends AppCompatActivity {

    ActivitySignupBinding binding;
    private AppDataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = AppDataBase.getInstance(this);

        binding.signup.setOnClickListener(v -> {
            String name = binding.username.getText().toString().trim();
            String email = binding.email.getText().toString().trim();
            String password = binding.password.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "please enter your username", Toast.LENGTH_SHORT).show();
                return;
            }
            if (email.isEmpty()) {
                Toast.makeText(this, "please enter your email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "please enter your password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.length() < 6 || !password.matches(".*\\d.*") || !password.matches(".*[a-zA-Z].*")) {
                Toast.makeText(this, "password must be at least 6 characters and contain letters and numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            new Thread(() -> {
                User existingUser = db.userDao().getUserByEmail(email);
                if (existingUser != null) {
                    runOnUiThread(() ->
                            Toast.makeText(this, "This email is already registered", Toast.LENGTH_SHORT).show()
                    );
                    return;
                }
                User user = new User();
                user.setUsername(name);
                user.setEmail(email);
                user.setPassword(password);
                db.userDao().insertUser(user);
                runOnUiThread(() -> {
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(signup.this, login.class));
                    finish();
                });

            }).start();
        });

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this,login.class);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                startActivity(intent);
            }
        });


    }
}