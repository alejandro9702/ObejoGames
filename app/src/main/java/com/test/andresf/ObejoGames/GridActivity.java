package com.test.andresf.ObejoGames;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


import com.test.andresf.ObejoGames.adapter.GridItemAdapter;
import com.test.andresf.ObejoGames.modelo.ListItem;

import java.util.ArrayList;

public class GridActivity extends Fragment {

    private GridView grid;
    private static final String ARG_SECTION_NUMBER_3 = "section_number_3";

    public static ps4 newInstance(int sectionNumber) {

        ps4 fragment = new ps4();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER_3, sectionNumber);
        fragment.setArguments(args);

        return fragment;


    }

    public GridActivity() {
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
       /* View rootView = inflater.inflate(R.layout.grid_template, container, false);
        GridItemAdapter adapter = new GridItemAdapter(getContext(), listar());
        grid = (GridView) findViewById(R.id.gridAc);
        grid.setAdapter(adapter);*/
    }

    private ArrayList<ListItem> listar(){
        String[] titulos = getResources().getStringArray(R.array.shapeName);
        String[] subtitulos = getResources().getStringArray(R.array.shapeDesc);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.shapeImage);

        ArrayList<ListItem> lista = new ArrayList<>();

        for (int i=0; i<titulos.length; i++){
            lista.add(new ListItem(titulos[i], subtitulos[i], imagenes.getResourceId(i,0)));
        }
        return lista;
    }
}
