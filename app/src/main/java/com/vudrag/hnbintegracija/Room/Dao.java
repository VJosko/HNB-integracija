package com.vudrag.hnbintegracija.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.vudrag.hnbintegracija.Currency;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insertCurrencies(List<Currency> currencies);

    @Query("SELECT * FROM currency_table WHERE datumPrimjene =(SELECT datumPrimjene FROM currency_table ORDER BY id DESC)")
    List<Currency> getCurrencies();

}
