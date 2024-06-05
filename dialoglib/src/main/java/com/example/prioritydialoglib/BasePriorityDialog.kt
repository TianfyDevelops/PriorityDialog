package com.example.prioritydialoglib

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.widget.TextView

/**
 * 优先级弹窗的基类
 */
abstract class BasePriorityDialog(context: Context) : IPriorityDialog(context) {

    private var tvMessage: TextView? = null

    private var onDismissListener: DialogInterface.OnDismissListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        val dialogWindow = window
        dialogWindow!!.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT)
        dialogWindow.setGravity(Gravity.CENTER)
        val lp = dialogWindow.attributes
        lp.width = dp2px(context,600)
        lp.height = dp2px(context,500)
        dialogWindow.setAttributes(lp)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        dialogWindow.setBackgroundDrawableResource(android.R.color.transparent) //设置背景透明

        setOnDismissListener {
            DialogManager.Instance.dismiss(this)
            onDismissListener?.onDismiss(this)
        }

        tvMessage = findViewById(R.id.tv_msg)

        initView()
    }
    private fun dp2px(context: Context, i: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (i * scale + 0.5f).toInt()
    }
    fun setOnPriorityDialogDismissListener(listener: DialogInterface.OnDismissListener) {
        onDismissListener = listener
    }

    /**
     * 按优先级显示dialog
     */
    fun showPriorityDialog() {
        DialogManager.Instance.show(this)
    }


    fun setMessage(message: String) {
        tvMessage?.text = message
    }

    fun getMessage(): String? {
        return tvMessage?.text.toString()
    }

    override fun show() {
        super.show()
        Log.d("BaseDialog", "${this.javaClass.simpleName}--show")
    }

    override fun dismiss() {
        super.dismiss()
        Log.d("BaseDialog", "${this.javaClass.simpleName}--dismiss")
    }


    abstract fun getLayoutId(): Int

    abstract fun initView()

}