package com.example.ayoawoyelu.labyrinth;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by Ayoawoyelu on 2017-02-17.
 */

public class Grid implements BallObject {


    private ArrayList<Rect> rect;
    private ArrayList<Rect> rectVert;

    public int color;

    public Grid( int color){
        this.color = color;

        rect = new ArrayList<>();
        rectVert = new ArrayList<>();
        populateGrid();
    }

    public void populateGrid(){
        for (int i = 0; i<Constants.SCREEN_HEIGHT; ++i){
                rect.add(new Rect(0, 10*(2*i+1), Constants.SCREEN_WIDTH, 10*(2*i+2)));
        }
        for (int i =0 ; i<Constants.SCREEN_WIDTH; ++i){
                rectVert.add(new Rect(10*(2*i+1),0,10*(2*i+2),Constants.SCREEN_HEIGHT));
        }
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        for (int i = 0; i<Constants.SCREEN_HEIGHT; i++){
            canvas.drawRect(rect.get(i), paint);
        }
        for (int i = 0; i<Constants.SCREEN_WIDTH; i++){
            canvas.drawRect(rectVert.get(i), paint);
        }

    }

    @Override
    public void update() {

    }
}
