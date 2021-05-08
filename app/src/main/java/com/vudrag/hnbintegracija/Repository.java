package com.vudrag.hnbintegracija;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.vudrag.hnbintegracija.Room.CurrencyDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Context context;

    private static Repository instance = null;

    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public MutableLiveData<List<Currency>> currencies = new MutableLiveData<>();
    public List<Currency> dbCurrencies;
    CurrencyDatabase currencyDatabase;

    public void setContext(Context context) {
        this.context = context;
        getCurrencies();
    }

    public void getCurrencies() {
        currencyDatabase = CurrencyDatabase.getInstance(context);
            dbCurrencies = currencyDatabase.dao().getCurrencies();


            if (dbCurrencies != null && dbCurrencies.size() > 0) {
                currencies.setValue(dbCurrencies);
                if (dbCurrencies.get(0).getDatumPrimjene().equals(getDate())) {
                    return;
                }
            }
        getCurrenciesData();
    }

    private String getDate() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl("https://api.hnb.hr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Api api = retrofit.create(Api.class);


    private void getCurrenciesData() {
        Call<List<Currency>> call = api.getCurrencies();

        call.enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                currencies.setValue(response.body());
                new Thread(() -> {
                    currencyDatabase.dao().insertCurrencies(response.body());
                }).start();
            }

            @Override
            public void onFailure(Call<List<Currency>> call, Throwable t) {
            }
        });
    }

}
