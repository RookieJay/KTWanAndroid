package pers.jay.module_login

import android.util.Log
import com.blankj.utilcode.util.LogUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pers.jay.common.app.BaseApplication
import pers.jay.common.base.BaseViewModel
import pers.jay.common.utils.AssetUtils
import pers.jay.common.utils.JsonUtils
import pers.jay.lib_global.common.Const
import pers.jay.lib_global.http.WanHttpClient
import pers.jay.lib_global.model.bean.User

/**
 *类实现了KoinComponent,在该类中,我们就可以通过by inject和get来过去被注入过的对象了.
 */
class LoginViewModel : BaseViewModel<User>() {

    val wanService = WanHttpClient.getWanService()

    /**
     * 模拟数据
     */
    fun mockUserInfo() {
        val json = AssetUtils.getJson(BaseApplication.instance(), "user.json")
        Log.d("user.json", json.toString())
        val user: User? = JsonUtils.instance.getJson(json, User::class.java)
        if (user == null) {
            mErrorData.postValue("user为空")
            return
        }
        Log.d("hahah", user.toString())
        mLiveData.postValue(user)
    }

    fun login(account: String, password: String) {
        LogUtils.e("login")
        GlobalScope.launch {
            val response = wanService.login(account, password)
            val user = response.data
            if (response.errorCode == Const.HTTP_CODE_SUCCESS) {
                mLiveData.postValue(user)
            } else {
                mErrorData.postValue(response.errorMsg)
            }

        }
    }

}