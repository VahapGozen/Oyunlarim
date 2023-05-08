package com.classic.oyunlarim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Block extends View {
    static final long DELAY = 300;
    static final int GAME_UNITS = 20000;
    static final int SCREEN_HEIGHT = 1000;
    static final int SCREEN_WIDTH = 1000;
    static final int UNIT_SIZE = 50;
    int[] a;
    boolean aa;
    int appleX;
    int appleY;
    int applesEaten;
    int[] b;
    boolean bb;
    int bodyParts;
    int[] c;
    int[] d;
    char direction;
    int e;
    Paint p;
    Paint paint;
    int r;
    Random random;
    boolean running;
    int[] t;
    Timer timer;
    TimerTask tt;
    int[] x;
    int[] y;
    int[] z;

    public void startGame() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            switch (random.nextInt(5)) {
                case 0:
                    this.x[i] = 500;
                    this.z[i] = 500;
                    this.a[i] = 500;
                    this.c[i] = 500;
                    this.y[i] = 150;
                    this.t[i] = 100;
                    this.b[i] = UNIT_SIZE;
                    this.d[i] = 0;
                    break;
                case BuildConfig.VERSION_CODE /*1*/:
                    this.x[i] = 500;
                    this.z[i] = 500;
                    this.a[i] = 550;
                    this.c[i] = 550;
                    this.y[i] = 100;
                    this.t[i] = UNIT_SIZE;
                    this.b[i] = UNIT_SIZE;
                    this.d[i] = 0;
                    break;
                case 2:
                    this.x[i] = 500;
                    this.z[i] = 550;
                    this.a[i] = 550;
                    this.c[i] = 550;
                    this.y[i] = 100;
                    this.t[i] = 100;
                    this.b[i] = UNIT_SIZE;
                    this.d[i] = 0;
                    break;
                case 3:
                    this.x[i] = 500;
                    this.z[i] = 550;
                    this.a[i] = 500;
                    this.c[i] = 550;
                    this.y[i] = UNIT_SIZE;
                    this.t[i] = UNIT_SIZE;
                    this.b[i] = 0;
                    this.d[i] = 0;
                    break;
                case 4:
                    this.x[i] = 550;
                    this.z[i] = 500;
                    this.a[i] = 550;
                    this.c[i] = 550;
                    this.y[i] = 100;
                    this.t[i] = UNIT_SIZE;
                    this.b[i] = UNIT_SIZE;
                    this.d[i] = 0;
                    break;
                default:
                    break;
            }
        }
        this.running = true;
        this.bodyParts = 4;
        this.applesEaten = 0;
        this.direction = 'D';
    }

    public void newApple() {
    }

    /* JADX WARNING: Missing block: B:18:0x0049, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:30:0x0077, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:42:0x00a5, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x00a7;
     */
    /* JADX WARNING: Missing block: B:54:0x00d3, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x00d5;
     */
    /* JADX WARNING: Missing block: B:58:0x00e3, code skipped:
            if (r8.d[r1] == r8.b[r0]) goto L_0x0105;
     */
    /* JADX WARNING: Missing block: B:62:0x00f3, code skipped:
            if (r8.d[r1] == r8.t[r0]) goto L_0x0105;
     */
    public void stop() {
        /*
        r8 = this;
        r0 = 0;
    L_0x0001:
        r1 = r8.e;
        if (r0 >= r1) goto L_0x012c;
    L_0x0005:
        r2 = r8.x;
        r3 = r2[r1];
        r4 = r8.c;
        r5 = r4[r0];
        if (r3 != r5) goto L_0x0019;
    L_0x000f:
        r3 = r8.y;
        r3 = r3[r1];
        r5 = r8.d;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x0019:
        r3 = r2[r1];
        r5 = r8.a;
        r6 = r5[r0];
        if (r3 != r6) goto L_0x002b;
    L_0x0021:
        r3 = r8.y;
        r3 = r3[r1];
        r6 = r8.b;
        r6 = r6[r0];
        if (r3 == r6) goto L_0x0105;
    L_0x002b:
        r3 = r2[r1];
        r6 = r8.z;
        r7 = r6[r0];
        if (r3 != r7) goto L_0x003d;
    L_0x0033:
        r3 = r8.y;
        r3 = r3[r1];
        r7 = r8.t;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x003d:
        r3 = r2[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x004b;
    L_0x0043:
        r3 = r8.y;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x004b:
        r3 = r6[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x005b;
    L_0x0051:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.d;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x005b:
        r3 = r6[r1];
        r7 = r5[r0];
        if (r3 != r7) goto L_0x006b;
    L_0x0061:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.b;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x006b:
        r3 = r6[r1];
        r7 = r6[r0];
        if (r3 != r7) goto L_0x0079;
    L_0x0071:
        r3 = r8.t;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x0079:
        r3 = r6[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x0089;
    L_0x007f:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.y;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x0089:
        r3 = r5[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x0099;
    L_0x008f:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.d;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x0099:
        r3 = r5[r1];
        r7 = r5[r0];
        if (r3 != r7) goto L_0x00a7;
    L_0x009f:
        r3 = r8.b;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x00a7:
        r3 = r5[r1];
        r7 = r6[r0];
        if (r3 != r7) goto L_0x00b7;
    L_0x00ad:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.t;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x00b7:
        r3 = r5[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x00c7;
    L_0x00bd:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.y;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x00c7:
        r3 = r4[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x00d5;
    L_0x00cd:
        r3 = r8.d;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x00d5:
        r3 = r4[r1];
        r5 = r5[r0];
        if (r3 != r5) goto L_0x00e5;
    L_0x00db:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.b;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x00e5:
        r3 = r4[r1];
        r5 = r6[r0];
        if (r3 != r5) goto L_0x00f5;
    L_0x00eb:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.t;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x00f5:
        r3 = r4[r1];
        r2 = r2[r0];
        if (r3 != r2) goto L_0x0128;
    L_0x00fb:
        r2 = r8.d;
        r2 = r2[r1];
        r3 = r8.y;
        r3 = r3[r0];
        if (r2 != r3) goto L_0x0128;
    L_0x0105:
        r2 = r8.y;
        r3 = r2[r1];
        r3 = r3 + -50;
        r2[r1] = r3;
        r2 = r8.t;
        r3 = r2[r1];
        r3 = r3 + -50;
        r2[r1] = r3;
        r2 = r8.b;
        r3 = r2[r1];
        r3 = r3 + -50;
        r2[r1] = r3;
        r2 = r8.d;
        r3 = r2[r1];
        r3 = r3 + -50;
        r2[r1] = r3;
        r1 = 0;
        r8.running = r1;
    L_0x0128:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x012c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.classic.oyunlarim.Block.stop():void");
    }

    /* JADX WARNING: Missing block: B:18:0x0049, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:30:0x0077, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:42:0x00a5, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x00a7;
     */
    /* JADX WARNING: Missing block: B:54:0x00d3, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x00d5;
     */
    /* JADX WARNING: Missing block: B:58:0x00e3, code skipped:
            if (r8.d[r1] == r8.b[r0]) goto L_0x0105;
     */
    /* JADX WARNING: Missing block: B:62:0x00f3, code skipped:
            if (r8.d[r1] == r8.t[r0]) goto L_0x0105;
     */
    public void stopRight() {
        /*
        r8 = this;
        r0 = 0;
    L_0x0001:
        r1 = r8.e;
        if (r0 >= r1) goto L_0x0129;
    L_0x0005:
        r2 = r8.x;
        r3 = r2[r1];
        r4 = r8.c;
        r5 = r4[r0];
        if (r3 != r5) goto L_0x0019;
    L_0x000f:
        r3 = r8.y;
        r3 = r3[r1];
        r5 = r8.d;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x0019:
        r3 = r2[r1];
        r5 = r8.a;
        r6 = r5[r0];
        if (r3 != r6) goto L_0x002b;
    L_0x0021:
        r3 = r8.y;
        r3 = r3[r1];
        r6 = r8.b;
        r6 = r6[r0];
        if (r3 == r6) goto L_0x0105;
    L_0x002b:
        r3 = r2[r1];
        r6 = r8.z;
        r7 = r6[r0];
        if (r3 != r7) goto L_0x003d;
    L_0x0033:
        r3 = r8.y;
        r3 = r3[r1];
        r7 = r8.t;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x003d:
        r3 = r2[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x004b;
    L_0x0043:
        r3 = r8.y;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x004b:
        r3 = r6[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x005b;
    L_0x0051:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.d;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x005b:
        r3 = r6[r1];
        r7 = r5[r0];
        if (r3 != r7) goto L_0x006b;
    L_0x0061:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.b;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x006b:
        r3 = r6[r1];
        r7 = r6[r0];
        if (r3 != r7) goto L_0x0079;
    L_0x0071:
        r3 = r8.t;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x0079:
        r3 = r6[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x0089;
    L_0x007f:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.y;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x0089:
        r3 = r5[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x0099;
    L_0x008f:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.d;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x0099:
        r3 = r5[r1];
        r7 = r5[r0];
        if (r3 != r7) goto L_0x00a7;
    L_0x009f:
        r3 = r8.b;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x00a7:
        r3 = r5[r1];
        r7 = r6[r0];
        if (r3 != r7) goto L_0x00b7;
    L_0x00ad:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.t;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x00b7:
        r3 = r5[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x00c7;
    L_0x00bd:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.y;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x00c7:
        r3 = r4[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x00d5;
    L_0x00cd:
        r3 = r8.d;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x00d5:
        r3 = r4[r1];
        r5 = r5[r0];
        if (r3 != r5) goto L_0x00e5;
    L_0x00db:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.b;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x00e5:
        r3 = r4[r1];
        r5 = r6[r0];
        if (r3 != r5) goto L_0x00f5;
    L_0x00eb:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.t;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x00f5:
        r3 = r4[r1];
        r5 = r2[r0];
        if (r3 != r5) goto L_0x0125;
    L_0x00fb:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.y;
        r5 = r5[r0];
        if (r3 != r5) goto L_0x0125;
    L_0x0105:
        r3 = r2[r1];
        r3 = r3 + -50;
        r2[r1] = r3;
        r2 = r8.z;
        r3 = r2[r1];
        r3 = r3 + -50;
        r2[r1] = r3;
        r2 = r8.a;
        r3 = r2[r1];
        r3 = r3 + -50;
        r2[r1] = r3;
        r2 = r4[r1];
        r2 = r2 + -50;
        r4[r1] = r2;
        r1 = 68;
        r8.direction = r1;
    L_0x0125:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0129:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.classic.oyunlarim.Block.stopRight():void");
    }

    /* JADX WARNING: Missing block: B:18:0x0049, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:30:0x0077, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:42:0x00a5, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x00a7;
     */
    /* JADX WARNING: Missing block: B:54:0x00d3, code skipped:
            if (r3[r1] != r3[r0]) goto L_0x00d5;
     */
    /* JADX WARNING: Missing block: B:58:0x00e3, code skipped:
            if (r8.d[r1] == r8.b[r0]) goto L_0x0105;
     */
    /* JADX WARNING: Missing block: B:62:0x00f3, code skipped:
            if (r8.d[r1] == r8.t[r0]) goto L_0x0105;
     */
    public void stopLeft() {
        /*
        r8 = this;
        r0 = 0;
    L_0x0001:
        r1 = r8.e;
        if (r0 >= r1) goto L_0x0129;
    L_0x0005:
        r2 = r8.x;
        r3 = r2[r1];
        r4 = r8.c;
        r5 = r4[r0];
        if (r3 != r5) goto L_0x0019;
    L_0x000f:
        r3 = r8.y;
        r3 = r3[r1];
        r5 = r8.d;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x0019:
        r3 = r2[r1];
        r5 = r8.a;
        r6 = r5[r0];
        if (r3 != r6) goto L_0x002b;
    L_0x0021:
        r3 = r8.y;
        r3 = r3[r1];
        r6 = r8.b;
        r6 = r6[r0];
        if (r3 == r6) goto L_0x0105;
    L_0x002b:
        r3 = r2[r1];
        r6 = r8.z;
        r7 = r6[r0];
        if (r3 != r7) goto L_0x003d;
    L_0x0033:
        r3 = r8.y;
        r3 = r3[r1];
        r7 = r8.t;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x003d:
        r3 = r2[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x004b;
    L_0x0043:
        r3 = r8.y;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x004b:
        r3 = r6[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x005b;
    L_0x0051:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.d;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x005b:
        r3 = r6[r1];
        r7 = r5[r0];
        if (r3 != r7) goto L_0x006b;
    L_0x0061:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.b;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x006b:
        r3 = r6[r1];
        r7 = r6[r0];
        if (r3 != r7) goto L_0x0079;
    L_0x0071:
        r3 = r8.t;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x0079:
        r3 = r6[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x0089;
    L_0x007f:
        r3 = r8.t;
        r3 = r3[r1];
        r7 = r8.y;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x0089:
        r3 = r5[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x0099;
    L_0x008f:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.d;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x0099:
        r3 = r5[r1];
        r7 = r5[r0];
        if (r3 != r7) goto L_0x00a7;
    L_0x009f:
        r3 = r8.b;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x00a7:
        r3 = r5[r1];
        r7 = r6[r0];
        if (r3 != r7) goto L_0x00b7;
    L_0x00ad:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.t;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x00b7:
        r3 = r5[r1];
        r7 = r2[r0];
        if (r3 != r7) goto L_0x00c7;
    L_0x00bd:
        r3 = r8.b;
        r3 = r3[r1];
        r7 = r8.y;
        r7 = r7[r0];
        if (r3 == r7) goto L_0x0105;
    L_0x00c7:
        r3 = r4[r1];
        r7 = r4[r0];
        if (r3 != r7) goto L_0x00d5;
    L_0x00cd:
        r3 = r8.d;
        r7 = r3[r1];
        r3 = r3[r0];
        if (r7 == r3) goto L_0x0105;
    L_0x00d5:
        r3 = r4[r1];
        r5 = r5[r0];
        if (r3 != r5) goto L_0x00e5;
    L_0x00db:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.b;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x00e5:
        r3 = r4[r1];
        r5 = r6[r0];
        if (r3 != r5) goto L_0x00f5;
    L_0x00eb:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.t;
        r5 = r5[r0];
        if (r3 == r5) goto L_0x0105;
    L_0x00f5:
        r3 = r4[r1];
        r5 = r2[r0];
        if (r3 != r5) goto L_0x0125;
    L_0x00fb:
        r3 = r8.d;
        r3 = r3[r1];
        r5 = r8.y;
        r5 = r5[r0];
        if (r3 != r5) goto L_0x0125;
    L_0x0105:
        r3 = r2[r1];
        r3 = r3 + 50;
        r2[r1] = r3;
        r2 = r8.z;
        r3 = r2[r1];
        r3 = r3 + 50;
        r2[r1] = r3;
        r2 = r8.a;
        r3 = r2[r1];
        r3 = r3 + 50;
        r2[r1] = r3;
        r2 = r4[r1];
        r2 = r2 + 50;
        r4[r1] = r2;
        r1 = 68;
        r8.direction = r1;
    L_0x0125:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0129:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.classic.oyunlarim.Block.stopLeft():void");
    }

    public void move() {
        int i;
        int[] ıArr;
        switch (this.direction) {
            case 'D':
                i = this.r;
                while (true) {
                    int ı = this.e;
                    if (i <= ı) {
                        if (this.running) {
                            int[] ıArr2 = this.y;
                            ıArr2[i] = ıArr2[i] + UNIT_SIZE;
                            ıArr2 = this.t;
                            ıArr2[i] = ıArr2[i] + UNIT_SIZE;
                            ıArr2 = this.b;
                            ıArr2[i] = ıArr2[i] + UNIT_SIZE;
                            ıArr2 = this.d;
                            ıArr2[i] = ıArr2[i] + UNIT_SIZE;
                        } else {
                            this.r++;
                            this.e = ı + 1;
                            this.running = true;
                        }
                        i++;
                    } else {
                        stop();
                        return;
                    }
                }
            case 'L':
                for (i = this.r; i <= this.e; i++) {
                    if (this.running) {
                        ıArr = this.x;
                        ıArr[i] = ıArr[i] - 50;
                        ıArr = this.z;
                        ıArr[i] = ıArr[i] - 50;
                        ıArr = this.a;
                        ıArr[i] = ıArr[i] - 50;
                        ıArr = this.c;
                        ıArr[i] = ıArr[i] - 50;
                    } else {
                        this.direction = 'D';
                    }
                }
                stopLeft();
                return;
            case 'R':
                for (i = this.r; i <= this.e; i++) {
                    if (this.running) {
                        ıArr = this.x;
                        ıArr[i] = ıArr[i] + UNIT_SIZE;
                        ıArr = this.z;
                        ıArr[i] = ıArr[i] + UNIT_SIZE;
                        ıArr = this.a;
                        ıArr[i] = ıArr[i] + UNIT_SIZE;
                        ıArr = this.c;
                        ıArr[i] = ıArr[i] + UNIT_SIZE;
                    } else {
                        this.direction = 'D';
                    }
                }
                stopRight();
                return;
            default:
                return;
        }
    }

    public void checkApple() {
    }

    public void checkCollisions() {
        for (int i = this.r; i <= this.e; i++) {
            if (this.y[i] == 1000) {
                this.running = false;
            }
        }
        int[] ıArr = this.x;
        int ı = this.r;
        if (ıArr[ı] < 200 || this.z[ı] < 200 || this.a[ı] < 200 || this.c[ı] < 200) {
            ıArr[ı] = ıArr[ı] + UNIT_SIZE;
            int[] ıArr2 = this.z;
            ıArr2[ı] = ıArr2[ı] + UNIT_SIZE;
            ıArr2 = this.a;
            ıArr2[ı] = ıArr2[ı] + UNIT_SIZE;
            ıArr2 = this.c;
            ıArr2[ı] = ıArr2[ı] + UNIT_SIZE;
            this.direction = 'D';
        }
        if (ıArr[ı] + UNIT_SIZE > 850 || this.z[ı] + UNIT_SIZE > 850 || this.a[ı] + UNIT_SIZE > 850 || this.c[ı] + UNIT_SIZE > 850) {
            ıArr[ı] = ıArr[ı] - 50;
            ıArr = this.z;
            ıArr[ı] = ıArr[ı] - 50;
            ıArr = this.a;
            ıArr[ı] = ıArr[ı] - 50;
            ıArr = this.c;
            ıArr[ı] = ıArr[ı] - 50;
            this.direction = 'D';
        }
    }

    private void init() {
        this.paint.setColor(-1);
    }

    public Block(Context context) {
        super(context);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.z = new int[GAME_UNITS];
        this.t = new int[GAME_UNITS];
        this.a = new int[GAME_UNITS];
        this.b = new int[GAME_UNITS];
        this.c = new int[GAME_UNITS];
        this.d = new int[GAME_UNITS];
        this.bodyParts = 4;
        this.direction = 'D';
        this.running = false;
        this.e = 0;
        this.r = 0;
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public Block(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.z = new int[GAME_UNITS];
        this.t = new int[GAME_UNITS];
        this.a = new int[GAME_UNITS];
        this.b = new int[GAME_UNITS];
        this.c = new int[GAME_UNITS];
        this.d = new int[GAME_UNITS];
        this.bodyParts = 4;
        this.direction = 'D';
        this.running = false;
        this.e = 0;
        this.r = 0;
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public Block(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.z = new int[GAME_UNITS];
        this.t = new int[GAME_UNITS];
        this.a = new int[GAME_UNITS];
        this.b = new int[GAME_UNITS];
        this.c = new int[GAME_UNITS];
        this.d = new int[GAME_UNITS];
        this.bodyParts = 4;
        this.direction = 'D';
        this.running = false;
        this.e = 0;
        this.r = 0;
        this.paint = new Paint();
        this.p = new Paint();
        init();
    }

    public void onDraw(Canvas canvas) {
        int[] ıArr;
        float f;
        int[] ıArr2;
        float f2;
        int[] ıArr3;
        int i = 0;
        while (i <= 21) {
            if (i == 4 || i == 17) {
                canvas.drawLine((float) (i * UNIT_SIZE), 1050.0f, (float) (i * UNIT_SIZE), 0.0f, this.paint);
            }
            if (i == 0 || i == 21) {
                canvas.drawLine(0.0f, (float) (i * UNIT_SIZE), 1050.0f, (float) (i * UNIT_SIZE), this.paint);
            }
            i++;
        }
        this.paint.setColor(-65536);
        for (i = 0; i <= this.e; i++) {
            this.p.setColor(-16711936);
            ıArr = this.x;
            f = (float) ıArr[i];
            ıArr2 = this.y;
            canvas.drawRect(f, (float) ıArr2[i], (float) (ıArr[i] + UNIT_SIZE), (float) (ıArr2[i] + UNIT_SIZE), this.p);
            this.p.setColor(-16711936);
            ıArr = this.z;
            f = (float) ıArr[i];
            ıArr2 = this.t;
            canvas.drawRect(f, (float) ıArr2[i], (float) (ıArr[i] + UNIT_SIZE), (float) (ıArr2[i] + UNIT_SIZE), this.p);
            this.p.setColor(-16711936);
            ıArr = this.a;
            f = (float) ıArr[i];
            ıArr2 = this.b;
            canvas.drawRect(f, (float) ıArr2[i], (float) (ıArr[i] + UNIT_SIZE), (float) (ıArr2[i] + UNIT_SIZE), this.p);
            this.p.setColor(-16711936);
            ıArr = this.c;
            f2 = (float) ıArr[i];
            ıArr3 = this.d;
            canvas.drawRect(f2, (float) ıArr3[i], (float) (ıArr[i] + UNIT_SIZE), (float) (ıArr3[i] + UNIT_SIZE), this.p);
        }
        for (i = 0; i <= this.e; i++) {
            this.p.setColor(-16776961);
            ıArr = this.x;
            f = (float) (ıArr[i] + 10);
            ıArr2 = this.y;
            canvas.drawRect(f, (float) (ıArr2[i] + 10), (float) (ıArr[i] + 40), (float) (ıArr2[i] + 40), this.p);
            this.p.setColor(-16776961);
            ıArr = this.z;
            f = (float) (ıArr[i] + 10);
            ıArr2 = this.t;
            canvas.drawRect(f, (float) (ıArr2[i] + 10), (float) (ıArr[i] + 40), (float) (ıArr2[i] + 40), this.p);
            this.p.setColor(-16776961);
            ıArr = this.a;
            f = (float) (ıArr[i] + 10);
            ıArr2 = this.b;
            canvas.drawRect(f, (float) (ıArr2[i] + 10), (float) (ıArr[i] + 40), (float) (ıArr2[i] + 40), this.p);
            this.p.setColor(-16776961);
            ıArr = this.c;
            f2 = (float) (ıArr[i] + 10);
            ıArr3 = this.d;
            canvas.drawRect(f2, (float) (ıArr3[i] + 10), (float) (ıArr[i] + 40), (float) (ıArr3[i] + 40), this.p);
        }
        this.p.setColor(-65536);
        this.p.setTextSize(50.0f);
        canvas.drawText("Score: " + this.applesEaten, 50.0f, 50.0f, this.p);
        invalidate();
    }
}
