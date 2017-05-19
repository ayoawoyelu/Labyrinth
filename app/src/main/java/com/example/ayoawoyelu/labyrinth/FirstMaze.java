package com.example.ayoawoyelu.labyrinth;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by Ayoawoyelu on 2017-02-18.
 */

public class FirstMaze implements MazeObject {
    public ArrayList<Rect> Lines;
    public int color;
    private BitmapFactory bf = new BitmapFactory();
    //left, top, right, bottom
      Rect topBorder = new Rect(0,0,Constants.SCREEN_WIDTH, 20);
      Rect bottomBorder = new Rect(0,Constants.SCREEN_HEIGHT- 20,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
      Rect leftBorder = new Rect(0,0,20,Constants.SCREEN_HEIGHT);
      Rect rightBorder = new Rect(Constants.SCREEN_WIDTH-20, 0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
      Bitmap wood = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.mipmap.wood);

        public FirstMaze(int color){
            this.color = color;
            Lines = new ArrayList<>();
            initializeObstacles();
        }

    public void initializeObstacles(){
        /*---------------------Obstacle Coordinates---------------------------*/
        Lines.add(new Rect(0,0,10,Constants.SCREEN_HEIGHT));
        Lines.add(new Rect(Constants.SCREEN_WIDTH-10,0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT));
        Lines.add(new Rect(0,0,Constants.SCREEN_WIDTH,10));
        Lines.add(new Rect(0,Constants.SCREEN_HEIGHT-10,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT));
//        Lines.add(new Rect(300,100,310,200));
//        Lines.add(new Rect(40,500,600,510));


        Lines.add(new Rect(45,350,55,450));
        Lines.add(new Rect(45,600,55,780));
        Lines.add(new Rect(45,930,55,1100));

        Lines.add(new Rect(95,180,105,360));
        Lines.add(new Rect(95,180,105,360));
        Lines.add(new Rect(95,420,105,600));
        Lines.add(new Rect(95,760,105,1020));

        Lines.add(new Rect(140,90,150,265));
        Lines.add(new Rect(140,340,150,440));
        Lines.add(new Rect(140,590,150,940));
        Lines.add(new Rect(140,1015,150,1200));

        Lines.add(new Rect(186,260,196,440));
        Lines.add(new Rect(186,760,196,1185));

        Lines.add(new Rect(240,180,250,275));
        Lines.add(new Rect(240,430,250,850));
        Lines.add(new Rect(240,1095,250,1192));

        Lines.add(new Rect(285,0,295,185));
        Lines.add(new Rect(285,260,295,520));
        Lines.add(new Rect(285,595,295,695));
        Lines.add(new Rect(285,840,295,950));
        Lines.add(new Rect(285,1020,295,1200));

        Lines.add(new Rect(330,98,340,185));
        Lines.add(new Rect(330,98,340,185));
        Lines.add(new Rect(330,510,340,605));
        Lines.add(new Rect(330,760,340,860));
        Lines.add(new Rect(330,925,340,1110));

        Lines.add(new Rect(380,0,390,265));
        Lines.add(new Rect(380,425,390,530));
        Lines.add(new Rect(380,600,390,775));
        Lines.add(new Rect(380,1020,390,1110));

        Lines.add(new Rect(425,260,435,520));
        Lines.add(new Rect(425,760,435,1020));
        Lines.add(new Rect(425,1180,435,Constants.SCREEN_HEIGHT));

        Lines.add(new Rect(472,90,482,280));
        Lines.add(new Rect(472,680,482,850));
        Lines.add(new Rect(472,1010,482,1195));

        Lines.add(new Rect(523,95,533,190));
        Lines.add(new Rect(523,340,533,528));
        Lines.add(new Rect(523,675,533,860));
        Lines.add(new Rect(523,930,533,1100));

        Lines.add(new Rect(567,0,577,117));
        Lines.add(new Rect(567,255,577,360));
        Lines.add(new Rect(567,510,577,600));
        Lines.add(new Rect(567,840,577,940));
        Lines.add(new Rect(567,1095,577,1190));

        Lines.add(new Rect(615,0,625,270));
        Lines.add(new Rect(615,340,625,520));
        Lines.add(new Rect(615,600,625,770));
        Lines.add(new Rect(615,925,625,1115));
        Lines.add(new Rect(615,1180,625,Constants.SCREEN_HEIGHT));

        Lines.add(new Rect(663,95,673,445));
        Lines.add(new Rect(663,510,673,610));

        Lines.add(new Rect(95,90,150,100));
        Lines.add(new Rect(195,90,290,100));
        Lines.add(new Rect(433,90,533,100));

        Lines.add(new Rect(150,180,250,190));
        Lines.add(new Rect(330,180,430,190));
        Lines.add(new Rect(520,180,625,190));

        Lines.add(new Rect(100,343,150,353));
        Lines.add(new Rect(190,343,290,353));
        Lines.add(new Rect(335,343,440,353));
        Lines.add(new Rect(480,343,570,353));
        Lines.add(new Rect(620,343,670,353));

        Lines.add(new Rect(50,430,100,440));
        Lines.add(new Rect(145,430,195,440));
        Lines.add(new Rect(338,430,385,440));
        Lines.add(new Rect(425,430,480,440));
        Lines.add(new Rect(570,430,620,440));

        Lines.add(new Rect(50,595,100,605));
        Lines.add(new Rect(140,595,193,605));
        Lines.add(new Rect(380,595,620,605));

        Lines.add(new Rect(100,680,250,690));
        Lines.add(new Rect(280,680,380,690));
        Lines.add(new Rect(430,680,570,690));
        Lines.add(new Rect(660,680,Constants.SCREEN_WIDTH,690));

        Lines.add(new Rect(50,763,100,773));
        Lines.add(new Rect(190,763,330,773));
        Lines.add(new Rect(380,763,425,773));
        Lines.add(new Rect(570,763,670,773));

        Lines.add(new Rect(0,260,105,270));
        Lines.add(new Rect(240,260,335,270));
        Lines.add(new Rect(425,260,483,270));
        Lines.add(new Rect(525,260,580,270));

        Lines.add(new Rect(0,511,55,521));
        Lines.add(new Rect(105,511,200,521));
        Lines.add(new Rect(245,511,390,521));
        Lines.add(new Rect(430,511,575,521));
        Lines.add(new Rect(615,511,Constants.SCREEN_WIDTH,521));

        Lines.add(new Rect(0,847,55,857));
        Lines.add(new Rect(335,847,385,857));
        Lines.add(new Rect(530,847,620,857));
        Lines.add(new Rect(665,847,Constants.SCREEN_WIDTH,857));

        Lines.add(new Rect(50,930,100,940));
        Lines.add(new Rect(190,930,530,940));
        Lines.add(new Rect(570,930,Constants.SCREEN_WIDTH,940));

        Lines.add(new Rect(100,1010,150,1020));
        Lines.add(new Rect(190,1010,240,1020));
        Lines.add(new Rect(520,1010,570,1020));
        Lines.add(new Rect(660,1010,Constants.SCREEN_WIDTH,1020));

        Lines.add(new Rect(50,1100,100,1110));
        Lines.add(new Rect(240,1100,290,1110));
        Lines.add(new Rect(380,1100,480,1110));
        Lines.add(new Rect(570,1100,670,1110));

        Lines.add(new Rect(0,1190,145,1200));
        Lines.add(new Rect(290,1190,430,1200));
        Lines.add(new Rect(475,1190,575,1200));
        Lines.add(new Rect(665,1190,Constants.SCREEN_WIDTH,1200));

    }
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        Rect src = new Rect(0,0,wood.getWidth(), wood.getHeight());
    for (int i = 0 ; i<Lines.size(); i++){
       // canvas.drawBitmap(wood, src, Lines.get(i), paint);
        canvas.drawRect(Lines.get(i), paint);
    }
    }
}
