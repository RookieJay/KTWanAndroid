package pers.jay.common.base

import android.os.Bundle

interface IView {

    /**
     * 初始化各种View
     */
    fun initView(savedInstanceState: Bundle?)

    /**
     * 初始化布局数据
     */
    fun initData(savedInstanceState: Bundle?)

    /**
     * 展示加载
     */
    fun showLoading() {}

    /**
     * 隐藏加载
     */
    fun hideLoading() {}

}