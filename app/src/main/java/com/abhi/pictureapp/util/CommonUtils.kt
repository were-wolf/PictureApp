package com.abhi.pictureapp.util

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.abhi.pictureapp.R

fun Context.setProgressDialog(): Dialog {
    var dialog: Dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.layout_progress)
    val window: Window? = dialog.window
    window!!.setLayout(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
    )
    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return dialog
}

fun Context.showErrorToast(msg: String): Toast {

    val inflater = (this as Activity).layoutInflater
    val layout: View =
        inflater.inflate(
            R.layout.layout_error_toast,
            this.findViewById(R.id.layoutToast)
        )
    val msgTv = layout.findViewById<View>(R.id.tvMessage) as TextView
    msgTv.text = msg
    val toast = Toast(this)
    toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, -0, 230)
    toast.duration = Toast.LENGTH_SHORT
    msgTv.gravity = Gravity.CENTER
    toast.view = layout
    toast.show()
    return toast
}

fun Context.showSuccessToast(msg: String): Toast {

    val inflater = (this as Activity).layoutInflater
    val layout: View =
        inflater.inflate(
            R.layout.layout_success_toast,
            this.findViewById(R.id.layoutToast)
        )
    val msgTv = layout.findViewById<View>(R.id.tvMessage) as TextView
    msgTv.text = msg
    val toast = Toast(this)
    toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, -0, 230)
    toast.duration = Toast.LENGTH_SHORT
    msgTv.gravity = Gravity.CENTER
    toast.view = layout
    toast.show()
    return toast
}