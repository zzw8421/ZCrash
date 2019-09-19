package com.zzw.zcrash.util;

import android.util.Log;

/**********************************************
 @author: created by 
 @date: 2019/9/19
 @email: zhengzhiwei333@gmail.com
 @describe: ThreadInfoUtil
 **********************************************/
public class ThreadInfoUtil {
    private static final int ThreadCount = 6;

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[ThreadCount].getMethodName();
    }

    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[ThreadCount].getClassName();
    }

    public static int getLineNumber() {
        return Thread.currentThread().getStackTrace()[ThreadCount].getLineNumber();
    }

}
