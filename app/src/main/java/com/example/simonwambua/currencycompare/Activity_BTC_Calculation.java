package com.example.simonwambua.currencycompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_BTC_Calculation extends AppCompatActivity {
    TextView textView;
    EditText currency_value, result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btc_calculation);


        currency_value = (EditText) findViewById(R.id.currency_value);
        result = (EditText) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);


        Intent intent = this.getIntent();
      final float usd_txt=  intent.getIntExtra("usd",1);



       /* calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int currency_txt = Integer.parseInt(getIntent().getExtras().get(""))

              int currency_txt = Integer.parseInt(currency_value.getText().toString());
                //Toast.makeText(Activity_BTC_Calculation.this, "Data:"+currency_txt, Toast.LENGTH_SHORT).show();
               float result_txt=currency_txt/ usd_txt;
                Toast.makeText(Activity_BTC_Calculation.this, "Result"+result_txt, Toast.LENGTH_SHORT).show();
          }
        });
*/

    }
}
