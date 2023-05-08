package com.classic.oyunlarim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
    ImageView txt;
    ImageView txt2;
    ImageView txt3;
    ImageView txt4;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txt = (ImageView) findViewById(R.id.txt);
        this.txt2 = (ImageView) findViewById(R.id.txt2);
        this.txt3 = (ImageView) findViewById(R.id.txt3);
        this.txt4 = (ImageView) findViewById(R.id.txt4);
        this.txt.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, FirstActivity.class));
                MainActivity.this.finish();
            }
        });
        this.txt2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, SecondActivity.class));
                MainActivity.this.finish();
            }
        });
        this.txt3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                MainActivity.this.finish();
            }
        });
        this.txt4.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, FourthActivity.class));
                MainActivity.this.finish();
            }
        });
    }
}
