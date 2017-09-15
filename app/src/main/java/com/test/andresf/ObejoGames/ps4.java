package com.test.andresf.ObejoGames;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by alejo on 03/03/2017.
 */

public class ps4 extends Fragment {

    private static final String ARG_SECTION_NUMBER_3 = "section_number_3";

    // Regresa una nueva instancia de este Fragment

    public static ps4 newInstance(int sectionNumber) {

        ps4 fragment = new ps4();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER_3, sectionNumber);
        fragment.setArguments(args);

        return fragment;


    }

    public ps4() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listps4, container, false);
        List<MyShape> myShapeList = new ArrayList<>();
        MyShape myShape;

        final String[] arrayShapeName = getResources().getStringArray(R.array.shapeName);
        String[] arrayShapeDesc = getResources().getStringArray(R.array.shapeDesc);

        String[] arrayShapeImag = getResources().getStringArray(R.array.shapeImage);

        for (int i = 0; i < arrayShapeName.length; i++)

        {
            myShape = new MyShape();
            myShape.setId(arrayShapeImag[i]);
            myShape.setName(arrayShapeName[i]);
            myShape.setDescripcion(arrayShapeDesc[i]);
            myShape.setImage(getResources().getIdentifier(arrayShapeImag[i], "mipmap", getContext().getPackageName()));

            myShapeList.add(myShape);
        }

        ListView listView = (ListView) rootView.findViewById(R.id.lstShapes);
        ShapesAdapter shapesAdapter = new ShapesAdapter(getContext(), R.layout.listps4, myShapeList);
        listView.setAdapter(shapesAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<MyShape> myShapeList = new ArrayList<>();
                MyShape myShape;
                myShape = new MyShape();
                String var= arrayShapeName[position];
                Toast.makeText(getContext(),"juego:"+var ,Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getContext(),Splash.class);
                startActivity(intent);
            }
        });




        return rootView;


    }
}




