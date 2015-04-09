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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * [功能说明]
 */
public class RomeoActivity extends Activity implements OnClickListener {
    
    private TextView mMoodTv;
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_romeo);
        
        mMoodTv = (TextView) findViewById(R.id.mood_tv);
        findViewById(R.id.ask).setOnClickListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ask:
                Intent intent = new Intent(this, JulietActivity.class);
                startActivityForResult(intent, 0);
                break;
    
            default:
                break;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean result = data.getBooleanExtra("answer", true);
        mMoodTv.setText(result ? "I'm so happy!~~~" : "I'm so sad.......");
    }

}
