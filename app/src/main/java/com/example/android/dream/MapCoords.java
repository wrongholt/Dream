package com.example.android.dream;

import android.content.Context;
import android.graphics.PointF;

import java.util.HashMap;

public class MapCoords {

  private PointF coord;
  private String textOutput;

    public MapCoords(PointF coord, String textOutput) {
        this.coord = coord;
        this.textOutput = textOutput;
    }
    public MapCoords() {

    }
    public PointF getCoord() {
        return coord;
    }

    public String getTextOutput() {
        return textOutput;
    }
}
