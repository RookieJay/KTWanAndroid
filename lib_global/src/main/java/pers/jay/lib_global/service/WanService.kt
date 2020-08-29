package pers.jay.lib_global.service

import pers.jay.lib_global.http.WanResponse
import pers.jay.lib_global.model.bean.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WanService {

    /**
     * 登录
     * @param  username 账号 password 密码
     * @return
     */
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): WanResponse<User>
}