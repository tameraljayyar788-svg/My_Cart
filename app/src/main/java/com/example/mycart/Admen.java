package com.example.mycart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycart.databinding.ActivityAdmenBinding;

public class Admen extends AppCompatActivity {

    ActivityAdmenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityAdmenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.more1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.card1.getVisibility() == View.VISIBLE) {
                    binding.card1.setVisibility(View.GONE);
                } else {
                    binding.card1.setVisibility(View.VISIBLE);
                }

            }
        });
        binding.more2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.card2.getVisibility() == View.VISIBLE) {
                    binding.card2.setVisibility(View.GONE);
                } else {
                    binding.card2.setVisibility(View.VISIBLE);
                }

            }
        });
        binding.more3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.card3.getVisibility() == View.VISIBLE) {
                    binding.card3.setVisibility(View.GONE);
                } else {
                    binding.card3.setVisibility(View.VISIBLE);
                }

            }
        });
        binding.more4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.card4.getVisibility() == View.VISIBLE) {
                    binding.card4.setVisibility(View.GONE);
                } else {
                    binding.card4.setVisibility(View.VISIBLE);
                }

            }
        });
        binding.more5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.card5.getVisibility() == View.VISIBLE) {
                    binding.card5.setVisibility(View.GONE);
                } else {
                    binding.card5.setVisibility(View.VISIBLE);
                }

            }
        });

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admen.this,login.class);
                startActivity(intent);
            }
        });
    }
}