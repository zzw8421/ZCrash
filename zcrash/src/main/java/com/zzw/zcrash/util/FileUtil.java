package com.zzw.zcrash.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: FileUtil
 **********************************************/
public class FileUtil {
    public static boolean mkdir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            return dir.mkdirs();
        } else {
            return true;
        }
    }

    public static boolean createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return file.createNewFile();
        } else {
            return true;
        }
    }

    public static File getFileForPath(String path) {
        return new File(path);
    }

    public static void writeStrToFilePath(String filePath, String writerInfo) throws IOException {
        FileWriter writer = new FileWriter(filePath);//如果保存失败，很可能是没有写SD卡权限
        writer.write(writerInfo);
        writer.close();
    }

    public static void writeStrToFile(File file, String writerInfo) throws IOException {
        FileWriter writer = new FileWriter(file);//如果保存失败，很可能是没有写SD卡权限
        writer.write(writerInfo);
        writer.close();
    }

    public static void appendStrToFile(File file, String writerInfo) throws IOException {
        FileWriter writer = new FileWriter(file, true);//如果保存失败，很可能是没有写SD卡权限
        PrintWriter pw = new PrintWriter(writer);
        pw.println(writerInfo);
        pw.flush();
        writer.flush();
        pw.close();
        writer.close();
    }

    public static void appendStrToFile(String filePath, String writerInfo) throws IOException {
        FileWriter writer = new FileWriter(filePath, true);//如果保存失败，很可能是没有写SD卡权限
        PrintWriter pw = new PrintWriter(writer);
        pw.println(writerInfo);
        pw.flush();
        writer.flush();
        pw.close();
        writer.close();
    }


}
