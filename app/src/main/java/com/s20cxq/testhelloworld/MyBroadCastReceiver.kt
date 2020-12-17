package com.s20cxq.testhelloworld

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 *  Created by li.liu  on 2020/12/17
 */
class MyBroadCastReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("hello_world","收到广播啦~~")
    }
}