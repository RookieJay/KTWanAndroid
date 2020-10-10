package pers.jay.lib_global.mvvm

import pers.jay.common.base.BaseModel
import pers.jay.lib_global.http.WanHttpClient
import pers.jay.lib_global.http.WanResponse

/**
 * @Auther: juncai.zhou
 * @Date: 2020/10/10 13:35
 * @Description:Wanandroid Model层基类
 */
open class WanModel : BaseModel() {

    val wanService by lazy {
        WanHttpClient.getWanService()
    }

    suspend fun <T : Any> wanApiCall(call: suspend () -> WanResponse<T>) : WanResponse<T> {
        return call.invoke()
    }

}