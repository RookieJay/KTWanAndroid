package pers.jay.module_main

import android.os.Bundle
import android.os.Handler
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import pers.jay.common.base.BaseDBActivity
import pers.jay.common.utils.AssetUtils
import pers.jay.common.utils.CountDownUtils
import pers.jay.common.utils.JsonUtils
import pers.jay.lib_global.arouter.RouterPath
import pers.jay.lib_global.common.Const
import pers.jay.lib_global.model.bean.User
import pers.jay.module_main.databinding.MainActivityMainBinding

@Route(path = RouterPath.main)
class MainActivity : BaseDBActivity<MainActivityMainBinding>() {

    private fun mockNavWithParams() {
        val json = AssetUtils.getJson(this, "user.json")
        val user: User = JsonUtils.instance.getJson(json, User::class.java)
        mBinding.user = user
        Handler().postDelayed(Runnable {
            ARouter.getInstance()
                .build(RouterPath.login)
                .withString(Const.KEY.NEED_LOGIN, "来自主页的信息")
                .withParcelable(Const.KEY.USER, user)
                .navigation()
        }, 3000)
        val countDownUtils = CountDownUtils(3)
        countDownUtils.setListener {
            LogUtils.e("倒计时：$it")
            ToastUtils.showShort(it.toString())
        }
        countDownUtils.start()
    }

    override fun initLayout(savedInstanceState: Bundle?): Int {
        return R.layout.main_activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData(savedInstanceState: Bundle?) {
        mockNavWithParams()
    }

}