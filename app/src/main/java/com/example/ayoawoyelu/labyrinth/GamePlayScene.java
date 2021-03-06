package com.example.ayoawoyelu.labyrinth;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.Vector;

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
    Bitmap firstmazepic = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.maze);
    private float xVelocity = 0;
    private float yVelocity = 0;


    public GamePlayScene(){
        Rect Start;
        rollingBall = new RollingBall( new Rect(Constants.SCREEN_WIDTH/2 -30, Constants.SCREEN_HEIGHT/2-30, Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2), Color.BLACK, bitmap);
        BallPoint = new Point(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);
        Orientation = new HardwareOrientation();
        Orientation.register();
        startTime = (int)System.currentTimeMillis();
        grid = new Grid(Color.BLUE);
        mazeOne = new FirstMaze(Color.GRAY);
    }

    public void update(){

        boolean moveX = true;
        boolean moveY = true;
        int timeElapsed = (int)(System.currentTimeMillis() - startTime);
            if(Orientation.getOrientation() != null && Orientation.getStartOrientation() != null){
                float pitch = Orientation.getOrientation()[1] - Orientation.getStartOrientation()[1];
                float roll = Orientation.getOrientation()[2] - Orientation.getStartOrientation()[2];
                xVelocity = 2*roll* Constants.SCREEN_WIDTH/100f;
                yVelocity = 2*pitch*Constants.SCREEN_HEIGHT/100f;
                BallPoint.x += Math.abs(xVelocity) > 0 && movingBall? xVelocity : 0;
                BallPoint.y -= Math.abs(yVelocity) > 0 && movingBall? yVelocity : 0;
            }

       // Collision Handling
        for (Rect obstacle:
                mazeOne.Lines) {
                    collisionRestriction();
        }

        if (BallPoint.x>Constants.SCREEN_WIDTH -15){

            BallPoint.x =  Constants.SCREEN_WIDTH-15;
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
    }
    public void collisionRestriction(){
        // Collision Handling
            for (Rect obstacle:
                    mazeOne.Lines) {
                if (BallPoint.x > obstacle.left - 15
                        && BallPoint.x < obstacle.right-15
                        && BallPoint.y > obstacle.top+5
                        && BallPoint.y < obstacle.bottom-5) {
                    BallPoint.x = obstacle.left - 15;
                    System.out.println("HIT Left");

                }
                if (BallPoint.x < obstacle.right+15
                        && BallPoint.x >obstacle.left+10
                        && BallPoint.y>obstacle.top+5
                        && BallPoint.y<obstacle.bottom-5){
                    BallPoint.x = obstacle.right+15;
                    System.out.println("HIT Right");

                }
                if (BallPoint.y>obstacle.top-15
                        && BallPoint.y<obstacle.bottom-10
                        && BallPoint.x>obstacle.left
                        && BallPoint.x<obstacle.right){
                    BallPoint.y = obstacle.top-15;
                    System.out.println("Hit Top: "+BallPoint.y);

                }
                else if (BallPoint.y<obstacle.bottom + 15
                        && BallPoint.x>obstacle.left
                        && BallPoint.x<obstacle.right
                        && BallPoint.y>obstacle.top+5){
                    BallPoint.y = obstacle.bottom+15;
                    System.out.println("HIT Bottom: "+ BallPoint.y);

                }
            }
    }

    @Override
    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawText(String.valueOf((int)(System.currentTimeMillis() - startTime)), 100,100, paint);
        //Set Background Picture for MAze
        Rect src = new Rect(0,0,firstmazepic.getWidth(), firstmazepic.getHeight());
        //canvas.drawBitmap(firstmazepic,src,new Rect(0,0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT), paint);
        rollingBall.draw(canvas, BallPoint);
        //grid.draw(canvas);
        mazeOne.draw(canvas);
    }
    @Override
    public void terminate(){
    }
    public void receiveTouch(MotionEvent event){

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                    movingBall = !movingBall;
                    System.out.println("ACTION_DOWN");
                System.out.println("X: "+(int)event.getX() +"\n"+ "Y: "+ (int)event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                if (movingBall){
                  //  BallPoint.set((int)event.getX(), (int)event.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("ACTION_UP");
                break;
        }

    }

    Vector FindMTD(Vector<Point>PushVectors[], int iNumVectors) {
        Vector<Point> MTD = PushVectors[0];
        float mind2 = (PushVectors[0].get(0).x * PushVectors[0].get(1).x) + (PushVectors[0].get(0).y * PushVectors[0].get(1).y);
        for (int I = 1; I < iNumVectors; I++) {
            float d2 = (PushVectors[I].get(0).x * PushVectors[I].get(1).x) + (PushVectors[I].get(0).y * PushVectors[I].get(1).y);
            if (d2 < mind2) {
                mind2 = d2;
                MTD = PushVectors[I];
            }
        }
        return MTD;
    }

}
