package com.example.nl.develpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText etRegisterFirstName, etRegisterLastName, etRegisterEmail, etRegisterUser, etRegisterPass, etRegisterConfirm;
    ImageButton ibRegisterBack;
    Button bRegisterRegister;
    List<NameValuePair> params;
    ServerRequest sr;
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
                String userTxt = etRegisterEmail.getText().toString();
                String passwordTxt = etRegisterPass.getText().toString();
                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("email", userTxt));
                params.add(new BasicNameValuePair("password", passwordTxt));
                sr = new ServerRequest();
                JSONObject json = sr.getJSON("http://10.0.2.2:8080/register", params);

                if (json != null) {
                    try {
                        String jsonstr = json.getString("response");
                    Toast.makeText(getApplication(), jsonstr, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this, Title.class));
                        Log.d("hello", jsonstr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
