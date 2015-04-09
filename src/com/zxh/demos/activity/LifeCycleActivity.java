/*
 * Copyright (C) 2014-2016  福建星网视易信息系统有限公司
 * All rights reserved by  福建星网视易信息系统有限公司
 *
 *  Modification History:
 *  Date        Author      Version     Description
 *  -----------------------------------------------
 *  2015-4-1     "zhouxinghua"     1.0         [修订说明]
 *
 */

package com.zxh.demos.activity;

import com.zxh.demos.R;
import com.zxh.demos.util.EvLog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * [功能说明]
 */
public class LifeCycleActivity extends Activity implements OnClickListener {
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        EvLog.d("zxh", "LifeCycleActivity onCreate");
        
        setContentView(R.layout.activity_life_cycle);
        
        findViewById(R.id.start_activity_explicitly).setOnClickListener(this);
        findViewById(R.id.start_activity_implicity).setOnClickListener(this);
        findViewById(R.id.start_full_screen_ac).setOnClickListener(this);
        findViewById(R.id.start_dialog_style_ac).setOnClickListener(this);
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onStart() {
        super.onStart();
        EvLog.d("zxh", "LifeCycleActivity onStart");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onResume() {
        super.onResume();
        EvLog.d("zxh", "LifeCycleActivity onResume");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPause() {
        super.onPause();
        EvLog.d("zxh", "LifeCycleActivity onPause");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onStop() {
        super.onStop();
        EvLog.d("zxh", "LifeCycleActivity onStop");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        EvLog.d("zxh", "LifeCycleActivity onRestart");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EvLog.d("zxh", "LifeCycleActivity onDestroy");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        EvLog.d("zxh", "LifeCycleActivity onSaveInstanceState");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EvLog.d("zxh", "LifeCycleActivity onRestoreInstanceState");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_activity_explicitly:
                gotoAc(ElephantActivity.class);
                break;
            case R.id.start_activity_implicity:
                startActivityImplicity();
                break;
            case R.id.start_full_screen_ac:
                gotoAc(ElephantActivity.class);
                break;
            case R.id.start_dialog_style_ac:
                gotoAc(MonkeyActivity.class);
                break;
    
            default:
                break;
        }
    }
    
    private void startActivityImplicity() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "把这首歌推向全宇宙！！！~~~~");
        startActivity(intent);
    }
    
    private void gotoAc(Class<? extends Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
