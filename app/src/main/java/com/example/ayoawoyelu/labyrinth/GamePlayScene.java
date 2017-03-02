package com.example.ayoawoyelu.labyrinth;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private boolean movingBall = true;
    private long gameTime;
    private HardwareOrientation Orientation;
    int startTime;
    public Grid grid;
    public FirstMaze mazeOne;
    BitmapFactory bf = new BitmapFactory();
    Bitmap bitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.right);


    public GamePlayScene(){

        rollingBall = new RollingBall( new Rect(Constants.SCREEN_WIDTH/2 -50, Constants.SCREEN_HEIGHT/2-50, Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2), Color.BLACK, bitmap);
        BallPoint = new Point(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);
        Orientation = new HardwareOrientation();
        Orientation.register();
        startTime = (int)System.currentTimeMillis();
        grid = new Grid(Color.BLUE);
        mazeOne = new FirstMaze(Color.DKGRAY);
    }
    public void StarOver(){
    }
    public void update(){
        float xVelocity;
        float yVelocity;
        boolean moveX = true;
        boolean moveY = true;
        int timeElapsed = (int)(System.currentTimeMillis() - startTime);
            if(Orientation.getOrientation() != null && Orientation.getStartOrientation() != null){
                float pitch = Orientation.getOrientation()[1] - Orientation.getStartOrientation()[1];
                float roll = Orientation.getOrientation()[2] - Orientation.getStartOrientation()[2];
                 xVelocity = roll* Constants.SCREEN_WIDTH/50f;
                 yVelocity = 2*pitch*Constants.SCREEN_HEIGHT/50f;
                BallPoint.x += Math.abs(xVelocity) > 0 && moveX? xVelocity : 0;
                BallPoint.y -= Math.abs(yVelocity) > 0 && moveY? yVelocity : 0;

            }
        //Collision Handling
        for (Rect obstacle:
             mazeOne.Lines) {
            if (BallPoint.x>obstacle.left-16 &&  BallPoint.x<(obstacle.right+2*obstacle.left)/3 && BallPoint.y >obstacle.top && BallPoint.y<obstacle.bottom ){
                BallPoint.x = obstacle.left - 16;
            }
             else if (BallPoint.x<obstacle.right+16 && BallPoint.x >Math.abs(obstacle.left+2*obstacle.right)/3 && BallPoint.y>obstacle.top && BallPoint.y<obstacle.bottom   ){
                BallPoint.x = obstacle.right+16;

            }
            if (BallPoint.y>obstacle.top-15 && BallPoint.y<(obstacle.bottom+2*obstacle.top)/3 && BallPoint.x>obstacle.left && BallPoint.x<obstacle.right ){
                BallPoint.y = obstacle.top-16;
            }
           else if (BallPoint.y<obstacle.bottom +16 && BallPoint.x>obstacle.left+15 && BallPoint.x<obstacle.right-15 && BallPoint.y>(obstacle.top+2*obstacle.bottom)/3){
                BallPoint.y = obstacle.bottom+16;
            }
        }

        if (BallPoint.x>Constants.SCREEN_WIDTH -20){

            BallPoint.x =  Constants.SCREEN_WIDTH-20;
        }
        else if (BallPoint.x < 20){

            BallPoint.x = 20;
        }
        if(BallPoint.y >= Constants.SCREEN_HEIGHT -20){
            BallPoint.y = Constants.SCREEN_HEIGHT- 20;
        }
        else if (BallPoint.y <= 20){
            BallPoint.y = 20;
        }
        rollingBall.update(BallPoint);
    }
    @Override
    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        //rollingBall.draw(canvas);
        rollingBall.draw(canvas, BallPoint);
       // grid.draw(canvas);
        mazeOne.draw(canvas);

    }
    @Override
    public void terminate(){

    }
    public void receiveTouch(MotionEvent event){


    }

}
