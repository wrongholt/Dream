package com.example.android.dream;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Typewriter writer;
    @BindView(R.id.text_output)
    TextView outputTextView;
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.username)
    EditText editTextUsername;
    final ArrayList<MapCoords> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final Bundle bundle = new Bundle();
        editTextUsername.setEnabled(false);
        editTextUsername.setInputType(InputType.TYPE_NULL);
        outputTextView.setMovementMethod(new ScrollingMovementMethod());
       list.add(new MapCoords( new PointF(355,475), getString(R.string.sample)));

        addTouchListener();

    }

    void typewriterOutput(String text) {
        writer = new Typewriter(outputTextView);
        writer.animateText(text);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void addTouchListener() {

        imageView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float x =  event.getX();
                float y =  event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("TAG", "touched down " + x + ", " + y);

                        break;

                }
for(int i = 0; i < list.size(); i++){
    float xPoint = list.get(i).getCoord().x;
    float xPointPlus = xPoint + 44;
    float xPointMinus = xPoint - 44;
    float yPoint = list.get(i).getCoord().y;
    float yPointPlus = yPoint + 44;
    float yPointMinus = yPoint - 44;
    if (x > xPointMinus && x < xPointPlus && y > yPointMinus && y < yPointPlus) {
        typewriterOutput(list.get(i).getTextOutput());
        editTextUsername.setEnabled(true);
        editTextUsername.setInputType(InputType.TYPE_CLASS_TEXT);
    }
}



                return false;
            }
        });
    }

}
