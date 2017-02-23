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
        int timeElapsed = (int)(System.currentTimeMillis() - startTime);
            if(Orientation.getOrientation() != null && Orientation.getStartOrientation() != null){
                float pitch = Orientation.getOrientation()[1] - Orientation.getStartOrientation()[1];
                float roll = Orientation.getOrientation()[2] - Orientation.getStartOrientation()[2];
                 xVelocity = roll* Constants.SCREEN_WIDTH/10f;
                 yVelocity = 2*pitch*Constants.SCREEN_HEIGHT/10f;
                boolean moveX = true;
                Boolean moveY = true;
                for (Rect obastacles:
                     mazeOne.Lines) {
                    if(rollingBall.getBall().intersect(obastacles) && yVelocity>0){
                        //xVelocity = 0;
                        moveX = false;
                    }

                    if (rollingBall.getBall().intersect(obastacles) && xVelocity>0){
                        moveY = false;
                    }
                }

                BallPoint.x += Math.abs(xVelocity) > 0 && moveX? xVelocity : 0;
                BallPoint.y -= Math.abs(yVelocity) > 0 && moveY? yVelocity : 0;

                //BallPoint.x += Math.abs(xVelocity) > 0 ? xVelocity : 0;
                //BallPoint.y -= Math.abs(yVelocity) > 0 ? yVelocity : 0;
            }

     /*   if (BallPoint.x> mazeOne.rightBorder.left -20){
            BallPoint.x =  mazeOne.rightBorder.left -20;
        }
        else if (BallPoint.x < mazeOne.leftBorder.right+20){
            BallPoint.x = mazeOne.leftBorder.right+20;
        }
        if (BallPoint.y<mazeOne.topBorder.bottom+20){
            BallPoint.y=mazeOne.topBorder.bottom+20;
        }
        else if(BallPoint.y>mazeOne.bottomBorder.top-20){
            BallPoint.y=mazeOne.bottomBorder.top-20;
        }*/


//        if (BallPoint.x>Constants.SCREEN_WIDTH -20){
//
//            BallPoint.x =  Constants.SCREEN_WIDTH-20;
//        }
//        else if (BallPoint.x < 20){
//
//            BallPoint.x = 20;
//        }
//        if(BallPoint.y >= Constants.SCREEN_HEIGHT -20){
//            BallPoint.y = Constants.SCREEN_HEIGHT- 20;
//        }
//        else if (BallPoint.y <= 20){
//            BallPoint.y = 20;
//        }

        rollingBall.update(BallPoint);
    }
    @Override
    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        //rollingBall.draw(canvas);
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
