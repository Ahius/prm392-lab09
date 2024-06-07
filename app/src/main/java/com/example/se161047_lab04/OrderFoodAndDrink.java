package com.example.se161047_lab04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderFoodAndDrink extends AppCompatActivity {
    private static final int REQUEST_FOOD = 1;
    private static final int REQUEST_DRINK = 2;
    Button orderFood, orderDrink;
    TextView tvFood, tvDrink;
    String foodName, drinkName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_food_and_drink);

        orderFood = findViewById(R.id.btnFood);
        orderDrink = findViewById(R.id.btnDrink);
        tvFood = findViewById(R.id.tvOderFood);
        tvDrink = findViewById(R.id.tvOderDrink);


        tvFood.setText(getIntent().getStringExtra("nameFood"));
        tvDrink.setText(getIntent().getStringExtra("nameDrink"));
//        Intent intent = getIntent();
//        String foodName = intent.getStringExtra("nameFood");
//        TextView foodNameTextView = findViewById(R.id.tvOder);
//        foodNameTextView.setText(foodName);
//        if (savedInstanceState != null) {
//            foodName = savedInstanceState.getString("foodName");
//            drinkName = savedInstanceState.getString("drinkName");
//            tvFood.setText(foodName);
//            tvDrink.setText(drinkName);
//        }

        orderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderFoodAndDrink.this, FoodScreen.class);
                startActivityForResult(intent, REQUEST_FOOD);

            }
        });

        orderDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderFoodAndDrink.this, DrinkScreen.class);
                startActivityForResult(intent, REQUEST_DRINK);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_FOOD) {
                foodName = data.getStringExtra("nameFood");
                tvFood.setText(foodName);
            } else if (requestCode == REQUEST_DRINK) {
                drinkName = data.getStringExtra("nameDrink");
                tvDrink.setText(drinkName);
            }
        }
    }
}