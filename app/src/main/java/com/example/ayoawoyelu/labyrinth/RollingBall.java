package com.example.ayoawoyelu.labyrinth;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Ayoawoyelu on 2017-02-12.
 */

public class RollingBall implements BallObject {
    private Rect ball;
    private int color;
    private  Bitmap rollRight;
    public Bitmap rollLeft;
    private Bitmap [] Frames;
    public int currFrame;
    public int height;
    public int width;

    public RollingBall(Rect ball, int color, Bitmap bitmap){
        this.ball = ball;
        this.color = color;
        this.rollRight = bitmap;
        // currFrame = 0;

        height = bitmap.getHeight();
        width = bitmap.getWidth()/36+1;
        currFrame = 0;
    }
    public Rect getBall(){
        return ball;
    }
    @Override
    public void update() {

    }
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle((float)Constants.SCREEN_WIDTH/2,(float)Constants.SCREEN_HEIGHT/2,25f,paint);
    }
    public void update(Point point){

        ball.set((point.x - ball.width()/2), (point.y - ball.height()/2), (point.x + ball.width()/2), (point.y + ball.height()/2));
        // ball.set((point.x - ball.width()/5), (point.y - ball.height()/5), (point.x + ball.width()/5), (point.y + ball.height()/5));
    }
    public int FramesMachine(Point BallPoint){
        int state=0;
        int srcX= 0;
        int sHor = BallPoint.x;
        int SVert = BallPoint.y;
        if(BallPoint.x-sHor >1 && BallPoint.y-SVert<3){
            //Right
            currFrame = ++currFrame%36;
            srcX = currFrame*width;
        }
        else if(BallPoint.x-sHor <1 && BallPoint.y-SVert<3){
            currFrame = (--currFrame%36);
            srcX = (currFrame+35) * width;
        }
        return  srcX;
    }
    public void draw(Canvas canvas, Point point) {
        Paint paint = new Paint();
        paint.setColor(color);
        //Left
        int srcX = 0;
        int oldLeft = point.x;

        //Left
//        if(Constants.SCREEN_WIDTH/2-point.x <-1) {
//            currFrame = ++currFrame%36;
//            srcX = currFrame*width;
//        } else {
//            currFrame = (--currFrame % 36);
//            srcX = (currFrame + 35) * width;
//        }
        currFrame = ++currFrame%36;
        srcX = currFrame*width;
        //Right
        //currFrame = ++currFrame%36;
        // int srcX = currFrame*width;
        Rect src = new Rect(srcX,0,srcX+width, height);
        update(point);
//------------For image
        canvas.drawBitmap(rollRight, src, ball, paint );
        //left, top right bottom
        //canvas.drawCircle((float)point.x,(float)point.y,15f,paint);
    }


}