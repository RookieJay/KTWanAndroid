package pers.jay.common.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.InflateException

/**
 * 基于DataBinding的基类Activity
 */
abstract class BaseDBActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        try {
            val layoutResId = initLayout(savedInstanceState)
            if (layoutResId != 0) {
                setContentView(layoutResId)
            }
        } catch (e: Exception) {
            if (e is InflateException) throw e
            e.printStackTrace()
        }
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    /**
     * 初始化布局layoutId,如果 {@link #initView(Bundle)} 返回 0, 框架则不会调用 {@link Activity#setContentView(int)}
     */
    abstract fun initLayout(savedInstanceState: Bundle?) : Int


}