package com.zzw.zcrash;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.zzw.zcrash.bean.ZCrashOption;
import com.zzw.zcrash.util.CrashDetailInfoUtil;
import com.zzw.zcrash.util.DateUtil;
import com.zzw.zcrash.util.FileUtil;
import com.zzw.zcrash.util.SystemUtil;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: CrashHandler
 **********************************************/
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private final String TAG = getClass().getSimpleName();
    private static CrashHandler mInstance;
    private Application mApp;

    private CrashHandler() {
    }

    static CrashHandler getInstance() {
        if (mInstance == null) {
            synchronized (CrashHandler.class) {
                if (mInstance == null) {
                    mInstance = new CrashHandler();
                }
            }
        }
        return mInstance;
    }

    void init(Application app) {
        this.mApp = app;
        Thread.setDefaultUncaughtExceptionHandler(mInstance);//设置该CrashHandler为系统默认的
    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        collectCrashInfo(throwable);
        if (ZCrashHelper.getCrashOption().getCrashSolveType() == ZCrashOption.CrashSolveType.RESTARTAPP) {
            SystemUtil.restartApp(mApp, true);
        } else if (ZCrashHelper.getCrashOption().getCrashSolveType() == ZCrashOption.CrashSolveType.SHUTDOWNAPP) {
            SystemUtil.exitApp();
        } else if (ZCrashHelper.getCrashOption().getCrashSolveType() == ZCrashOption.CrashSolveType.USERDEFINED) {
            if (ZCrashHelper.getOnCrashListener() != null) {
                ZCrashHelper.getOnCrashListener().onCrash();
            }
        }
    }

    private void collectCrashInfo(Throwable ex) {
        if (ex == null) return;
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable throwable = ex.getCause();
        while (throwable != null) {
            throwable.printStackTrace(printWriter);
            throwable = throwable.getCause();//逐级获取错误信息
        }
        String crashInfo = CrashDetailInfoUtil.createCarshDetailInfo(writer.toString());
        Log.i(ZCrashHelper.getCrashOption().getLogTAG(), crashInfo);
        saveInfoToFile(crashInfo);
        printWriter.close();
    }

    private void saveInfoToFile(String crashInfo) {
        try {
            if (FileUtil.mkdir(ZCrashHelper.getCrashOption().getDirPath() + SystemUtil.getPackageName(mApp))) {
                String filePath = ZCrashHelper.getCrashOption().getDirPath()
                        + SystemUtil.getPackageName(mApp) +
                        "/crash_" + DateUtil.getNowShortDateStr() + ".txt";
                if (FileUtil.createFile(filePath)) {
                    FileUtil.appendStrToFile(filePath, crashInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
