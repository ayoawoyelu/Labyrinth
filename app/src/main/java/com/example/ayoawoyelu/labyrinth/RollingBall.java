package com.example.ayoawoyelu.labyrinth;

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

    public RollingBall(Rect ball, int color){
        this.ball = ball;
        this.color = color;
    }

    public Rect getBall(){return ball;}

    @Override
    public void update() {

    }

    public void update(Point point, Canvas canvas){
        canvas = new Canvas();
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(point.x,point.y,25f,paint);
        //ball.set((point.x - ball.width()/5), (point.y - ball.height()/5), (point.x + ball.width()/5), (point.y + ball.height()/5));
    }
    public void update(Point point){
        ball.set((point.x - ball.width()/5), (point.y - ball.height()/5), (point.x + ball.width()/5), (point.y + ball.height()/5));
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle((float)Constants.SCREEN_WIDTH/2,(float)Constants.SCREEN_HEIGHT/2,25f,paint);

    }


}
