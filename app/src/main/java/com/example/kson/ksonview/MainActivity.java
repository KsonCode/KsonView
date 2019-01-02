package com.example.kson.ksonview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        myView = findViewById(R.id.myview);
        for (int i = 0; i < 10; i++) {

            TextView tv = new TextView(this);
            tv.setText(i+"");
            layout.addView(tv);

        }

        myView.invalidate();//重绘，直接触发onDraw()方法，只能在主线程通知重绘
        myView.postInvalidate();//重绘，直接触发onDraw()方法，面试题，区别，子线程可以通知重绘
    }
}
