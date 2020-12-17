package com.s20cxq.testhelloworld

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_basic_ui.*

class BasicUiActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_ui)

        text_view_tv.setOnClickListener(this)
        button_btn.setOnClickListener(this)
        image_view_et.setOnClickListener(this)
        alertDialog_btn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.text_view_tv -> Toast.makeText(this, "我是TextView", Toast.LENGTH_SHORT).show()
            R.id.button_btn -> progress_bar.progress = progress_bar.progress + 10
            R.id.image_view_et -> Toast.makeText(this, "我是ImageView", Toast.LENGTH_SHORT).show()
            R.id.alertDialog_btn -> showAlertDialog()
        }
    }


    private fun showAlertDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("This is Dialog")
            setMessage("something is here")
            setCancelable(false)
            setPositiveButton(
                "OK"
            ) { dialog, which ->
                Toast.makeText(this@BasicUiActivity, "OK", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton(
                "Cancel"
            ) { dialog, which ->
                Toast.makeText(this@BasicUiActivity, "Cancel", Toast.LENGTH_SHORT).show()
            }
            show()
        }
    }
}