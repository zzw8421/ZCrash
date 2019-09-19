package com.zzw.mycarchtest;

import android.app.Application;

import com.zzw.zcrash.ZLogHelper;
import com.zzw.zcrash.ZCrashHelper;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: MyApplication
 **********************************************/
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ZCrashHelper.create(this);
        ZLogHelper.init(this);
    }
}
