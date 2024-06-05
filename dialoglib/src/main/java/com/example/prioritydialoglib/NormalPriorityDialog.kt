package com.example.prioritydialoglib

import android.content.Context

class NormalPriorityDialog(context: Context) : BasePriorityDialog(context) {
    override fun getLayoutId(): Int {
        return R.layout.dialog_normal_layout
    }

    override fun initView() {
    }


    override fun level(): PriorityDialogLevel {
       return PriorityDialogLevel.NORMAL
    }


}