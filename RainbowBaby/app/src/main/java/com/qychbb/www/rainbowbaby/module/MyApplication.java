package com.qychbb.www.rainbowbaby.module;

import android.app.Application;
import android.content.Context;

/**
 * 作者： Enic
 * 时间:  2017/4/10.
 * 介绍：
 */

public class MyApplication extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
