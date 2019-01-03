package com.example.kson.ksonview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    private Paint mPaint;//画笔
    private int circleX;//圆的x轴起始坐标
    private int circleY;//圆的y轴起始坐标
    private int mRaduis = 100;//圆半径，px
    private int mColor = Color.RED;

    /**
     * new 一个控件的调用的
     * @param context
     */
    public MyView(Context context) {
        this(context,null);
    }

    /**
     * 自定义view中包含自定义属性的，属性是什么
     * @param context
     * @param attrs
     */
    public MyView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * 自定义view中，包含属性和样式
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

//    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    /**
     * 初始化对象的方法
     */
    private  void init(Context context,AttributeSet attrs){
        //对自定义属性初始化
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyView);
        mRaduis = typedArray.getDimensionPixelSize(R.styleable.MyView_radius,100);//id，默认值100
        mColor = typedArray.getColor(R.styleable.MyView_color,Color.RED);

        //初始化成功后，处理
        if (typedArray!=null){
            typedArray.recycle();//回收资源
        }

        mPaint = new Paint();
        mPaint.setColor(mColor);//设置画笔为红色
        mPaint.setAntiAlias(true);//抗锯齿
//        mPaint.setStyle(Paint.Style.FILL);//实心
        mPaint.setStyle(Paint.Style.STROKE);//空心
        mPaint.setStrokeWidth(20);

    }

    /**
     * 测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 在onmeasure之后
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 摆放
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("重绘："+"==============");
        canvas.drawCircle(circleX,circleY,mRaduis,mPaint);


    }

    /**
     * 触摸事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){//动作行为
            case MotionEvent.ACTION_DOWN://按下
                circleX = (int) event.getX();//获取距离父控件的x轴坐标
//                circleX = (int) event.getRawX();//获取距离屏幕边缘的x轴坐标
                circleY = (int) event.getY();
                invalidate();//重绘

                break;
            case MotionEvent.ACTION_MOVE://滑动
                circleX = (int) event.getX();
                circleY = (int) event.getY();

                invalidate();


                break;
            case MotionEvent.ACTION_UP://抬起



                break;
        }
        return true;//返回true，证明消费了这个事件（三个时间都运行了，包括按下，滑动，抬起），false的化，只走down事件

    }
}
