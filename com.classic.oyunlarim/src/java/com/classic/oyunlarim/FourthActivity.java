package com.classic.oyunlarim;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class FourthActivity extends Activity implements OnGestureListener {
    Canvas canvas;
    GameArea gameArea;
    GestureDetector mDetector = new GestureDetector(this);
    int tap = 0;
    TextView txt;

    public void onShowPress(MotionEvent p1) {
    }

    public boolean onSingleTapUp(MotionEvent p1) {
        if (!this.gameArea.running) {
            int ı = this.tap + 1;
            this.tap = ı;
            if (ı == 4) {
                this.tap = 0;
                this.gameArea.startGame();
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
        GameArea gameArea = new GameArea(this);
        this.gameArea = gameArea;
        gameArea.setOnTouchListener(new OnTouchListener() {
            PointF DownPT = new PointF();
            PointF StartPT = new PointF();

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        FourthActivity.this.gameArea.x = (int) event.getX();
                        break;
                    case BuildConfig.VERSION_CODE /*1*/:
                        FourthActivity.this.gameArea.x = (int) event.getX();
                        break;
                    case 2:
                        FourthActivity.this.gameArea.x = ((int) event.getX()) - 100;
                        break;
                }
                return true;
            }
        });
        this.gameArea.setBackgroundColor(-16777216);
        setContentView(this.gameArea);
        this.gameArea.startGame();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                FourthActivity.this.gameArea.move();
                FourthActivity.this.gameArea.checkApple();
                FourthActivity.this.gameArea.checkCollisions();
            }
        }, 0, 20);
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
                        if (this.gameArea.direction != 'L') {
                            this.gameArea.direction = 'R';
                        }
                    } else if (this.gameArea.direction != 'R') {
                        this.gameArea.direction = 'L';
                    }
                    return true;
                }
            } else if (Math.abs(yDiff) > 100.0f && Math.abs(velocityY) > 100.0f) {
                if (yDiff > 0.0f) {
                    if (this.gameArea.direction != 'U') {
                        this.gameArea.direction = 'D';
                    }
                } else if (this.gameArea.direction != 'D') {
                    this.gameArea.direction = 'U';
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
