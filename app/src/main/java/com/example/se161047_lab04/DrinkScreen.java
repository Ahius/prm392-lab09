package com.example.se161047_lab04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DrinkScreen extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 2;

    ListView drinkList;
    ArrayList<Drink> arrayDrink;

    DrinkAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drink_screen);

        mapping();
        adapter = new DrinkAdapter(this, R.layout.activity_drink, arrayDrink);
        drinkList.setAdapter(adapter);
        drinkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink selectedDrink = arrayDrink.get(position);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nameDrink", selectedDrink.getDrinkName());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }

    private void nextActivity(String drinkName) {
        Intent intent = new Intent(this, OrderFoodAndDrink.class);
        Intent resultIntent = new Intent();
        intent.putExtra("nameDrink", drinkName);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE && resultCode == RESULT_OK) {

        }
    }

    private void mapping() {
        drinkList = findViewById(R.id.drinkLv);
        arrayDrink= new ArrayList<>();

        arrayDrink.add(new Drink("Nuoc ep cam", "Apple is protect your health", R.drawable.ec));
        arrayDrink.add(new Drink("Nuoc ep Tao", "Apple is protect your health", R.drawable.img));
        arrayDrink.add(new Drink("Nuoc ep Oi", "Apple is protect your health", R.drawable.eo));
        arrayDrink.add(new Drink("Nuoc Chanh", "Apple is protect your health", R.drawable.nc));
        arrayDrink.add(new Drink("Nuoc ngot", "Apple is protect your health", R.drawable.nn));

    }
}