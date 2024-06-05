package com.example.prioritydialoglib

import android.content.Context

class WarningPriorityDialog(context: Context) : BasePriorityDialog(context) {


    override fun getLayoutId(): Int {
        return R.layout.dialog_warning_layout
    }

    override fun initView() {
    }


    override fun level(): PriorityDialogLevel {
       return PriorityDialogLevel.WARNING
    }
}