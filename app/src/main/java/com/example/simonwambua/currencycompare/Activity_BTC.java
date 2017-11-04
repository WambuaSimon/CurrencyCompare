package com.example.simonwambua.currencycompare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simonwambua.currencycompare.Interface.ApiInterface;
import com.example.simonwambua.currencycompare.Model.CurrencyModel;
import com.example.simonwambua.currencycompare.Utils.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_BTC extends AppCompatActivity {
    TextView usd, eur, cad, ngn, kes, aud, ars, bsd, afn, khr, xaf, cny, egp, inr, irr, jpy,
            nok, pkr, qar, zar;
    ProgressDialog progressDialog;

    CardView btc_usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btc);

        btc_usd = (CardView) findViewById(R.id.btc_usd);




        usd = (TextView) findViewById(R.id.usd);
        eur = (TextView) findViewById(R.id.eur);
        cad = (TextView) findViewById(R.id.cad);
        ngn = (TextView) findViewById(R.id.ngn);
        kes = (TextView) findViewById(R.id.kes);
        aud = (TextView) findViewById(R.id.aud);
        ars = (TextView) findViewById(R.id.ars);
        bsd = (TextView) findViewById(R.id.bsd);
        afn = (TextView) findViewById(R.id.afn);
        khr = (TextView) findViewById(R.id.khr);
        xaf = (TextView) findViewById(R.id.xaf);
        cny = (TextView) findViewById(R.id.cny);
        egp = (TextView) findViewById(R.id.egp);
        inr = (TextView) findViewById(R.id.inr);
        irr = (TextView) findViewById(R.id.irr);
        jpy = (TextView) findViewById(R.id.jpy);
        nok = (TextView) findViewById(R.id.nok);
        pkr = (TextView) findViewById(R.id.pkr);
        qar = (TextView) findViewById(R.id.qar);
        zar = (TextView) findViewById(R.id.zar);


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CurrencyModel> call = apiInterface.getBTC();
        progressDialog = new ProgressDialog(Activity_BTC.this);
        progressDialog.setMessage("Loading Currencies...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show();
        progressDialog.setCancelable(false);
        call.enqueue(new Callback<CurrencyModel>() {
            @Override
            public void onResponse(Call<CurrencyModel> call, final Response<CurrencyModel> response) {


                usd.setText("USD : " + response.body().getUSD());
                eur.setText("EUR : " + response.body().getEUR());
                cad.setText("CAD : " + response.body().getCAD());
                ngn.setText("NGN : " + response.body().getNGN());
                kes.setText("KES : " + response.body().getKES());
                aud.setText("AUD : " + response.body().getAUD());
                ars.setText("ARS : " + response.body().getARS());
                bsd.setText("BSD : " + response.body().getBSD());
                afn.setText("AFN : " + response.body().getAFN());
                khr.setText("KHR : " + response.body().getKHR());
                xaf.setText("XAF : " + response.body().getXAF());
                cny.setText("CNY : " + response.body().getCNY());
                egp.setText("EGP : " + response.body().getEGP());
                inr.setText("INR : " + response.body().getINR());
                irr.setText("IRR : " + response.body().getIRR());
                jpy.setText("JPY : " + response.body().getJPY());
                nok.setText("NOK : " + response.body().getNOK());
                pkr.setText("PKR : " + response.body().getPKR());
                qar.setText("QAR : " + response.body().getQAR());
                zar.setText("ZAR : " + response.body().getZAR());

                progressDialog.dismiss();


                btc_usd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myintent=new Intent(Activity_BTC.this, Activity_BTC_Calculation.class);
                        myintent.putExtra("usd",response.body().getUSD());
                       // Toast.makeText(Activity_BTC.this, "Data"+response.body().getUSD(), Toast.LENGTH_SHORT).show();
                        startActivity(myintent);


                        }
                });


            }

            @Override
            public void onFailure(Call<CurrencyModel> call, Throwable t) {
                Toast.makeText(Activity_BTC.this, "Check your network connection and try again", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
