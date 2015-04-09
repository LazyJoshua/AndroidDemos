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

package com.zxh.demos.service;

import com.zxh.demos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * [功能说明]
 */
public class StartServiceActivity extends Activity implements OnClickListener {
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        
        findViewById(R.id.start_service).setOnClickListener(this);
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(this, SimpleStartService.class);
        intent.putExtra("command", SimpleStartService.COMMAND_PLAY_FOOTBALL);
        startService(intent);
    }

}
