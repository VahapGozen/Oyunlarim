package com.classic.oyunlarim;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class FirstActivity extends Activity implements OnGestureListener {
    Canvas canvas;
    DrawView drawView;
    GestureDetector mDetector = new GestureDetector(this);
    int tap = 0;
    TextView txt;

    public void onShowPress(MotionEvent p1) {
    }

    public boolean onSingleTapUp(MotionEvent p1) {
        if (!this.drawView.running) {
            int ı = this.tap + 1;
            this.tap = ı;
            if (ı == 4) {
                this.tap = 0;
                this.drawView.startGame();
            }
        }
        return true;
    }

    public boolean onScroll(MotionEvent p1, MotionEvent p2, float p3, float p4) {
        return false;
    }

    public void onLongPress(MotionEvent event) {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawView drawView = new DrawView(this);
        this.drawView = drawView;
        drawView.setBackgroundColor(-16777216);
        setContentView(this.drawView);
        this.drawView.newApple();
        this.drawView.startGame();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                FirstActivity.this.drawView.move();
                FirstActivity.this.drawView.checkApple();
                FirstActivity.this.drawView.checkCollisions();
            }
        }, 0, 75);
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public boolean onDown(MotionEvent event) {
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float xDiff = e2.getX() - e1.getX();
        float yDiff = e2.getY() - e1.getY();
        try {
            if (Math.abs(xDiff) > Math.abs(yDiff)) {
                if (Math.abs(xDiff) > 100.0f && Math.abs(velocityX) > 100.0f) {
                    if (xDiff > 0.0f) {
                        if (this.drawView.direction != 'L') {
                            this.drawView.direction = 'R';
                        }
                    } else if (this.drawView.direction != 'R') {
                        this.drawView.direction = 'L';
                    }
                    return true;
                }
            } else if (Math.abs(yDiff) > 100.0f && Math.abs(velocityY) > 100.0f) {
                if (yDiff > 0.0f) {
                    if (this.drawView.direction != 'U') {
                        this.drawView.direction = 'D';
                    }
                } else if (this.drawView.direction != 'D') {
                    this.drawView.direction = 'U';
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
