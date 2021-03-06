package pers.jay.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * 基于ViewBinding的Fragment基类
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseVBFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var mBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<*>
        val method = aClass.getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        mBinding = method.invoke(null, layoutInflater, container, false) as VB
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    protected abstract fun initView(savedInstanceState: Bundle?)

    protected abstract fun initData(savedInstanceState: Bundle?)
}