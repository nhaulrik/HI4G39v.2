package com.example.klaushaulrik.hi4g39v2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * Created by Nikolaj
*/

public class MenuFragment extends Fragment {

    public MenuFragment(){

    }


    SeriesSelectorInterface comm;

    public void onAttach(Activity a) {

        comm=(SeriesSelectorInterface)a;
        super.onAttach(a);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        String[] series = getResources().getStringArray(R.array.series_array);

        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, series));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Log.v("Nikolaj logging:", " du har trykket");

                comm.seriesData("Du har trykket på: " + ((TextView) view).getText());
            }
        });

        return view;
    }



}
