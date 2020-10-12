package pers.jay.ktwanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_route.*
import pers.jay.common.utils.RouteUtils
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
        RouteUtils.nav(RouterPath.main)
    }

    private fun navToLogin() {
        RouteUtils.nav(RouterPath.login)
    }


}