package com.example.exercise03;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewMenu  extends ListFragment {

    String[] users = new String[] { "AIActivity","VRActivity"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.first_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, users);
        setListAdapter(adapter);
        return view;
    }

    @Override
  public void onListItemClick(ListView l, View v, int position, long id) {

        // create a new activity
        Intent in= new Intent(getActivity().getApplicationContext(), SecondActivity.class);

        startActivity(in);
    }
}
