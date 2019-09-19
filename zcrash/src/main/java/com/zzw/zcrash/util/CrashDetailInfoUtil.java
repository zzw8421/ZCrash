package com.zzw.zcrash.util;

import com.zzw.zcrash.ZCrashHelper;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: CrashDetailInfoUtil
 **********************************************/
public class CrashDetailInfoUtil {
    public static final String CRASH_START = "\n*****************【错误信息】*****************";
    public static final String CRASH_END = "*****************【END】*****************";
    //发生时间  机型    //SIM卡号

    public static String createCarshDetailInfo(String carshInfo) {
        StringBuilder mStrBuilder = new StringBuilder();
        mStrBuilder.append(CRASH_START);
        mStrBuilder.append("\n");
        mStrBuilder.append("***\t DATE=\t").append(DateUtil.getNowLongDateStr()).append("\n");
        mStrBuilder.append("**********************************\n");
        mStrBuilder.append(carshInfo);
        mStrBuilder.append(CRASH_END);
        for (int i = 0; i < ZCrashHelper.getCrashOption().getPaintSpanCount(); i++) {
            mStrBuilder.append("\n");
        }
        return mStrBuilder.toString();
    }


}
