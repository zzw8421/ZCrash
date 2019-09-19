package com.zzw.zcrash.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: DateUtil
 **********************************************/
public class DateUtil {
    public static String getNowShortDateStr() {
        return new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault()).format(new Date());
    }

    public static String getNowLongDateStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }
}
