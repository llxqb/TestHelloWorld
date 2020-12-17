package com.s20cxq.testhelloworld

import android.content.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var myBroadCastReceiver: MyBroadCastReceiver
    var num = 1
    val TAG = "hello_world"
    private  var mDownloadBind = MyService.DownloadBind()
    private val connection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mDownloadBind = service as MyService.DownloadBind
            mDownloadBind.startDownLoad()
            mDownloadBind.getProgress()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click_me_btn.setOnClickListener {
//            num_tv.text = (++num).toString()

//            显示启动
            val intent = Intent(this, UserCenterActivity::class.java)
            startActivity(intent)

            //隐示启动
//            val intent = Intent()
//            intent.action = "com.s20cxq.UserCenterActivity"
//            startActivity(intent)

//            val intent = Intent()
//            intent.action = Intent.ACTION_VIEW
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)
//            val intent = Intent()
//            intent.action = Intent.ACTION_DIAL
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)
        }

        start_service_btn.setOnClickListener(this)
        stop_service_btn.setOnClickListener(this)
        start_broadcast_btn.setOnClickListener(this)
        base_ui_btn.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.start_service_btn -> {
                startService()
            }
            R.id.stop_service_btn -> {
                stopService()
            }
            R.id.start_broadcast_btn -> {
                startBroadcast()
            }
            R.id.base_ui_btn->{
                val intent  = Intent(this,BasicUiActivity::class.java)
                startActivity(intent)
            }
        }
    }


    private fun startService() {
        val intent = Intent(this, MyService::class.java)
//        startService(intent)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    private fun stopService() {
        val intent = Intent(this, MyService::class.java)
//        stopService(intent)
        unbindService(connection)
    }

    private fun startBroadcast(){
        //动态注册方式
//        myBroadCastReceiver = MyBroadCastReceiver()
//        val intentFilter = IntentFilter()
//        intentFilter.addAction("android.intent.action.TIME_TICK")
//        registerReceiver(myBroadCastReceiver,intentFilter)

        //自定义发送广播
        val intent  = Intent()
        intent.action ="com.s20cxq.MyBroadCastReceiver"
        //android 8.0，静态注册的BroadcastReceiver是无法接收隐示广播的  调用setPackage()方法，指定这条广播对应哪个应用程序，从而变成显示广播
        intent.setPackage(packageName)
        sendBroadcast(intent)
    }


    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "MainActivity  执行了 onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "MainActivity  执行了 onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "MainActivity  执行了 onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "MainActivity  执行了 onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "MainActivity  执行了 onStop()")
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadCastReceiver)
    }
}