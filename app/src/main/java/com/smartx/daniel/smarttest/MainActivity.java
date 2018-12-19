package com.smartx.daniel.smarttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.smartx.daniel.smarttest.utils.Logger;
import com.smartx.daniel.smarttest.utils.PrimeUtils;
import com.smartx.daniel.smarttest.utils.SortUtils;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(mClickListener);
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
            testPrime(10000000);
//                testSort();
            }
        }.start();

    }

    private void testPrime(int num){
        long startTime = System.currentTimeMillis();
        int result= PrimeUtils.getPrimCount2(num);
        Logger.d("计算耗时："+(System.currentTimeMillis()-startTime));
        Logger.d("结果为："+ result);
    }

    private void testSort(){
        long startTime = System.currentTimeMillis();
        int[] array= {42,20,17,13,14,28,23,15};
        int[] arrayNew = SortUtils.quickSort(array,0,array.length-1);
        Logger.d("计算耗时："+(System.currentTimeMillis()-startTime));
        Logger.d("结果为："+ Arrays.toString(arrayNew));

    }
}
