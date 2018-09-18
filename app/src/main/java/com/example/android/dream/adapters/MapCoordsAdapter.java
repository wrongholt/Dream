package com.example.android.dream.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.dream.models.MapCoords;

import java.util.ArrayList;
import java.util.List;

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
