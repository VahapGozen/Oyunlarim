package com.classic.oyunlarim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;

public class Panel extends View {
    static final long DELAY = 8;
    static final int GAME_UNITS = 1166400;
    static final int SCREEN_HEIGHT = 1080;
    static final int SCREEN_WIDTH = 1080;
    static final int UNIT_SIZE = 1;
    int alt;
    int[] alt2;
    int appleX;
    int appleY;
    Paint boru;
    Paint boru2;
    char direction;
    int dogus;
    Paint gok;
    Paint paint;
    Random random;
    boolean running;
    int skor;
    int ust;
    int[] ust2;
    int[] x;
    int[] y;

    public void restart() {
        for (int j = 0; j < 50; j++) {
            this.x[j] = 0;
        }
        this.skor = 0;
        this.appleX = 480;
        this.appleY = 540;
        this.running = true;
        Panel();
    }

    public void Panel() {
        for (int i = 0; i < 50; i++) {
            this.ust2[i] = this.random.nextInt(700) + 100;
            this.alt2[i] = (1080 - this.ust2[i]) - 280;
        }
    }

    public void gok(Canvas canvas) {
        int i = 0;
        while (i <= 108) {
            if (i == 0 || i == 108) {
                canvas.drawLine((float) (i * 10), 1080.0f, (float) (i * 10), 0.0f, this.paint);
                canvas.drawLine(0.0f, (float) (i * 10), 1080.0f, (float) (i * 10), this.paint);
            }
            i++;
        }
        i = 0;
        while (i <= 1080) {
            if (!(i == 0 || i == 1080)) {
                this.gok.setColor(-16776961);
                canvas.drawLine((float) (i * 1), 1080.0f, (float) (i * 1), 0.0f, this.gok);
                canvas.drawLine(0.0f, (float) (i * 1), 1080.0f, (float) (i * 1), this.gok);
            }
            i++;
        }
    }

    private void init() {
        this.paint.setColor(-65536);
    }

    public Panel(Context context) {
        super(context);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.direction = 'L';
        this.dogus = 1080;
        this.alt = 400;
        this.ust = 400;
        this.alt2 = new int[GAME_UNITS];
        this.ust2 = new int[GAME_UNITS];
        this.appleX = 480;
        this.appleY = 540;
        this.skor = 0;
        this.running = true;
        this.random = new Random();
        this.paint = new Paint();
        this.gok = new Paint();
        this.boru = new Paint();
        this.boru2 = new Paint();
        init();
    }

    public Panel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.direction = 'L';
        this.dogus = 1080;
        this.alt = 400;
        this.ust = 400;
        this.alt2 = new int[GAME_UNITS];
        this.ust2 = new int[GAME_UNITS];
        this.appleX = 480;
        this.appleY = 540;
        this.skor = 0;
        this.running = true;
        this.random = new Random();
        this.paint = new Paint();
        this.gok = new Paint();
        this.boru = new Paint();
        this.boru2 = new Paint();
        init();
    }

    public Panel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.direction = 'L';
        this.dogus = 1080;
        this.alt = 400;
        this.ust = 400;
        this.alt2 = new int[GAME_UNITS];
        this.ust2 = new int[GAME_UNITS];
        this.appleX = 480;
        this.appleY = 540;
        this.skor = 0;
        this.running = true;
        this.random = new Random();
        this.paint = new Paint();
        this.gok = new Paint();
        this.boru = new Paint();
        this.boru2 = new Paint();
        init();
    }

    public void onDraw(Canvas canvas) {
        gok(canvas);
        int ı = this.appleX;
        float f = (float) ı;
        int ı2 = this.appleY;
        RectF rect = new RectF(f, (float) ı2, (float) (ı + 50), (float) (ı2 + 50));
        this.paint.setColor(-65536);
        canvas.drawOval(rect, this.paint);
        ı = 0;
        for (ı2 = 0; ı2 < 50; ı2++) {
            this.boru2.setColor(-16711936);
            int ı3 = this.dogus + ı;
            int[] ıArr = this.x;
            float f2 = (float) (ı3 + ıArr[ı2]);
            int[] ıArr2 = this.y;
            canvas.drawRect(f2, (float) ıArr2[ı2], (float) (((ıArr[ı2] + 1080) + ı) + 100), (float) (ıArr2[ı2] + this.ust2[ı2]), this.boru2);
            ı3 = this.dogus;
            int ı4 = ı3 + ı;
            int[] ıArr3 = this.x;
            float f3 = (float) (ı4 + ıArr3[ı2]);
            ı3 -= this.alt2[ı2];
            ıArr = this.y;
            canvas.drawRect(f3, (float) (ı3 + ıArr[ı2]), (float) (((ıArr3[ı2] + 1080) + ı) + 100), (float) (ıArr[ı2] + 1080), this.boru2);
            ı += 400;
        }
        this.paint.setColor(-65536);
        this.paint.setTextSize(50.0f);
        canvas.drawText("Score: " + this.skor, 450.0f, 50.0f, this.paint);
        invalidate();
    }

    public void move() {
        int[] ıArr;
        switch (this.direction) {
            case 'D':
                ıArr = this.y;
                ıArr[0] = ıArr[0] + 1;
                return;
            case 'L':
                if (this.running) {
                    for (int i = 0; i < 50; i++) {
                        int[] ıArr2 = this.x;
                        ıArr2[i] = ıArr2[i] - 1;
                    }
                    this.appleY += 2;
                    return;
                }
                return;
            case 'R':
                ıArr = this.x;
                ıArr[0] = ıArr[0] + 1;
                return;
            case 'U':
                ıArr = this.y;
                ıArr[0] = ıArr[0] - 1;
                return;
            default:
                return;
        }
    }

    public void checkCollisions() {
        int i;
        for (i = 0; i < 50; i++) {
            if (this.x[i] + 100 == (-700 - (i * 400)) + 100) {
                this.skor = i + 1;
            }
        }
        if (this.appleY + 45 >= 1080) {
            this.running = false;
        }
        i = 0;
        while (i < 50) {
            int[] ıArr = this.x;
            if (ıArr[i] - 45 <= -600 - (i * 400) && ıArr[i] + 100 > (-700 - (i * 400)) + 100) {
                int ı = this.appleY;
                if (ı + 45 > this.ust2[i] + 280) {
                    this.running = false;
                }
                if (ı < 1080 - (this.alt2[i] + 280)) {
                    this.running = false;
                }
            }
            i++;
        }
        for (i = 0; i < 50; i++) {
            if (this.x[49] < -20780) {
                for (int j = 0; j < 50; j++) {
                    this.x[j] = 0;
                }
                Panel();
            }
        }
    }
}
