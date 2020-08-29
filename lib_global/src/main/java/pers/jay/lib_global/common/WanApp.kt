package pers.jay.lib_global.common

import com.alibaba.android.arouter.launcher.ARouter
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pers.jay.common.app.BaseApplication
import pers.jay.lib_global.BuildConfig
import pers.jay.lib_global.di.appModule

open class WanApp : BaseApplication() {

    override fun lazyInit() {
        startKoin {
            androidContext(this@WanApp)
            modules(appModule)
        }
        if (BuildConfig.DEBUG) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }
}