package com.fanyafeng.focustobig.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.fanyafeng.focustobig.R;
import com.fanyafeng.focustobig.BaseActivity;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class MainActivity extends BaseActivity {
    private Button btnGetFocus;
    private Button btnLoseFocus;
    private View viewTest, viewTest1, viewTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_main);
        isSetNavigationIcon = false;
        initView();
        initData();
    }


    //初始化UI控件
    private void initView() {
        btnGetFocus = (Button) findViewById(R.id.btnGetFocus);
        btnLoseFocus = (Button) findViewById(R.id.btnLoseFocus);

        viewTest = findViewById(R.id.viewTest);
        viewTest1 = findViewById(R.id.viewTest1);
        viewTest2 = findViewById(R.id.viewTest2);

    }

    //初始化数据
    private void initData() {
        viewTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        toBig(v);
                        return true;
                    case MotionEvent.ACTION_UP:
                        toNormal(v);
                        return true;
                }
                return false;
            }
        });

        viewTest1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("main", "获取数值：" + event.getAction());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        toBig(v);
                        return true;
                    case MotionEvent.ACTION_UP:
                        toNormal(v);
                        return true;
                }
                return false;
            }
        });

        viewTest2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("main", "获取数值：" + event.getAction());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        toBig(v);
                        return true;
                    case MotionEvent.ACTION_UP:
                        toNormal(v);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btnGetFocus:
                toBig(viewTest);
                break;
            case R.id.btnLoseFocus:
                toNormal(viewTest);
                break;
        }
    }

    private void toBig(View view) {
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.2f);
        objectAnimatorY.setDuration(200);
        objectAnimatorY.start();
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.2f);
        objectAnimatorX.setDuration(200);
        objectAnimatorX.start();
    }

    private void toNormal(View view) {
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(view, "scaleY", 1.2f, 1f);
        objectAnimatorY.setDuration(200);
        objectAnimatorY.start();
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(view, "scaleX", 1.2f, 1f);
        objectAnimatorX.setDuration(200);
        objectAnimatorX.start();
    }
}
