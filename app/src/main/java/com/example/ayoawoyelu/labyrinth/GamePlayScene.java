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

    public GamePlayScene(){
        rollingBall = new RollingBall( new Rect(100,100,100,100), Color.BLACK);
        BallPoint = new Point(Constants.SCREEN_HEIGHT/2, Constants.SCREEN_WIDTH/2);
        rollingBall.update(BallPoint);

        Orientation = new HardwareOrientation();
        Orientation.register();
        startTime = (int)System.currentTimeMillis();

    }
    public void StarOver(){
    }
    public void update(){
        int timeElapsed = (int)(System.currentTimeMillis() - startTime);
            if(Orientation.getOrientation() != null && Orientation.getStartOrientation() != null){
                float pitch = Orientation.getOrientation()[1] - Orientation.getStartOrientation()[1];
                float roll = Orientation.getOrientation()[2] - Orientation.getStartOrientation()[2];
                float xVelocity = 2*roll* Constants.SCREEN_WIDTH/10f;
                float yVelocity = pitch*Constants.SCREEN_HEIGHT/10f;

                BallPoint.x += Math.abs(xVelocity*timeElapsed)>5 ? xVelocity*timeElapsed: 0 ;
                BallPoint.y -= Math.abs(yVelocity*timeElapsed)>5 ? yVelocity*timeElapsed: 0 ;
            }

        if (BallPoint.x >Constants.SCREEN_WIDTH){
            BallPoint.x  = Constants.SCREEN_WIDTH;
        }
        if(BallPoint.y >Constants.SCREEN_HEIGHT){
            BallPoint.y = Constants.SCREEN_HEIGHT;
        }
        rollingBall.update(BallPoint);
    }
    @Override
    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        rollingBall.update(BallPoint, canvas);
        rollingBall.draw(canvas);

    }
    @Override
    public void terminate(){

    }
    public void receiveTouch(MotionEvent event){

    }
}
