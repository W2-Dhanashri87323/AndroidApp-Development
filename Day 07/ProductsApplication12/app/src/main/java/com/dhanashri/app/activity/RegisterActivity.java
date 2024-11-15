package com.dhanashri.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.app.R;
import com.dhanashri.app.entities.User;

public class RegisterActivity extends AppCompatActivity {
    EditText editName,editEmail,editPassword,editConfirmPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName=findViewById(R.id.editName);
        editEmail=findViewById(R.id.editEmail);
        editPassword=findViewById(R.id.editPassword);
        editConfirmPassword=findViewById(R.id.editConfirmPassword);
    }

    public void register(View view){
        String password = editPassword.getText().toString();
        String confirmPassword = editConfirmPassword.getText().toString();

        if(password.equals(confirmPassword)){
          User user = new User();
          user.setName(editName.getText().toString());
          user.setEmail(editEmail.getText().toString());
          user.setPassword(password);



        }
    }

}
