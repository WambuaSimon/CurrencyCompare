package com.example.simonwambua.currencycompare;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simonwambua.currencycompare.Interface.ApiInterface;
import com.example.simonwambua.currencycompare.Model.CurrencyModel;
import com.example.simonwambua.currencycompare.Utils.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_ETH extends AppCompatActivity {
    TextView usd, eur, cad, ngn, kes, aud, ars, bsd, afn, khr, xaf, cny, egp, inr, irr, jpy,
            nok, pkr, qar, zar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eth);


        usd = (TextView) findViewById(R.id.eth_usd);
        eur = (TextView) findViewById(R.id.eth_eur);
        cad = (TextView) findViewById(R.id.eth_cad);
        ngn = (TextView) findViewById(R.id.eth_ngn);
        kes = (TextView) findViewById(R.id.eth_kes);
        aud = (TextView) findViewById(R.id.eth_aud);
        ars = (TextView) findViewById(R.id.eth_ars);
        bsd = (TextView) findViewById(R.id.eth_bsd);
        afn = (TextView) findViewById(R.id.eth_afn);
        khr = (TextView) findViewById(R.id.eth_khr);
        xaf = (TextView) findViewById(R.id.eth_xaf);
        cny = (TextView) findViewById(R.id.eth_cny);
        egp = (TextView) findViewById(R.id.eth_egp);
        inr = (TextView) findViewById(R.id.eth_inr);
        irr = (TextView) findViewById(R.id.eth_irr);
        jpy = (TextView) findViewById(R.id.eth_jpy);
        nok = (TextView) findViewById(R.id.eth_nok);
        pkr = (TextView) findViewById(R.id.eth_pkr);
        qar = (TextView) findViewById(R.id.eth_qar);
        zar = (TextView) findViewById(R.id.eth_zar);


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CurrencyModel> call = apiInterface.getETH();

        progressDialog = new ProgressDialog(Activity_ETH.this);
        progressDialog.setMessage("Loading Currencies...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show();
        progressDialog.setCancelable(false);

        call.enqueue(new Callback<CurrencyModel>() {
            @Override
            public void onResponse(Call<CurrencyModel> call, Response<CurrencyModel> response) {
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
            }

            @Override
            public void onFailure(Call<CurrencyModel> call, Throwable t) {
                Toast.makeText(Activity_ETH.this, "Check your network connection and try again", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
