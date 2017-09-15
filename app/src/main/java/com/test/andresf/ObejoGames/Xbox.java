package com.test.andresf.ObejoGames;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by alejo on 03/03/2017.
 */

public class Xbox extends Fragment {

    private static final String ARG_SECTION_NUMBER_4 = "section_number_4";

    // Regresa una nueva instancia de este Fragment

    public static Xbox newInstance(int sectionNumber) {

        Xbox fragment = new Xbox();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER_4, sectionNumber);
        fragment.setArguments(args);

        return fragment;


    }

    public Xbox() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listxbox, container, false);
        List<MyShape> myShapeList = new ArrayList<>();
        MyShape myShape;

        String[] arrayShapeName = getResources().getStringArray(R.array.shapeName_Xbox);
        String[] arrayShapeDesc = getResources().getStringArray(R.array.shapeDesc_xbox);

        String[] arrayShapeImag = getResources().getStringArray(R.array.shapeImage_xbox);

        for (int i = 0; i < arrayShapeName.length; i++)

        {
            myShape = new MyShape();
            myShape.setId(arrayShapeImag[i]);
            myShape.setName(arrayShapeName[i]);
            myShape.setDescripcion(arrayShapeDesc[i]);
            myShape.setImage(getResources().getIdentifier(arrayShapeImag[i], "mipmap", getContext().getPackageName()));

            myShapeList.add(myShape);
        }

        ListView listView = (ListView) rootView.findViewById(R.id.lstShapes_xbox);
        ShapesAdapter_xbox shapesAdapter = new ShapesAdapter_xbox(getContext(), R.layout.listxbox, myShapeList);
        listView.setAdapter(shapesAdapter);
        return rootView;
    }


}

