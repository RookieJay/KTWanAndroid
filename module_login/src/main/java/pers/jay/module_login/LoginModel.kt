package pers.jay.module_login

import pers.jay.lib_global.http.WanResponse
import pers.jay.lib_global.model.bean.User
import pers.jay.lib_global.mvvm.WanModel

/**
 * @Auther: juncai.zhou
 * @Date: 2020/10/10 13:30
 * @Description:
 */
class LoginModel : WanModel() {

    suspend fun login(account: String, password: String): WanResponse<User> {
        return wanService.login(account, password)
    }

}