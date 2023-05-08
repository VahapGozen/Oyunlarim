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

public class GameArea extends View {
    static final long DELAY = 20;
    static final int GAME_UNITS = 60000;
    static final int SCREEN_HEIGHT = 1500;
    static final int SCREEN_WIDTH = 1000;
    static final int UNIT_SIZE = 25;
    int[][] Bricks;
    int a;
    int appleX;
    int appleY;
    int applesEaten;
    int b;
    char direction;
    Paint p;
    Paint paint;
    boolean running;
    Timer timer;
    TimerTask tt;
    int x;
    int y;

    public void startGame() {
        this.appleX = new Random().nextInt(20) * 50;
        this.appleY = 750;
        this.running = true;
        this.applesEaten = 0;
    }

    public void move() {
        this.appleX += this.a;
        this.appleY += this.b;
    }

    public void checkApple() {
    }

    public void checkCollisions() {
        int ı = this.appleX;
        int ı2 = ı + 50;
        int ı3 = this.x;
        if (ı2 >= ı3 && ı <= ı3 + 200 && this.appleY == 1450) {
            this.b = -this.b;
        }
        if (ı == 0) {
            this.a = -this.a;
        }
        if (ı == SCREEN_WIDTH) {
            this.a = -this.a;
        }
        ı = this.appleY;
        if (ı == 0) {
            this.b = -this.b;
        }
        if (ı == SCREEN_HEIGHT) {
            this.running = false;
        }
    }

    private void init() {
        this.paint.setColor(-1);
    }

    public GameArea(Context context) {
        super(context);
        this.x = 400;
        this.y = SCREEN_HEIGHT;
        this.appleX = 900;
        this.appleY = 750;
        this.a = 10;
        this.b = 10;
        this.direction = 'R';
        this.running = false;
        this.Bricks = new int[][]{new int[]{0, 1, 0, 0, 0, 1, 0}, new int[]{1, 1, 1, 0, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1, 1, 0}, new int[]{0, 0, 1, 1, 1, 0, 0}, new int[]{0, 0, 0, 1, 0, 0, 0}};
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public GameArea(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.x = 400;
        this.y = SCREEN_HEIGHT;
        this.appleX = 900;
        this.appleY = 750;
        this.a = 10;
        this.b = 10;
        this.direction = 'R';
        this.running = false;
        this.Bricks = new int[][]{new int[]{0, 1, 0, 0, 0, 1, 0}, new int[]{1, 1, 1, 0, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1, 1, 0}, new int[]{0, 0, 1, 1, 1, 0, 0}, new int[]{0, 0, 0, 1, 0, 0, 0}};
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public GameArea(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.x = 400;
        this.y = SCREEN_HEIGHT;
        this.appleX = 900;
        this.appleY = 750;
        this.a = 10;
        this.b = 10;
        this.direction = 'R';
        this.running = false;
        this.Bricks = new int[][]{new int[]{0, 1, 0, 0, 0, 1, 0}, new int[]{1, 1, 1, 0, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1, 1, 0}, new int[]{0, 0, 1, 1, 1, 0, 0}, new int[]{0, 0, 0, 1, 0, 0, 0}};
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        String str = "Score: ";
        if (this.running) {
            int j;
            int ı;
            for (int i = 0; i <= 62; i++) {
                canvas.drawLine((float) (i * UNIT_SIZE), 1550.0f, (float) (i * UNIT_SIZE), 0.0f, this.paint);
                canvas.drawLine(0.0f, (float) (i * UNIT_SIZE), 1075.0f, (float) (i * UNIT_SIZE), this.paint);
            }
            int by = 150;
            int i2 = 0;
            while (true) {
                int ı2 = 7;
                if (i2 >= 7) {
                    break;
                }
                int j2;
                int bx;
                int bx2 = 150;
                j = 0;
                while (j < ı2) {
                    int ı3;
                    int[][] ıArr = this.Bricks;
                    if (ıArr[i2][j] == 1) {
                        ı = this.appleX;
                        if (ı >= bx2 && ı <= bx2 + 100 && this.appleY + 50 == by) {
                            ıArr[i2][j] = 0;
                            this.b = -this.b;
                            this.applesEaten++;
                        }
                        if (ı >= bx2 && ı <= bx2 + 100 && this.appleY == by + 50) {
                            ıArr[i2][j] = 0;
                            this.b = -this.b;
                            this.applesEaten++;
                        }
                        ı2 = this.appleY;
                        if (ı2 >= by && ı2 <= by && ı + 50 == bx2) {
                            ıArr[i2][j] = 0;
                            this.a = -this.a;
                            this.applesEaten++;
                        }
                        if (ı2 >= by && ı2 <= by && ı == bx2 + 100) {
                            ıArr[i2][j] = 0;
                            this.a = -this.a;
                            this.applesEaten++;
                        }
                        this.p.setColor(-65281);
                        float f = (float) (by + 50);
                        j2 = j;
                        bx = bx2;
                        float f2 = f;
                        ı3 = 7;
                        canvas.drawRect((float) bx2, (float) by, (float) (bx2 + 100), f2, this.p);
                    } else {
                        j2 = j;
                        bx = bx2;
                        ı3 = ı2;
                    }
                    bx2 = bx + 110;
                    j = j2 + 1;
                    ı2 = ı3;
                }
                j2 = j;
                bx = bx2;
                by += 60;
                i2++;
            }
            if (this.applesEaten == 31) {
                this.p.setTextSize(100.0f);
                canvas2.drawText("You Won!", 350.0f, 525.0f, this.p);
            }
            ı = this.appleX;
            float f3 = (float) ı;
            j = this.appleY;
            RectF rect = new RectF(f3, (float) j, (float) (ı + 50), (float) (j + 50));
            this.paint.setColor(-256);
            canvas2.drawOval(rect, this.paint);
            this.p.setColor(-65281);
            int ı4 = this.x;
            float f4 = (float) ı4;
            int ı5 = this.y;
            canvas.drawRect(f4, (float) ı5, (float) (ı4 + 200), (float) (ı5 + UNIT_SIZE), this.p);
            this.p.setColor(-65536);
            this.p.setTextSize(50.0f);
            canvas2.drawText(str + this.applesEaten, 450.0f, 50.0f, this.p);
        } else {
            this.p.setTextSize(100.0f);
            canvas2.drawText(str + this.applesEaten, 350.0f, 525.0f, this.p);
        }
        invalidate();
    }
}
