package com.example.kson.ksonview;

import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private MyView myView;
    private FlowLayout flowLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        myView = findViewById(R.id.myview);
//        for (int i = 0; i < 10; i++) {
//
//            TextView tv = new TextView(this);
//            tv.setText(i+"");
//            layout.addView(tv);
//
//
//        }

//        myView.invalidate();//重绘，直接触发onDraw()方法，只能在主线程通知重绘
//        myView.postInvalidate();//重绘，直接触发onDraw()方法，面试题，区别，子线程可以通知重绘
    }

//    public void add(View view) {
//        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        TextView textView = new TextView(this);
//        textView.setText("hhnininini");
//        marginLayoutParams.leftMargin = 5;
//        marginLayoutParams.rightMargin = 5;
//        textView.setBackgroundColor(Color.RED);
//
//        textView.setLayoutParams(marginLayoutParams);
//        flowLayout.add(textView);
//    }
}
