package com.example.victor.geoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    //metod för att ta oss tillbaka till main
    public void actbackhelp (View view){
        // intent för att anropa aktivitet
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}
