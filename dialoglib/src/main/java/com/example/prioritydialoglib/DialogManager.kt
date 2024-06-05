package com.example.prioritydialoglib

import java.util.PriorityQueue

/**
 * 单例模式，管理所有弹出的dialog
 */
internal class DialogManager private constructor() {

    companion object {
        val Instance by lazy {
            DialogManager()
        }
    }

    // 优先级队列，队列中存放的是所有弹出的dialog，优先级高的在队列的最前面
    private val priorityQueue = PriorityQueue(PriorityComparator())

    /**
     * 按优先级显示dialog
     * @param showDialog 待显示的dialog
     */
    fun show(showDialog: IPriorityDialog) {
        // 判断待显示的dialog是否已经添加到队列中,如果已经添加到队列中，则不重复添加
        if (priorityQueue.contains(showDialog)) {
            return
        }
        // 将要弹出的dialog添加到优先级队列中
        priorityQueue.offer(showDialog)
        // 取出队列中优先级最高的dialog
        val dialog = priorityQueue.peek()
        // 显示优先级最高的dialog
        if (dialog?.isShowing == false) {
            dialog.show()
        }
    }

    /**
     * 按优先级隐藏dialog
     * 1.将待隐藏的dialog从队列中移除
     * 2.显示队列中优先级最高的dialog
     * @param dismissDialog 待隐藏的dialog
     */
    fun dismiss(dismissDialog: IPriorityDialog) {
        // 判断待隐藏的dialog是否已经添加到队列中
        if (priorityQueue.contains(dismissDialog)) {
            priorityQueue.remove(dismissDialog)
        }
        // 显示优先级最高的dialog
        val nextDialog = priorityQueue.peek()
        if (nextDialog?.isShowing == false) {
            nextDialog.show()
        }
    }
}

internal class PriorityComparator : Comparator<IPriorityDialog> {
    override fun compare(o1: IPriorityDialog, o2: IPriorityDialog): Int {
        return o2.level().ordinal.compareTo(o1.level().ordinal)
    }
}



