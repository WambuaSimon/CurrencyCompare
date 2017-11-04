package com.example.simonwambua.currencycompare.Interface;

import com.example.simonwambua.currencycompare.Model.CurrencyModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Simon.Wambua on 14/10/2017.
 */

public interface ApiInterface {

    @GET("price?fsym=ETH&tsyms=USD,EUR,CAD,NGN,KES,AUD,ARS,BSD,AFN,KHR,XAF,CNY,EGP,INR,IRR,JPY,NOK,PKR,QAR,ZAR")
    Call<CurrencyModel> getETH();

    @GET("price?fsym=BTC&tsyms=USD,EUR,CAD,NGN,KES,AUD,ARS,BSD,AFN,KHR,XAF,CNY,EGP,INR,IRR,JPY,NOK,PKR,QAR,ZAR")
    Call<CurrencyModel> getBTC();

   }

