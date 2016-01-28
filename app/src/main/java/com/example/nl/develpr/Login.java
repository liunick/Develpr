package com.example.nl.develpr;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button bLoginLogin;
    private TextView tvLoginForgot, tvLoginRegister;
    private EditText etLoginUser, etLoginPass;
    private CheckBox cbLoginRemember;
    private ImageButton ibLoginBack;
    private List<NameValuePair> params;
    private SharedPreferences pref;
    private Dialog reset;
    private ServerRequest sr;

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

        pref = getSharedPreferences("AppPref", MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bLoginLogin:
                String userTxt = etLoginUser.getText().toString();
                String passTxt = etLoginPass.getText().toString();
                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("email", userTxt));
                params.add(new BasicNameValuePair("password", passTxt));
                sr = new ServerRequest();
                JSONObject json = sr.getJSON("http://10.0.2.2:8080/login", params); //160.39.139.155
                if (json != null) {
                    try {
                        String jsonStr = json.getString("response");
                        if (json.getBoolean("res")) {
                            String token = json.getString("token");
                            String grav = json.getString("grav");
                            SharedPreferences.Editor edit = pref.edit();
                            edit.putString("token", token);
                            edit.putString("grav", grav);
                            edit.commit();
                            startActivity(new Intent(this, Home.class));
                            finish();
                        }

                        Toast.makeText(getApplication(), jsonStr, Toast.LENGTH_LONG).show();

                    } catch(JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.tvLoginForgot:
                startActivity(new Intent(this, ForgotPass.class));
                break;
            case R.id.tvLoginRegister:
                startActivity(new Intent(this, Register.class));
                break;
            case R.id.ibLoginBack:
                startActivity(new Intent(this, Title.class));
                break;

        }
    }
}
