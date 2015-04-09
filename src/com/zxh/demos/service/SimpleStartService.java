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

import com.zxh.demos.util.EvLog;
import com.zxh.demos.widget.ToastUtil;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * [功能说明]
 */
public class SimpleStartService extends Service {
    
    public static final int COMMAND_PLAY_FOOTBALL = 0;
    public static final int COMMAND_PLAY_BASKETBALL = 1;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate() {
        super.onCreate();
        EvLog.d("zxh", "SimpleStartService onCreate");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        
        EvLog.d("zxh", "SimpleStartService onStartCommand");
        
        int command = intent.getIntExtra("command", 0);
        
        switch (command) {
            case COMMAND_PLAY_FOOTBALL:
                ToastUtil.showToast(getApplicationContext(), "I'm playing football in SimpleStartService!");
                break;
            case COMMAND_PLAY_BASKETBALL:
                Toast.makeText(getApplicationContext(), "I'm playing basketball in SimpleStartService!", 0).show();
                break;
            default:
                break;
        }
        
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
