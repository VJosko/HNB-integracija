package com.vudrag.hnbintegracija;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vudrag.hnbintegracija.databinding.CurrencyRowBinding;

import java.util.List;

public class recAdapterCurrencies extends RecyclerView.Adapter<recAdapterCurrencies.MyViewHolder> {

    List<Currency> currencies;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CurrencyRowBinding currencyRowBinding;

        public MyViewHolder(@NonNull CurrencyRowBinding currencyRowBinding) {
            super(currencyRowBinding.getRoot());
            this.currencyRowBinding = currencyRowBinding;
        }
    }

    public recAdapterCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CurrencyRowBinding currencyRowBinding = CurrencyRowBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(currencyRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Currency currency = currencies.get(position);
        holder.currencyRowBinding.setCurrency(currency);
        holder.currencyRowBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }
}
