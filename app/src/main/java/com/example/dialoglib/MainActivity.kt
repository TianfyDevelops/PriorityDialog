package com.example.dialoglib

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prioritydialoglib.ErrorPriorityDialog
import com.example.prioritydialoglib.NormalPriorityDialog
import com.example.prioritydialoglib.WarningPriorityDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val normalPriorityDialog = NormalPriorityDialog(this)
        val warningPriorityDialog = WarningPriorityDialog(this)
        val errorPriorityDialog = ErrorPriorityDialog(this)

        findViewById<Button>(R.id.btn_showDialog).setOnClickListener {
            normalPriorityDialog.showPriorityDialog()
            warningPriorityDialog.showPriorityDialog()
            normalPriorityDialog.showPriorityDialog()
            errorPriorityDialog.showPriorityDialog()
            normalPriorityDialog.setMessage("正常")
            warningPriorityDialog.setMessage("警告")
            errorPriorityDialog.setMessage("错误")
        }
    }
}