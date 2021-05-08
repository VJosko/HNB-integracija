package com.vudrag.hnbintegracija;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("tecajn/v1")
    Call<List<Currency>> getCurrencies();
}
