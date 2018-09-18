package com.example.android.dream.models;

import android.os.Handler;
import android.widget.TextView;

public class Typewriter {

    private String sText = new String();
    private int index;
    private long mDelay = 100;

    TextView textView;

    public Typewriter(TextView tView) {
        textView = tView;
    }

    public void animateText(String string) {
        sText = string;
        index = 0;

        textView.setText("");

        new Handler().removeCallbacks(characterAdder);
        new Handler().postDelayed(characterAdder, mDelay);
    }

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            textView.setText(sText.subSequence(0, index++));

            if (index <= sText.length()) {
                new Handler().postDelayed(characterAdder, mDelay);
            }
        }
    };
}