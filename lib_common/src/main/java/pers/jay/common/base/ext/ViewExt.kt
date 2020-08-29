package pers.jay.common.base.ext

import com.blankj.utilcode.util.ToastUtils
import pers.jay.common.base.BaseActivity

fun BaseActivity.showMessage(message : String) = ToastUtils.showShort(message)

fun BaseActivity.showMessage(format : String, args : Any?) = ToastUtils.showShort(format, args)


fun BaseActivity.showError() = ToastUtils.showShort("错误")