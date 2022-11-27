package com.rodavid20.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        EditText emailtext = findViewById(R.id.etEmail);
        EditText passwtext = findViewById(R.id.etPassword);
        Button signin = findViewById(R.id.btnLogin);
        Button reg = findViewById(R.id.btnRegister);
        if (emailtext.getText().toString() == "" | passwtext.getText().toString() == "") {
            signin.setOnClickListener(view -> Toast.makeText(this, "Please fill the empty fileds", Toast.LENGTH_SHORT).show());
        }
        else {

        }
    }
}