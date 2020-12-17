package com.s20cxq.testhelloworld

import android.app.IntentService
import android.content.Intent

/**
 *  Created by li.liu  on 2020/12/17
 */
class MyIntentService :IntentService("MyIntentService") { //这里name 可以随便传，只在调试时有用
    override fun onHandleIntent(intent: Intent?) {
        //这里可以处理耗时操作 不需要开启线程  执行完之后onDestroy()方法也会执行
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}