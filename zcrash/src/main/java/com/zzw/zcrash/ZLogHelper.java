package com.zzw.zcrash;

import android.app.Application;
import android.util.Log;

import com.zzw.zcrash.ZCrashHelper;
import com.zzw.zcrash.ZLog;
import com.zzw.zcrash.util.DateUtil;
import com.zzw.zcrash.util.FileUtil;
import com.zzw.zcrash.util.SystemUtil;
import com.zzw.zcrash.util.ThreadInfoUtil;

import java.io.IOException;

/**********************************************
 @author: created by 
 @date: 2019/9/19
 @email: zhengzhiwei333@gmail.com
 @describe: ZLogHelper
 **********************************************/
public class ZLogHelper {
    private static Application mApp;
    private static String TAGPath;

    public static void init(Application application) {
        mApp = application;
        TAGPath = ZCrashHelper.getCrashOption().getDirPath() + SystemUtil.getPackageName(mApp) + "/TAG/";
    }

    public static void local(String TAG, int level, String data) {
        try {
            if (FileUtil.mkdir(TAGPath)) {
                String filePath = TAGPath + TAG + ".txt";
                if (FileUtil.createFile(filePath)) {
                    saveContentToFilePath(filePath, level, data);
                }
            } else {
                Log.i("ZLog", "local: 文件夹创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void saveContentToFilePath(String filePath, int level, String data) {
        try {
            String saveDateStr = DateUtil.getNowLongDateStr();
            String headTopStr = "***************【Log】***************";
            String headEndStr = "*************************************";
            StringBuilder builder = new StringBuilder();
            builder.append(headTopStr).append("\n\tDATE:\t").append(saveDateStr).append("\n")
                    .append("\tLEVEL:\t").append(getLevelStr(level)).append("\n")
                    .append("\tCLASS:\t").append(ThreadInfoUtil.getClassName()).append("(行").append(ThreadInfoUtil.getLineNumber()).append(")").append("\n")
                    .append("\tMETHOD:\t").append(ThreadInfoUtil.getMethodName()).append("()\n")
                    .append(headEndStr).append("\n")
                    .append(data).append("\n").append(headEndStr);
            for (int i = 0; i < ZCrashHelper.getCrashOption().getPaintSpanCount(); i++) {
                builder.append("\n");
            }
            FileUtil.appendStrToFile(filePath, builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static String getLevelStr(int level) {
        switch (level) {
            case ZLog.V:
                return "VERVOSE";
            case ZLog.D:
                return "DEBUG";
            case ZLog.I:
                return "INFO";
            case ZLog.W:
                return "WARN";
            case ZLog.E:
                return "ERROR";
            default:
                return "";
        }
    }
}
