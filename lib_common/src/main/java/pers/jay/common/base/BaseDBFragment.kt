package pers.jay.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * 基于DataBinding的Fragment基类
 */
abstract class BaseDBFragment<DB : ViewDataBinding> : Fragment() {

    protected lateinit var mBinding : DB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutId = initLayout()
        if (layoutId == 0) {

        }
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        initView(savedInstanceState)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData(savedInstanceState)
    }

    protected abstract fun initLayout(): Int

    protected abstract fun initView(savedInstanceState: Bundle?)

    protected abstract fun initData(savedInstanceState: Bundle?)

}