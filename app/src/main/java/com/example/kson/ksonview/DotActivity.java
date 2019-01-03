package com.example.kson.ksonview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kson.ksonview.bean.DotBean;

import java.util.Random;

public class DotActivity extends AppCompatActivity {

    private DotView dotView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot);
        dotView = findViewById(R.id.dotview);
    }

    /**
     * 随机添加点
     * @param view
     */
    public void add(View view) {

        //800px
        DotBean dotBean = new DotBean();
        dotBean.setX(new Random().nextInt(800));
        dotBean.setY(new Random().nextInt(1500));
        dotBean.setChecked(false);

        dotView.add(dotBean);


    }

    /**
     * 清除选重点
     * @param view
     */
    public void clear(View view) {

    }
}
