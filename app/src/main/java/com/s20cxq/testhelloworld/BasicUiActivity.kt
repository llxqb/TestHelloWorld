package com.s20cxq.testhelloworld

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_basic_ui.*

class BasicUiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_ui)

        button_btn.setOnClickListener {
            progress_bar.progress = progress_bar.progress + 10
        }

        alertDialog_btn.setOnClickListener {
            showAlertDialog()
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