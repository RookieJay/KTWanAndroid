package pers.jay.module_login

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.LogUtils
import org.koin.androidx.viewmodel.ext.android.getViewModel
import pers.jay.common.base.BaseVBActivity
import pers.jay.common.base.ext.showMessage
import pers.jay.common.utils.RouteUtils
import pers.jay.common.utils.SoftInputHelper
import pers.jay.lib_global.arouter.RouterPath
import pers.jay.lib_global.common.Const
import pers.jay.lib_global.model.bean.User
import pers.jay.module_login.databinding.LoginActivityLoginBinding

@Route(path = RouterPath.login)
class LoginActivity : BaseVBActivity<LoginActivityLoginBinding, LoginViewModel>() {

    private lateinit var progressBar: ProgressBar

    override fun initView(savedInstanceState: Bundle?) {
        progressBar = ProgressBar(mContext)
        progressBar.isIndeterminate = false
        val softInputHelper = SoftInputHelper.attach(this).moveBy(mBinding.root)
        mBinding.apply {
            softInputHelper.moveWith(btLogin, etAccount.editText, etPassword.editText)
            btLogin.setOnClickListener {
                val account = etAccount.text
                val password = etPassword.text
                showLoading()
                mViewModel.login(account, password)
            }
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        val intent = intent
        if (intent != null) {
            val msg = intent.getStringExtra(Const.KEY.NEED_LOGIN)
            val user = intent.getParcelableExtra<User>(Const.KEY.USER)
            mBinding.apply {
                etAccount.editText.setText(user?.nickname)
                etPassword.editText.setText(user?.id.toString())
            }
        }

        mViewModel.apply {
            mLiveData.observe(this@LoginActivity, Observer {
                mBinding.apply {
                    hideLoading()
                    showMessage("登录成功，%s", it.username)
                    RouteUtils.nav(RouterPath.main)
                }
            })
            mErrorData.observe(this@LoginActivity, Observer {
                hideLoading()
                Toast.makeText(mContext, it, Toast.LENGTH_SHORT).show()
            })
        }

    }

    override fun initViewModel(): ViewModel {
        return getViewModel()
    }

    override fun showLoading() {
        LogUtils.e("showProgressDialog")
        mProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        LogUtils.e("hideProgressDialog")
        mProgressBar.visibility = View.GONE
    }

}
