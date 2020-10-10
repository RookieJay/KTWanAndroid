package pers.jay.common.lifecycle

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.blankj.utilcode.util.LogUtils

/**
 * @Auther: juncai.zhou
 * @Date: 2020/9/30 14:37
 * @Description: 生命周期日志记录器
 */
class ActivityLifecycleObserver(tag: String) : DefaultLifecycleObserver {

    private val TAG = tag

    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.iTag(TAG, "onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        LogUtils.iTag(TAG, "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        LogUtils.iTag(TAG, "onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        LogUtils.iTag(TAG, "onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        LogUtils.iTag(TAG, "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        LogUtils.iTag(TAG, "onDestroy")
    }
}