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

    public void draw(Canvas canvas, Point point) {
        Paint paint = new Paint();
        paint.setColor(color);
        //Left
        int srcX = 0;
        //Left
        currFrame = (--currFrame%36);
        srcX= (currFrame+35) * width;
        //Right
        //currFrame = ++currFrame%36;
        // int srcX = currFrame*width;
        Rect src = new Rect(srcX,0,srcX+width, height);
       // Rect dst = new Rect(new Rect(Constants.SCREEN_WIDTH/2 -50, Constants.SCREEN_HEIGHT/2-50, Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2));
        //dst.set((point.x - dst.width()/2), (point.y - dst.height()/2), (point.x + dst.width()/2), (point.y + dst.height()/2));
        update(point);
//------------For image
        canvas.drawBitmap(rollRight, src, ball, paint );
        //left, top right bottom
       // canvas.drawCircle((float)point.x,(float)point.y,15f,paint);
    }


}
