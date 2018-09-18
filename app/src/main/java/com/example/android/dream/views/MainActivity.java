package com.example.android.dream.views;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.dream.R;
import com.example.android.dream.models.MapCoords;
import com.example.android.dream.models.Player;
import com.example.android.dream.models.Typewriter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.dream.REPLY";
    public static final int NEW_PLAYER_ACTIVITY_REQUEST_CODE = 1;
    private Typewriter writer;
    private DreamViewModel mDreamViewModel;
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
        mDreamViewModel = ViewModelProviders.of(this).get(DreamViewModel.class);
        final Bundle bundle = new Bundle();
        editTextUsername.setEnabled(false);
        editTextUsername.setInputType(InputType.TYPE_NULL);
        outputTextView.setMovementMethod(new ScrollingMovementMethod());
       list.add(new MapCoords( new PointF(355,475), getString(R.string.sample)));

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editTextUsername.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String player = editTextUsername.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, player);
                    setResult(RESULT_OK, replyIntent);
                }
                String playerString = editTextUsername.getText().toString();
                Player player = new Player(playerString);
                mDreamViewModel.insert(player);
                Intent intent = new Intent(MainActivity.this, PickAvatarActivity.class);
                intent.putExtra("player", playerString);

                startActivityForResult(intent, NEW_PLAYER_ACTIVITY_REQUEST_CODE);
                finish();
            }
        });

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
