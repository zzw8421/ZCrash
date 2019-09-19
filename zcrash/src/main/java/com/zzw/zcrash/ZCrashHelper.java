package com.zzw.zcrash;

import android.app.Application;
import android.os.Environment;

import com.zzw.zcrash.bean.ZCrashOption;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: ZCrashHelper  该类主要用于初始化
 **********************************************/
public class ZCrashHelper {
    private static ZCrashOption mCrashOption;
    private static ZCrashHelper mInstance;
    private static OnCrashListener mOnCrashListener;

    private ZCrashHelper() {
    }

    public static void create(Application app) {
        if (app != null) {
            CrashHandler.getInstance().init(app);
        }
    }

    public static void create(Application app, ZCrashOption crashOption) {
        if (app != null) {
            mCrashOption = crashOption;
            CrashHandler.getInstance().init(app);
        }
    }

    public static void setCarshOption(ZCrashOption zCrashOption) {
        mCrashOption = zCrashOption;
    }


    public static ZCrashOption getCrashOption() {
        if (mCrashOption != null) {
            return mCrashOption;
        } else {
            return defaultCrashOption();
        }
    }

    private static ZCrashOption defaultCrashOption() {
        mCrashOption = new ZCrashOption();
        mCrashOption.setDirPath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/crashLog/")
                .setIsPaintDetail(true).setPaintSpanCount(4)
                .setLogTAG("ZCrashTAG")
                .setCrashSolveType(ZCrashOption.CrashSolveType.RESTARTAPP);
        return mCrashOption;
    }

    public static void setOnCrashListener(OnCrashListener listener) {
        mOnCrashListener = listener;
    }

    public static OnCrashListener getOnCrashListener() {
        return mOnCrashListener;
    }
}
