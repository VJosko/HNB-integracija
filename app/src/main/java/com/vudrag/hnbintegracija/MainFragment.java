package com.vudrag.hnbintegracija;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vudrag.hnbintegracija.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);


        recyclerView = view.findViewById(R.id.recCurrencies);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        viewModel.repository.currencies.observe(getViewLifecycleOwner(), o -> {
            if (viewModel.currencies.getValue() != null) {
                recAdapter = new recAdapterCurrencies(viewModel.repository.currencies.getValue());
                recyclerView.setAdapter(recAdapter);
                binding.tvDate.setText(viewModel.repository.currencies.getValue().get(0).getDatumPrimjene());
            }
        });

        return view;
    }
}