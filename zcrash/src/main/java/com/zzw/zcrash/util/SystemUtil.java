package com.zzw.zcrash.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: SystemUtil
 **********************************************/
public class SystemUtil {
    public static String getPackageName(Context context) {
        try {
            //包名
            String pkName = context.getPackageName();
            return pkName;
        } catch (Exception e) {
            return "";
        }
    }

    public static void restartApp(Application app, boolean isKillProcess) {
        PackageManager packageManager = app.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(app.getPackageName());
        if (intent == null) return;
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        app.startActivity(intent);
        if (!isKillProcess) return;
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
   }

    public static void exitApp() {
        System.exit(0);
    }
}
