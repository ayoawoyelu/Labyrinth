package com.example.ayoawoyelu.labyrinth;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by Ayoawoyelu on 2017-02-18.
 */

public class FirstMaze implements MazeObject {
    public ArrayList<Rect> Lines;
    public int color;
    Rect topBorder = new Rect(40,40,Constants.SCREEN_WIDTH-40, 60);
    Rect bottomBorder = new Rect(40,Constants.SCREEN_HEIGHT- 60,Constants.SCREEN_WIDTH-40,Constants.SCREEN_HEIGHT-40);
    Rect leftBorder = new Rect(40,40,60,Constants.SCREEN_HEIGHT-100);
    Rect rightBorder = new Rect(Constants.SCREEN_WIDTH-60, 100,Constants.SCREEN_WIDTH-40,Constants.SCREEN_HEIGHT-40);
    Rect TestBlock = new Rect(200, 200, 220, Constants.SCREEN_HEIGHT-200);
    Rect TestBlock2 = new Rect(400,1000,600,1020);

    public FirstMaze(int color){
        this.color = color;
        Lines = new ArrayList<>();
        initializeObstacles();
    }

    public void initializeObstacles(){
        // Obstacle Coordinates
        Lines.add(topBorder); //Top-Border
        Lines.add(bottomBorder); //Bottom-Border
        Lines.add(leftBorder); //Left
        Lines.add(rightBorder); //Right
        Lines.add(new Rect(Constants.SCREEN_WIDTH- 150, 40, Constants.SCREEN_WIDTH-130, 200));
        Lines.add(new Rect(150,700,170,900));
        Lines.add(new Rect(170,700,250,720));
        Lines.add(new Rect(230, 720, 250,900));
        Lines.add(new Rect(250,880,450,900));
        Lines.add(new Rect(450, 700, 470,1020));
        Lines.add(new Rect(470,1000,570,1020));
        Lines.add(new Rect(150,1000,380,1020));
        Lines.add(new Rect(520,1020,540,Constants.SCREEN_HEIGHT- 60));
        Lines.add(new Rect(200, 200, 220, Constants.SCREEN_HEIGHT-200));
        Lines.add(new Rect(400,1000,600,1020));


    }
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);

    for (int i = 0 ; i<Lines.size(); i++){
        canvas.drawRect(Lines.get(i), paint);
    }
    }
}
