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
    Rect TestBlock = new Rect(200, 200, Constants.SCREEN_WIDTH-200, Constants.SCREEN_HEIGHT-200);

    public FirstMaze(int color){
        this.color = color;
        Lines = new ArrayList<>();
        printMaze();
    }

    public void printMaze(){
        // Rect(int left, int top, int right, int bottom)


//        Lines.add(topBorder); //Top-Border
//        Lines.add(bottomBorder); //Bottom-Border
//        Lines.add(leftBorder); //Left
//        Lines.add(rightBorder); //Right
//        Lines.add(new Rect(Constants.SCREEN_WIDTH- 150, 40, Constants.SCREEN_WIDTH-130, 200));
        Lines.add(TestBlock);


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
