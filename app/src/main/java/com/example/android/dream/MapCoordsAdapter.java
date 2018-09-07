package com.example.android.dream;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MapCoordsAdapter extends ArrayAdapter<MapCoords> {
    public MapCoordsAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public MapCoordsAdapter(@NonNull Context context,List<MapCoords> objects) {
        super(context,0, objects);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        MapCoords coords;
List<MapCoords> list = new ArrayList<>();





        return view;
    }
}
