package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView usercaller;
    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        usercaller = findViewById(R.id.userCaller);

        String username = getIntent().getStringExtra("username");

        if(username != null){
            usercaller.setText(username+"!");
        }

    }





}