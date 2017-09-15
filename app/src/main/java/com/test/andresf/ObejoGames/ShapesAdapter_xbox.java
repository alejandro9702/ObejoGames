package com.test.andresf.ObejoGames;

/**
 * Created by AndresF on 19/12/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShapesAdapter_xbox extends ArrayAdapter<MyShape> {
    private int layoutResource;
    private Context context;

    public ShapesAdapter_xbox(Context context, int layoutResource, List<MyShape> myShape) {
        super(context, layoutResource, myShape);
        this.layoutResource = layoutResource;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent ) {

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(layoutResource, null);
        }

        MyShape myShape = getItem(position);

        if (myShape !=null ) {
            TextView tvwName = (TextView) convertView.findViewById(R.id.tvwName_xbox);
            TextView tvwDescription = (TextView) convertView.findViewById(R.id.tvwDescription_xbox);
            ImageView imgShape = (ImageView) convertView.findViewById(R.id.imgShape_xbox);

            tvwName.setText(myShape.getName());
            tvwDescription.setText(myShape.getDescripcion());
            imgShape.setImageResource(myShape.getImage());
        }


        return convertView;
    }
}
