package pers.jay.common.base.ext

import com.blankj.utilcode.util.ToastUtils
import pers.jay.common.base.BaseFragment

/**
 * 一些扩展方法
 */
fun showMessage(message: String) = ToastUtils.showShort(message)

fun showMessage(format: String, args: Any?) = ToastUtils.showShort(format, args)

fun showLongMessage(message: String) = ToastUtils.showLong(message)


///**
// * 基于BaseFragment的扩展方法
// */
//fun BaseFragment.showMessage(message : String) = ToastUtils.showShort(message)
//
//fun BaseFragment.showMessage(format : String, args : Any?) = ToastUtils.showShort(format, args)
//
//fun BaseFragment.showError() = ToastUtils.showShort("错误")