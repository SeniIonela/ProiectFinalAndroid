package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.finalproject2.state.AuthState;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(AuthState.UserAuthenticated){
            //launch main app
        }else{
            //launch login activity
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

    }
}