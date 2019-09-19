package com.zzw.zcrash;

/**********************************************
 @author: created by 
 @date: 2019/9/18
 @email: zhengzhiwei333@gmail.com
 @describe: ZLog
 **********************************************/
public class ZLog {
    public static final int V = 1;
    public static final int D = 2;
    public static final int I = 3;
    public static final int W = 4;
    public static final int E = 5;


    public static void v(String TAG, String msg) {
        ZLogHelper.local(TAG, V, msg);
    }

    public static void d(String TAG, String msg) {
        ZLogHelper.local(TAG, D, msg);
    }

    public static void i(String TAG, String msg) {
        ZLogHelper.local(TAG, I, msg);
    }

    public static void w(String TAG, String msg) {
        ZLogHelper.local(TAG, W, msg);
    }

    public static void e(String TAG, String msg) {
        ZLogHelper.local(TAG, E, msg);
    }


}
