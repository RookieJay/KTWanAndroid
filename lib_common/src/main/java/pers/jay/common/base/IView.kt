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

    fun showProgressDialog() {}

    fun hideProgressDialog() {}

}