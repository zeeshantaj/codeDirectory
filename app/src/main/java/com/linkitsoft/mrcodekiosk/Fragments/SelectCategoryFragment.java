package com.linkitsoft.mrcodekiosk.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.linkitsoft.mrcodekiosk.R;

public class SelectCategoryFragment extends Fragment {

    public SelectCategoryFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modifiers, container, false);



        return view;
    }

}
