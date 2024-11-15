package com.dhanashri.productsapplication1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.productsapplication1.R;

public class LoginActivity extends AppCompatActivity {

    EditText textEmail,textPassword;
    TextView registerUser;
    Button button;
    CheckBox checkbox;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail=findViewById(R.id.textEmail);
        textPassword=findViewById(R.id.textPassword);
        registerUser=findViewById(R.id.registerUser);
        registerUser.setOnClickListener(v -> startActivity(new Intent(this,RegisterActivity.class)));

    }

    public void login(View view){
        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();

    }
}
