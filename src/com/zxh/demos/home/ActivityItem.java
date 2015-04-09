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

package com.zxh.demos.home;

import android.app.Activity;

/**
 * [功能说明]
 */
public class ActivityItem {
    
    public String name;
    
    public Class<? extends Activity> aClass;
    
    public ActivityItem() {
    }
    
    public ActivityItem(String name, Class<? extends Activity> aClass) {
        this.name = name;
        this.aClass = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends Activity> getaClass() {
        return aClass;
    }

    public void setaClass(Class<? extends Activity> aClass) {
        this.aClass = aClass;
    } 

}
