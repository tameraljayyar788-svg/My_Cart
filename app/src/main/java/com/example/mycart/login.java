package com.example.mycart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
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
import androidx.lifecycle.ViewModelProvider;

import com.example.mycart.databinding.ActivityLoginBinding;

public class login extends AppCompatActivity {

    ActivityLoginBinding binding;
    private UserViewModel userViewModel;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        binding.signup.setOnClickListener(v -> {
            Intent intent = new Intent(login.this,signup.class);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            startActivity(intent);
        });

        boolean isLogin = preferences.getBoolean("isLogin",false);
        if (isLogin){
            startActivity(new Intent(this,Main.class));
            finish();
            return;
        }

        binding.login.setOnClickListener(v -> {
            String email = binding.email.getText().toString().trim();
            String password = binding.password.getText().toString().trim();
            boolean remember = binding.remember.isChecked();
            if(email.isEmpty()){
                Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(password.isEmpty()){
                Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (email.equals("admin@gmail.com")&&password.equals("admin12345")){
                Toast.makeText(this, "Hi Admen", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Admen.class));
                finish();
                return;
            }
            userViewModel.loginUser(email,password).observe(this,user->{
                if (user != null){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putLong("user_id",user.getId());
                    editor.putString("user_email",user.getEmail());
                    editor.putString("user_password",user.getPassword());
                    editor.putString("user_name",user.getUsername());

                    if (remember){
                        editor.putBoolean("isLogin",true);
                    }
                    editor.apply();
                    Toast.makeText(this, "Hi " + user.getUsername(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this,Main.class));
                    finish();
                }else {
                    Toast.makeText(this, "your data is wrong", Toast.LENGTH_SHORT).show();
                }
            });

        });




    }
}