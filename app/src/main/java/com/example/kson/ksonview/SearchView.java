package com.example.kson.ksonview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchView extends LinearLayout {
    private ImageView backIv;
    private TextView searchTv;
    private EditText editText;
    private int searchColor ;
    private int searchSize;

    public SearchView(Context context) {
        this(context,null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attributeSet){
        initAttrs(context,attributeSet);
        initView();
        initData();

    }

    /**
     * 初始化数据
     */
    private void initData() {

    }

    /**
     * 初始化自定义属性
     * @param context
     * @param attributeSet
     */
    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet,R.styleable.SearchView);
        searchColor = typedArray.getColor(R.styleable.SearchView_searchColor,Color.BLUE);

        if (typedArray!=null){
            typedArray.recycle();//回收资源
        }

    }

    /**
     * 初始化组合控件的子控件
     */
    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.search_layout,this,true);
//        addView(view);
        backIv = view.findViewById(R.id.back);
        searchTv = view.findViewById(R.id.tv_search);
        editText = view.findViewById(R.id.et_search);

        searchTv.setTextColor(searchColor);//动态设置颜色

        backIv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchViewCallback!=null){
                    searchViewCallback.onClickListener(v);
                }

            }
        });

        searchTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editText.getText().toString())){
                    if (searchViewCallback!=null)
                        searchViewCallback.keywordsEmpty();
                    return;
                }
                if (searchViewCallback!=null)
                    searchViewCallback.searchClick(editText.getText().toString());


            }
        });

    }

    private SearchViewCallback searchViewCallback;

    /**
     * 调用者去调用
     * @param searchViewCallback
     */
    public void setSearchViewCallback(SearchViewCallback searchViewCallback) {
        this.searchViewCallback = searchViewCallback;
    }

    public interface SearchViewCallback{
        void keywordsEmpty();
        void onClickListener(View v);//点击事件
        void searchClick(String keywords);//搜索点击事件
    }
}
