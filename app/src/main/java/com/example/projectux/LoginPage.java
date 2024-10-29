package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    public LoginPage(){

    }

    private EditText usernameTxt;
    private EditText passwordTxt;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      init();
    }

    private void init(){
        usernameTxt = findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(view -> validateInput());
    }

    private void validateInput() {
        String username = usernameTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginPage.this,"All field must be filled",Toast.LENGTH_SHORT).show();
        }
        else if(usernameTxt.length() < 5){
            Toast.makeText(LoginPage.this,"Username must be at least 5 characters long",Toast.LENGTH_SHORT).show();
        }
        else if(passwordTxt.length() < 8 ){
            Toast.makeText(LoginPage.this,"Passowrd must be at least 8 characters long",Toast.LENGTH_SHORT).show();
        }
        else if(!password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$") ){
            Toast.makeText(LoginPage.this,"Password must be alpha numeric",Toast.LENGTH_SHORT).show();
        }


        else{
            Intent intent = new Intent(LoginPage.this, HomePage.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }
    }

}