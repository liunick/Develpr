package com.example.nl.develpr;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ForgotPass extends AppCompatActivity implements View.OnClickListener {

    ImageButton ibForgotBack;
    EditText etForgotUser;
    Button bForgotReset;
    TextView tvForgotSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ibForgotBack = (ImageButton) findViewById(R.id.ibForgotBack);
        etForgotUser = (EditText) findViewById(R.id.etForgotUser);
        bForgotReset = (Button) findViewById(R.id.bForgotReset);
        tvForgotSuccess = (TextView) findViewById(R.id.tvForgotSuccess);

        bForgotReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bForgotReset:
                tvForgotSuccess.setVisibility(View.VISIBLE);
                //startActivity(new Intent(this, Login.class));
                break;
            case R.id.ibForgotBack:
                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}
