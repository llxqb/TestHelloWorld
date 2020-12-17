package com.s20cxq.testhelloworld

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_center.*

class UserCenterActivity : AppCompatActivity() {
    val TAG = "hello_world"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_center)
        Log.i(TAG, "UserCenterActivity  执行了 onCreate()")

        save_user_btn.setOnClickListener {
            saveUserData()
        }
        query_user_btn.setOnClickListener {
            getUserData()
        }
    }

    private fun saveUserData(){
        val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
        editor.putString("name",username_et.text.toString())
        editor.putInt("pwd",password_et.text.toString().toInt())
        editor.apply()
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show()
    }

    private fun getUserData(){
        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val username = prefs.getString("name","")
        val pwd = prefs.getInt("pwd",0)
        Log.i(TAG,"username=$username  pwd=$pwd")
    }


    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "UserCenterActivity  执行了 onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "UserCenterActivity  执行了 onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "UserCenterActivity  执行了 onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "UserCenterActivity  执行了 onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "UserCenterActivity  执行了 onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "UserCenterActivity  执行了 onDestroy()")
    }
}