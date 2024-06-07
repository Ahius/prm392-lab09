package com.example.se161047_lab04;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText us, pw;
    Button login;

    private final String REQUIRE = "Require";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        us = findViewById(R.id.username);
        pw = findViewById(R.id.password);
        login = findViewById(R.id.btnSignIn);

        login.setOnClickListener(this);



    }

    private boolean checkSignIn() {
        if(TextUtils.isEmpty(us.getText().toString())) {
            us.setError(REQUIRE);
            return false;
        }

        if(TextUtils.isEmpty(pw.getText().toString())) {
            pw.setError(REQUIRE);
            return false;
        }

        return true;
    }
    private void signIn() {
    if(checkSignIn() && TextUtils.equals(us.getText().toString(), "user") && TextUtils.equals(pw.getText().toString(), "123")) {
        Intent intent =new Intent(this, OrderFoodAndDrink.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSignIn){
            signIn();
        }
    }
}