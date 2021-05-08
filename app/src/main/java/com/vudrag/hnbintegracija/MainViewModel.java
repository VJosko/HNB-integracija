package com.vudrag.hnbintegracija;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vudrag.hnbintegracija.Currency;
import com.vudrag.hnbintegracija.Repository;

import java.util.List;

public class MainViewModel extends ViewModel {

    public MutableLiveData<List<Currency>> currencies = new MutableLiveData<>();
    Repository repository;

    public MainViewModel() {
        repository = Repository.getInstance();
        getCurrencies();
    }

    private void getCurrencies() {
        currencies = repository.currencies;
    }


}
