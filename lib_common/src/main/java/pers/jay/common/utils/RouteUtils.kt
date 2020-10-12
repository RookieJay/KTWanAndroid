package pers.jay.common.utils

import android.os.Parcelable
import android.text.TextUtils
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Auther: juncai.zhou
 * @Date: 2020/10/12 10:48
 * @Description:
 */
object RouteUtils {

    fun nav(path: String) {
        if (TextUtils.isEmpty(path)) {
            throw IllegalArgumentException("path can not be empty")
        }
        ARouter.getInstance().build(path).navigation()
    }

    fun navWithString(path: String, key: String, value: String) {
        ARouter.getInstance()
            .build(path)
            .withString(key, value)
            .navigation()
    }

}