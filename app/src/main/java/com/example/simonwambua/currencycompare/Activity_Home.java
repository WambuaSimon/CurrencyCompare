package com.example.simonwambua.currencycompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity_Home extends AppCompatActivity {
ImageView btc,eth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btc=(ImageView) findViewById(R.id.btc);
        eth=(ImageView) findViewById(R.id.eth);

        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Activity_BTC.class));
            }
        });
        eth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Activity_ETH.class));
            }
        });


    }



}
