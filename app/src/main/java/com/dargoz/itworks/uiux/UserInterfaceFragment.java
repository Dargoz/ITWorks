package com.dargoz.itworks.uiux;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dargoz.itworks.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserInterfaceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserInterfaceFragment extends Fragment {


    public UserInterfaceFragment() {
        // Required empty public constructor
    }


    public static UserInterfaceFragment newInstance(String param1, String param2) {
        UserInterfaceFragment fragment = new UserInterfaceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_interface, container, false);
    }
}