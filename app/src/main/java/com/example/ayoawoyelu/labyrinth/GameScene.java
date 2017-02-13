package com.example.ayoawoyelu.labyrinth;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Ayoawoyelu on 2017-02-12.
 */

public class GameScene extends SurfaceView implements SurfaceHolder.Callback {

    public GameScene(Context context){
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
