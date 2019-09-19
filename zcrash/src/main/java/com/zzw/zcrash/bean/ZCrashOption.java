package com.zzw.zcrash.bean;

/**********************************************
 @author: created by 
 @date: 2019/9/6
 @email: zhengzhiwei333@gmail.com
 @describe: ZCrashOption
 **********************************************/
public class ZCrashOption {
    private String dirPath;
    private boolean mIsPaintDetail;
    private int mPaintSpanCount;
    private String mLogTAG;
    private CrashSolveType mCrashSolveType;
    private boolean mShowTip;

    public enum CrashSolveType {
        SHUTDOWNAPP, RESTARTAPP, USERDEFINED;
    }

    public String getDirPath() {
        return dirPath;
    }

    public ZCrashOption setDirPath(String dirPath) {
        this.dirPath = dirPath;
        return this;
    }

    public boolean getIsPaintDetail() {
        return mIsPaintDetail;
    }

    public ZCrashOption setIsPaintDetail(boolean mIsPaintDetail) {
        this.mIsPaintDetail = mIsPaintDetail;
        return this;
    }

    public int getPaintSpanCount() {
        return mPaintSpanCount;
    }

    public ZCrashOption setPaintSpanCount(int mPaintSpanCount) {
        this.mPaintSpanCount = mPaintSpanCount;
        return this;
    }

    public String getLogTAG() {
        return mLogTAG;
    }

    public ZCrashOption setLogTAG(String logTAG) {
        mLogTAG = logTAG;
        return this;
    }

    public CrashSolveType getCrashSolveType() {
        return mCrashSolveType;
    }

    public ZCrashOption setCrashSolveType(CrashSolveType crashSolveType) {
        this.mCrashSolveType = crashSolveType;
        return this;
    }

    public boolean getIsShowTip() {
        return mShowTip;
    }

    public ZCrashOption setShowTip(boolean mShowTip) {
        this.mShowTip = mShowTip;
        return this;
    }
}
