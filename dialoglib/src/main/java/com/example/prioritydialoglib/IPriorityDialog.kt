package com.example.prioritydialoglib

import android.app.Dialog
import android.content.Context

/**
 * 优先级弹窗接口
 */
abstract class IPriorityDialog(context: Context): Dialog(context) {
    // 定义弹窗的等级
    abstract fun level(): PriorityDialogLevel

}