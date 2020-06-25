package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.finalproject2.models.User;
import com.example.finalproject2.serverComunication.ServerCom;
import com.example.finalproject2.state.AuthState;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void performRegister(View view) {

        String name = ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString();
        String email = ((EditText) findViewById(R.id.editTextTextEmailAddress2)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextTextPassword2)).getText().toString();
        String phoneNR = ((EditText) findViewById(R.id.editTextPhoneNr)).getText().toString();

        ServerCom.register((User user) -> {
            AuthState.loggedinUser = user;
            Intent intent = new Intent(this, MainAppActivity.class);
            startActivity(intent);
        }, name, email, password, phoneNR);

    }
}