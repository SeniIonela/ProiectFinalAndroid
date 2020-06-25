package com.example.finalproject2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject2.models.User;
import com.example.finalproject2.serverComunication.ServerCom;
import com.example.finalproject2.state.AuthState;

public class LoginActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToCreateAccount(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }


    public void performLogin(View view) {
        EditText email   = (EditText)findViewById(R.id.editTextTextEmailAddress);
        EditText pass   = (EditText)findViewById(R.id.editTextTextPassword);
        System.out.println(pass.getText().toString());
        ServerCom.login(email.getText().toString(), pass.getText().toString(), (User user) -> {
            AuthState.loggedinUser = user;
            Intent intnet = new Intent(this, MainAppActivity.class);
            startActivity(intnet);
        });
    }
}
