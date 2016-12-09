package com.example.lzy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;

import com.example.lzy.myapplication.R;
import com.example.lzy.weiget.LoadingView;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private LoadingView mLoadingView;
    private AppCompatSeekBar mSbExternalR, mSbInternalR, mSbRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadingView = (LoadingView) this.findViewById(R.id.loading_view);
        mSbExternalR = (AppCompatSeekBar) this.findViewById(R.id.sb_external_r);
        mSbInternalR = (AppCompatSeekBar) this.findViewById(R.id.sb_internal_r);
        mSbRate = (AppCompatSeekBar) this.findViewById(R.id.sb_rate);
        mSbExternalR.setOnSeekBarChangeListener(this);
        mSbInternalR.setOnSeekBarChangeListener(this);
        mSbRate.setOnSeekBarChangeListener(this);

        mLoadingView.start();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        if (seekBar == mSbExternalR) {
            mLoadingView.setExternalRadius(progress);
        } else if (seekBar == mSbInternalR) {
            mLoadingView.setInternalRadius(progress);
        } else if (seekBar == mSbRate) {
            mLoadingView.setDuration(progress);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoadingView.stop();
    }
}
