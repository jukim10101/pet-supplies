package com.example.petview.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petview.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<HomeRankingData> items = new ArrayList<>();
    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        initDataSet();
        Context context = root.getContext();
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.home_recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, items);
        recyclerView.setAdapter(adapter);

        return root;
    }

    private void initDataSet() {
        items.clear();
        items.add(new HomeRankingData("고양이 모래", "12,000원", "1. ", R.drawable.cat));
        items.add(new HomeRankingData("고양이 스크래", "12,000원", "2. ", R.drawable.cat));
        items.add(new HomeRankingData("고양이 장난감", "12,000원", "3. ", R.drawable.cat));
    }
}
