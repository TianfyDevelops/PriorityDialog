package com.example.prioritydialoglib

import android.content.Context

class ErrorPriorityDialog(context: Context) : BasePriorityDialog(context) {
    override fun getLayoutId(): Int {
        return R.layout.dialog_error_layout
    }

    override fun initView() {
    }


    override fun level(): PriorityDialogLevel {
       return PriorityDialogLevel.ERROR
    }

}