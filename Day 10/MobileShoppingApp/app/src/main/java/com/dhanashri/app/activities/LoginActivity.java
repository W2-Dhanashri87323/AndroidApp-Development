package com.dhanashri.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.app.R;
import com.dhanashri.app.utils.Constants;


public class LoginActivity extends AppCompatActivity {

    EditText editemail, editpassword;
    TextView textregister;
    CheckBox checkbox;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        editemail = findViewById(R.id.editemail);
        editpassword = findViewById(R.id.editpassword);
        checkbox = findViewById(R.id.checkbox);

        if (getSharedPreferences(Constants.SP_FILENAME, MODE_PRIVATE).getBoolean(Constants.LOGIN_STATUS, false)) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
        textregister.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
    }

    public void Login(View view) {
        String email = editemail.getText().toString();
        String password = editpassword.getText().toString();

        if (email.equals("")){
            Toast.makeText(this,"Email can't be empty",Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show();
        }else {





        }

    }
}
























