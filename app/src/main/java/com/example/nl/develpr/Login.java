package com.example.nl.develpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button bLoginLogin;
    private TextView tvLoginForgot, tvLoginRegister;
    private EditText etLoginUser, etLoginPass;
    private CheckBox cbLoginRemember;
    private ImageButton ibLoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bLoginLogin = (Button)findViewById(R.id.bLoginLogin);
        tvLoginForgot = (TextView) findViewById(R.id.tvLoginForgot);
        tvLoginRegister = (TextView) findViewById(R.id.tvLoginRegister);
        etLoginUser = (EditText) findViewById(R.id.etLoginUser);
        etLoginPass = (EditText) findViewById(R.id.etLoginPass);
        cbLoginRemember = (CheckBox) findViewById(R.id.cbLoginRemember);
        ibLoginBack = (ImageButton) findViewById(R.id.ibLoginBack);

        bLoginLogin.setOnClickListener(this);
        tvLoginForgot.setOnClickListener(this);
        tvLoginRegister.setOnClickListener(this);
        ibLoginBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bLoginLogin:
                break;
            case R.id.tvLoginForgot:
                startActivity(new Intent(this, ForgotPass.class));
                break;
            case R.id.tvLoginRegister:
                break;
            case R.id.ibLoginBack:
                startActivity(new Intent(this, Title.class));
                break;

        }
    }
}
