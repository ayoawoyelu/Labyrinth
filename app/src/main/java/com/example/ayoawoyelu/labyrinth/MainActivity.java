
package com.example.ayoawoyelu.labyrinth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button StartGame;
    public Button SelectLevel;
    public Button Instruction;

public void init(){
    StartGame = (Button)findViewById(R.id.Start);
    StartGame.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        }
    });

    SelectLevel = (Button)findViewById(R.id.selectLevel);
    SelectLevel.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, LevelActivity.class);
            startActivity(intent);
        }
    });
    Instruction = (Button)findViewById(R.id.Instruction);
        Instruction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, InstructionActivity.class);
                startActivity(intent);
            }
        });
    StartGame.setTextColor(Color.WHITE);
    //#ADD8E6
    SelectLevel.setTextColor(Color.WHITE);
    Instruction.setTextColor(Color.WHITE);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        init();

    }
}


