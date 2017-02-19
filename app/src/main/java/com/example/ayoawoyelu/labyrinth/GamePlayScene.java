package com.example.ayoawoyelu.labyrinth;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * Created by Ayoawoyelu on 2017-02-14.
 */

public class GamePlayScene implements Scene {
    private RollingBall rollingBall;
    private Point BallPoint;
    private Rect rect = new Rect();
    private boolean movingBall = false;
    private long gameTime;
    private HardwareOrientation Orientation;
    int startTime;
    Grid grid;
    FirstMaze mazeOne;

    public GamePlayScene(){
        rollingBall = new RollingBall( new Rect(100,100,100,100), Color.BLACK);
        BallPoint = new Point(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);
        rollingBall.update(BallPoint);

        Orientation = new HardwareOrientation();
        Orientation.register();
        startTime = (int)System.currentTimeMillis();
       grid = new Grid(Color.BLUE);
        mazeOne = new FirstMaze(Color.RED);

    }
    public void StarOver(){
    }
    public void update(){

        int timeElapsed = (int)(System.currentTimeMillis() - startTime);
            if(Orientation.getOrientation() != null && Orientation.getStartOrientation() != null){
                float pitch = Orientation.getOrientation()[1] - Orientation.getStartOrientation()[1];
                float roll = Orientation.getOrientation()[2] - Orientation.getStartOrientation()[2];
                float xVelocity = 2*roll* Constants.SCREEN_WIDTH/10f;
                float yVelocity = 2*pitch*Constants.SCREEN_HEIGHT/10f;

                if(movingBall = true) {
                    BallPoint.x += Math.abs(xVelocity) > 0 ? xVelocity : 0;
                    BallPoint.y -= Math.abs(yVelocity) > 0 ? yVelocity : 0;
                }
            }
        for (int i = 0; i<mazeOne.Lines.size(); i++) {
            if (rollingBall.getBall().intersect(mazeOne.Lines.get(i))){
                BallPoint.x = mazeOne.Lines.get(i).left;
                BallPoint.y = mazeOne.Lines.get(i).bottom;
            }
            else {
                movingBall = true;
            }

        }
/*
        if (BallPoint.x >= Constants.SCREEN_WIDTH){
            BallPoint.x = Constants.SCREEN_WIDTH - 25;
        }
        else if (BallPoint.x <= 0){
            BallPoint.x = 25;
        }
        if(BallPoint.y >= Constants.SCREEN_HEIGHT){
            BallPoint.y = Constants.SCREEN_HEIGHT- 25;
        }
        else if (BallPoint.y <= 0){
            BallPoint.y = 25;
        }*/

        rollingBall.update(BallPoint);
    }
    @Override
    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        rollingBall.draw(canvas, BallPoint);
        //grid.draw(canvas);
        mazeOne.draw(canvas);

    }
    @Override
    public void terminate(){

    }
    public void receiveTouch(MotionEvent event){


    }
}
