package com.classic.oyunlarim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends Activity {
    Panel panel;
    int tap = 0;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Panel panel = new Panel(this);
        this.panel = panel;
        setContentView(panel);
        this.panel.Panel();
        timr();
        this.panel.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (SecondActivity.this.panel.running) {
                    Panel panel = SecondActivity.this.panel;
                    panel.appleY -= 100;
                }
                if (!SecondActivity.this.panel.running) {
                    SecondActivity secondActivity = SecondActivity.this;
                    secondActivity.tap++;
                    if (SecondActivity.this.tap == 4) {
                        SecondActivity.this.tap = 0;
                        SecondActivity.this.panel.restart();
                    }
                }
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void timr() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                SecondActivity.this.panel.move();
                SecondActivity.this.panel.checkCollisions();
            }
        }, 0, 8);
    }
}
