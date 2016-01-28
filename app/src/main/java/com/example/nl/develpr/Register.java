package com.example.nl.develpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText etRegisterFirstName, etRegisterLastName, etRegisterEmail, etRegisterUser, etRegisterPass, etRegisterConfirm;
    ImageButton ibRegisterBack;
    Button bRegisterRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etRegisterFirstName = (EditText) findViewById(R.id.etRegisterFirstName);
        etRegisterLastName = (EditText) findViewById(R.id.etRegisterLastName);
        etRegisterEmail = (EditText) findViewById(R.id.etRegisterEmail);
        etRegisterUser = (EditText) findViewById(R.id.etRegisterUser);
        etRegisterPass = (EditText) findViewById(R.id.etRegisterPass);
        etRegisterConfirm = (EditText) findViewById(R.id.etRegisterConfirm);
        ibRegisterBack = (ImageButton) findViewById(R.id.ibRegisterBack);
        bRegisterRegister = (Button) findViewById(R.id.bRegisterRegister);

        bRegisterRegister.setOnClickListener(this);
        ibRegisterBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.ibRegisterBack:
                startActivity(new Intent(this, Title.class));
                break;
            case R.id.bRegisterRegister:
                break;
        }
    }
}
