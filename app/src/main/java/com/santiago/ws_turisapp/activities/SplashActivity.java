package com.santiago.ws_turisapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.santiago.ws_turisapp.R;
import com.santiago.ws_turisapp.data.Datos;
import com.santiago.ws_turisapp.models.Restaurante;
import com.santiago.ws_turisapp.models.Sitio;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent= new Intent(this,InicioActivity.class);
        startActivity(intent);

    }


}
