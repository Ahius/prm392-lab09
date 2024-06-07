package com.example.se161047_lab04;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

    public class FoodScreen extends AppCompatActivity {
        private static final int MY_REQUEST_CODE = 1;

        ListView foodList;
        ArrayList<Food> arrayFood;
        Button btnAdd;
        FoodAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_food_screen);
            foodList = findViewById(R.id.foodLv);
            btnAdd = findViewById(R.id.addnew);
            arrayFood = FoodDAO.getAll(FoodScreen.this);
            if (arrayFood == null) {
                arrayFood = new ArrayList<>();
            }
            adapter = new FoodAdapter(this, R.layout.activity_food_layout, arrayFood);


            foodList.setAdapter(adapter);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
                }
            });

            foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Food selectedFood = arrayFood.get(position);
                   Intent resultIntent = new Intent();
                   resultIntent.putExtra("nameFood", selectedFood.getFoodName());
                   setResult(RESULT_OK, resultIntent);
                   finish();
               }
           });


        }

        private void showDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(FoodScreen.this);
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog_add, null);
            builder.setView(view);
            Dialog dialog = builder.create();
            dialog.show();

            EditText tName = view.findViewById(R.id.nameAdd);
            EditText tDes = view.findViewById(R.id.desAdd);
            EditText tImg = view.findViewById(R.id.imgAdd);
            Button btnAdd = view.findViewById(R.id.AddNewFood);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = tName.getText().toString();
                    String des = tDes.getText().toString();
                    String img = tImg.getText().toString();
                    if (FoodDAO.insert(FoodScreen.this, name, des, img)) {
                        Toast.makeText(FoodScreen.this, "Add new food successfully!", Toast.LENGTH_SHORT).show();
                        arrayFood.clear();
                        arrayFood.addAll(FoodDAO.getAll(FoodScreen.this));
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(FoodScreen.this, "Add new food fail!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }





        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == MY_REQUEST_CODE && resultCode == RESULT_OK) {

            }
        }

    }