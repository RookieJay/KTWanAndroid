package pers.jay.common.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import pers.jay.common.http.NetworkManager

/**
 * 静态内部类式单例kotlin实现
 * class SingletonDemo private constructor() {
        companion object {
        val instance = SingletonHolder.holder
        }
        private object SingletonHolder {
        val holder= SingletonDemo()
        }
    }
 */
abstract class BaseApplication: Application(), Application.ActivityLifecycleCallbacks {

    companion object {
        private lateinit var instance : BaseApplication
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        LogUtils.d("onCreate-" + this.javaClass.simpleName)
        lazyInit()
    }

    abstract fun lazyInit()


    override fun onActivityPaused(activity: Activity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityStarted(activity: Activity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityDestroyed(activity: Activity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityStopped(activity: Activity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResumed(activity: Activity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}