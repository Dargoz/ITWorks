package com.dargoz.itworks.networking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dargoz.itworks.databinding.FragmentNetworkingBinding;
import com.dargoz.itworks.networking.models.DataItem;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class NetworkingFragment extends Fragment {
    private FragmentNetworkingBinding binding;

    public NetworkingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNetworkingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());


        String url = "https://reqres.in/api/users?page=1&per_page=10";

        StringRequest stringRequest = new StringRequest(url, response -> {

            Log.i("DRG", "onResponse : " + response);
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                Log.i("DRG", "data : " + jsonArray.toString());
                binding.responseData.setText(jsonArray.toString());
                for (int idx = 0; idx < jsonArray.length(); idx++) {
                    JSONObject dataJSONObject = (JSONObject) jsonArray.get(idx);
                    Gson gson = new Gson();
                    DataItem dataItem = gson.fromJson(dataJSONObject.toString(), DataItem.class);
                    Log.i("DRG", "data " + idx + " : " + dataItem.toString());

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }, error -> Log.i("DRG", "error response : " + error.getMessage()));

        requestQueue.add(stringRequest);
    }
}