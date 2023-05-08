package com.classic.oyunlarim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DrawView extends View {
    static final long DELAY = 75;
    static final int GAME_UNITS = 20000;
    static final int SCREEN_HEIGHT = 1000;
    static final int SCREEN_WIDTH = 1000;
    static final int UNIT_SIZE = 50;
    int appleX;
    int appleY;
    int applesEaten;
    int bodyParts;
    char direction;
    Paint p;
    Paint paint;
    Random random;
    boolean running;
    Timer timer;
    TimerTask tt;
    int[] x;
    int[] y;

    public void startGame() {
        for (int i = 0; i < this.bodyParts; i++) {
            this.x[i] = 0;
            this.y[i] = 0;
        }
        newApple();
        this.running = true;
        this.bodyParts = 6;
        this.applesEaten = 0;
        this.direction = 'R';
    }

    public void newApple() {
        Random random = new Random();
        this.appleX = random.nextInt(20) * UNIT_SIZE;
        this.appleY = random.nextInt(20) * UNIT_SIZE;
    }

    public void move() {
        for (int i = this.bodyParts; i > 0; i--) {
            int[] ıArr = this.x;
            ıArr[i] = ıArr[i - 1];
            ıArr = this.y;
            ıArr[i] = ıArr[i - 1];
        }
        int[] ıArr2;
        switch (this.direction) {
            case 'D':
                ıArr2 = this.y;
                ıArr2[0] = ıArr2[0] + UNIT_SIZE;
                return;
            case 'L':
                ıArr2 = this.x;
                ıArr2[0] = ıArr2[0] - 50;
                return;
            case 'R':
                ıArr2 = this.x;
                ıArr2[0] = ıArr2[0] + UNIT_SIZE;
                return;
            case 'U':
                ıArr2 = this.y;
                ıArr2[0] = ıArr2[0] - 50;
                return;
            default:
                return;
        }
    }

    public void checkApple() {
        if (this.x[0] == this.appleX && this.y[0] == this.appleY) {
            this.bodyParts++;
            this.applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        for (int i = this.bodyParts; i > 0; i--) {
            int[] ıArr = this.x;
            if (ıArr[0] == ıArr[i]) {
                ıArr = this.y;
                if (ıArr[0] == ıArr[i]) {
                    this.running = false;
                }
            }
        }
        int[] ıArr2 = this.x;
        if (ıArr2[0] < 0) {
            ıArr2[0] = 1000;
        }
        if (ıArr2[0] > 1000) {
            ıArr2[0] = 0;
        }
        ıArr2 = this.y;
        if (ıArr2[0] < 0) {
            ıArr2[0] = 1000;
        }
        if (ıArr2[0] > 1000) {
            ıArr2[0] = 0;
        }
    }

    private void init() {
        this.paint.setColor(-1);
    }

    public DrawView(Context context) {
        super(context);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.bodyParts = 6;
        this.direction = 'R';
        this.running = false;
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.bodyParts = 6;
        this.direction = 'R';
        this.running = false;
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.bodyParts = 6;
        this.direction = 'R';
        this.running = false;
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public void onDraw(Canvas canvas) {
        String str = "Score: ";
        if (this.running) {
            int i = 0;
            while (i <= 21) {
                if (i == 0 || i == 21) {
                    canvas.drawLine((float) (i * UNIT_SIZE), 1050.0f, (float) (i * UNIT_SIZE), 0.0f, this.paint);
                    canvas.drawLine(0.0f, (float) (i * UNIT_SIZE), 1050.0f, (float) (i * UNIT_SIZE), this.paint);
                }
                i++;
            }
            int ı = this.appleX;
            float f = (float) ı;
            int ı2 = this.appleY;
            RectF rect = new RectF(f, (float) ı2, (float) (ı + UNIT_SIZE), (float) (ı2 + UNIT_SIZE));
            this.paint.setColor(-65536);
            canvas.drawOval(rect, this.paint);
            for (int i2 = 0; i2 < this.bodyParts; i2++) {
                int[] ıArr;
                float f2;
                int[] ıArr2;
                if (i2 == 0) {
                    this.paint.setColor(-16711936);
                    ıArr = this.x;
                    f2 = (float) ıArr[i2];
                    ıArr2 = this.y;
                    canvas.drawRect(f2, (float) ıArr2[i2], (float) (ıArr[i2] + UNIT_SIZE), (float) (ıArr2[i2] + UNIT_SIZE), this.paint);
                } else {
                    this.p.setColor(-16711936);
                    ıArr = this.x;
                    f2 = (float) ıArr[i2];
                    ıArr2 = this.y;
                    canvas.drawRect(f2, (float) ıArr2[i2], (float) (ıArr[i2] + UNIT_SIZE), (float) (ıArr2[i2] + UNIT_SIZE), this.p);
                }
            }
            this.p.setColor(-65536);
            this.p.setTextSize(50.0f);
            canvas.drawText(str + this.applesEaten, 450.0f, 50.0f, this.p);
        } else {
            this.p.setTextSize(100.0f);
            canvas.drawText(str + this.applesEaten, 350.0f, 525.0f, this.p);
        }
        invalidate();
    }
}
