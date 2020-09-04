package pers.jay.common.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * 基于ViewBinding的基类Activity，利用反射获取特定ViewBinding中的inflate方法填充视图
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseVBActivity<VB : ViewBinding, VM : ViewModel> : BaseActivity() {

    //  这里使用了委托，表示只有使用到instance才会执行该段代码
    protected val instance by lazy { this }

    protected lateinit var mBinding: VB

    protected lateinit var mViewModel: VM

    protected lateinit var mProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        initViewModelByReflect()
//        initViewModelBySelf()
        initRootView()
        initView(savedInstanceState)
        initData(savedInstanceState)
        mProgressBar = ProgressBar(mContext)
        mProgressBar.isIndeterminate = false
    }

    /**
     *  反射，获取特定ViewModel泛型的class
     */
    private fun initViewModelByReflect() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val clazz = type.actualTypeArguments[1] as Class<VM>
            mViewModel = ViewModelProvider(this).get(clazz)
        }
    }

    /**
     *  由自身通过koin等其他方式自行返回ViewModel
     */
    private fun initViewModelBySelf() {
        initViewModel()
    }

    /**
     *  反射，调用特定ViewBinding中的inflate方法填充视图
     */
    private fun initRootView() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val clazz = type.actualTypeArguments[0] as Class<VB>
            val method = clazz.getMethod("inflate", LayoutInflater::class.java)
            mBinding = method.invoke(null, layoutInflater) as VB
            setContentView(mBinding.root)
        }
    }

    abstract fun initViewModel() : ViewModel


}