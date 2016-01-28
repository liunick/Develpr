package com.example.nl.develpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Title extends AppCompatActivity implements View.OnClickListener {

    Button bTitleLogin, bTitleRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bTitleLogin = (Button) findViewById(R.id.bTitleLogin);
        bTitleRegister = (Button) findViewById(R.id.bTitleRegister);

        bTitleLogin.setOnClickListener(this);
        bTitleRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bTitleLogin:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.bTitleRegister:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }
}
