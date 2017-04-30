package com.example.ayoawoyelu.labyrinth;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {
    Button Level1;
    Button Level2;
    Button Level3;
    Button Level4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Level1 = (Button)findViewById(R.id.Level1);
        Level2 = (Button)findViewById(R.id.Level2);
        Level3 = (Button)findViewById(R.id.Level3);
        Level4 = (Button)findViewById(R.id.Level4);

        Level1.setTextColor(Color.WHITE);
        Level2.setTextColor(Color.WHITE);
        Level3.setTextColor(Color.WHITE);
        Level4.setTextColor(Color.WHITE);

        Level2.setEnabled(false);
        Level3.setEnabled(false);
        Level4.setEnabled(false);
    }
}
