package pers.jay.common.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import pers.jay.common.lifecycle.ActivityLifecycleObserver

abstract class BaseActivity : AppCompatActivity(), IView {

    protected lateinit var mContext : Context

    protected val TAG = javaClass.simpleName

//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//        // 生命周期日志记录
//        lifecycle.addObserver(ActivityLifecycleObserver(TAG))
//        mContext = this
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 生命周期日志记录
        lifecycle.addObserver(ActivityLifecycleObserver(TAG))
        mContext = this
    }

}