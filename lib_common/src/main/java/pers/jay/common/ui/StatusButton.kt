package pers.jay.common.ui

import android.content.Context
import android.view.accessibility.AccessibilityEvent
import androidx.appcompat.widget.AppCompatButton


class StatusButton(context: Context?) : AppCompatButton(context) {

    /**
     * 可访问性事件的来源是其状态改变触发触发事件的视图。
     */
    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        event?.let {
            event.isPassword = true
        }
    }

}