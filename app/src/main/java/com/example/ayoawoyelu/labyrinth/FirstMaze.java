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
    //left, top, right, bottom
      Rect topBorder = new Rect(0,0,Constants.SCREEN_WIDTH, 20);
      Rect bottomBorder = new Rect(0,Constants.SCREEN_HEIGHT- 20,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
      Rect leftBorder = new Rect(0,0,20,Constants.SCREEN_HEIGHT);
      Rect rightBorder = new Rect(Constants.SCREEN_WIDTH-20, 0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);

    public FirstMaze(int color){
        this.color = color;
        Lines = new ArrayList<>();
        initializeObstacles();
    }

    public void initializeObstacles(){
        // Obstacle Coordinates
        //left, top, right, bottom
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
        Lines.add(new Rect(190, 200, 210,500));
        Lines.add(new Rect(300, 400, 500,420));
        Lines.add(new Rect(80,600,600,620));

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
