package pers.jay.common.base.ext

import com.blankj.utilcode.util.ToastUtils
import pers.jay.common.base.BaseActivity
import pers.jay.common.base.BaseFragment

/**
 * 基于BaseActivity的扩展方法
 */
fun BaseActivity.showMessage(message : String) = ToastUtils.showShort(message)

fun BaseActivity.showMessage(format : String, args : Any?) = ToastUtils.showShort(format, args)

fun BaseActivity.showError() = ToastUtils.showShort("错误")


/**
 * 基于BaseFragment的扩展方法
 */
fun BaseFragment.showMessage(message : String) = ToastUtils.showShort(message)

fun BaseFragment.showMessage(format : String, args : Any?) = ToastUtils.showShort(format, args)

fun BaseFragment.showError() = ToastUtils.showShort("错误")