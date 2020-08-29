package pers.jay.ktwanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_route.*
import pers.jay.lib_global.arouter.RouterPath

class RouteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)
        button1.setOnClickListener{
            navToMain()
        }
        button2.setOnClickListener {
            navToLogin()
        }
    }

    private fun navToMain() {
        ARouter.getInstance().build(RouterPath.main).navigation()
    }

    private fun navToLogin() {
        ARouter.getInstance().build(RouterPath.login).navigation()
    }
}