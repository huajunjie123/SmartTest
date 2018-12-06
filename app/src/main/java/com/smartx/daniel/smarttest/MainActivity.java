package com.smartx.daniel.smarttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.smartx.daniel.smarttest.utils.Logger;
import com.smartx.daniel.smarttest.utils.PrimeUtils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(mClickListener);
    }
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            test();
        }
    };

    private void test() {

        new Thread(){
            @Override
            public void run() {
                super.run();
                long startTime = System.currentTimeMillis();
                int result= PrimeUtils.getPrimCount2(1000000);
                Logger.d("计算耗时："+(System.currentTimeMillis()-startTime));
                Logger.d("质数的个数为："+result);


            }
        }.start();

    }
}
