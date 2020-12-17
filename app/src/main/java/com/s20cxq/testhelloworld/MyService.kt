package com.s20cxq.testhelloworld

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

/**
 *  Created by li.liu  on 2020/12/17
 */
class MyService :Service() {
    val TAG = "hello_world"
    private val downloadBind = DownloadBind()

    override fun onBind(intent: Intent?): IBinder? {
        return downloadBind
    }

    class DownloadBind:Binder(){
        fun startDownLoad(){
            Log.i("hello_world","startDownLoad()")
        }
        fun getProgress():Int{
            Log.i("hello_world","getProgress()")
            return 0
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"onCreate()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG,"onStartCommand()")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy()")
    }
}