package com.dargoz.itworks.list;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dargoz.itworks.R;
import com.dargoz.itworks.databinding.FragmentListBinding;
import com.dargoz.itworks.list.models.Hero;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {
    private FragmentListBinding binding;


    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.radioButtonGroup.check(R.id.linear_radio_button);
        binding.radioButtonGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.grid_radio_button) {
                binding.heroRecyclerView
                        .setLayoutManager(new GridLayoutManager(getContext(), 2));
            } else {
                binding.heroRecyclerView
                        .setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });

        HeroListAdapter adapter = new HeroListAdapter();
        adapter.heroes = getData();
        binding.heroRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.heroRecyclerView.setAdapter(adapter);
    }

    private List<Hero> getData() {
        List<Hero> heroes = new ArrayList<>();
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        for (int position = 0; position < dataName.length; position++) {
            Hero hero = new Hero(
                    dataName[position],
                    dataDescription[position],
                    dataPhoto.getResourceId(position, -1)
            );
            heroes.add(hero);
        }
        dataPhoto.recycle();
        return heroes;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}