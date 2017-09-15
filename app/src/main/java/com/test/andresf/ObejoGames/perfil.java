package com.test.andresf.ObejoGames;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



/**
 * Created by alejo on 07/03/2017.
 */

public class perfil extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section number.
     */
    public static perfil newInstance(int sectionNumber) {
        perfil fragment = new perfil();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public perfil() {
        // Required empty public constructor
    }

sesion s= new sesion();
    Button btn1;
TextView gamertag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.perfil, container, false);
        btn1 = (Button)rootView.findViewById(R.id.cerrar);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chao();
            }
        });
        return rootView;
    }

public void chao(){

    System.exit(0);

}
}
