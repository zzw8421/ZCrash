package com.zzw.mycarchtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zzw.zcrash.ZLogHelper;
import com.zzw.zcrash.ZLog;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private TextView tvBtnCrash;
    private TextView tvLogV;
    private TextView tvLogD;
    private TextView tvLogI;
    private TextView tvLogW;
    private TextView tvLogE;
    private Timer timer;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView() {
        tvBtnCrash = findViewById(R.id.main_tv_btncrash);
        tvLogV = findViewById(R.id.main_tv_logv);
        tvLogD = findViewById(R.id.main_tv_logd);
        tvLogI = findViewById(R.id.main_tv_logi);
        tvLogW = findViewById(R.id.main_tv_logw);
        tvLogE = findViewById(R.id.main_tv_loge);
    }

    public void setListener() {
        tvBtnCrash.setOnClickListener(v -> {
            timer.cancel();
        });
        tvLogV.setOnClickListener(view -> {
            TestUtil.printVLog();
        });
        tvLogD.setOnClickListener(view -> {
            ZLog.d(TAG, "这是一条DEBUG日志");
        });
        tvLogI.setOnClickListener(view -> {
            ZLog.i(TAG, "这是一条INFO日志");
        });
        tvLogW.setOnClickListener(view -> {
            ZLog.w(TAG, "这是一条WARN日志");
        });
        tvLogE.setOnClickListener(view -> {
            printLogEInfo();
        });
    }

    private void logV() {
        printLogVInfo();
    }

    private void printLogVInfo() {
        printLogV();
    }

    private void printLogV() {
        printV();
    }

    private void printV() {
        ZLog.v(TAG, "这是一条VERVOSE日志");
    }

    private void printLogEInfo() {
        ZLog.e(TAG, "这是一条ERROR日志");
    }
}
