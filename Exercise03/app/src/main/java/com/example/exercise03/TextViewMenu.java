package com.example.exercise03;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextViewMenu extends Fragment {
    TextView name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        name = (TextView)view.findViewById(R.id.Name);
        return view;
    }

    public void change(String uname){
        name.append(uname);
    }
}