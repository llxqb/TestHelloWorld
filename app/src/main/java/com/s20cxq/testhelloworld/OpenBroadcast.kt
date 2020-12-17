package com.s20cxq.testhelloworld

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 *  Created by li.liu  on 2020/12/16
 */
class OpenBroadcast :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"收到了系统启动广播", Toast.LENGTH_SHORT).show()
//        val intent = Intent(context,MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        context.startActivity(intent)
    }
}