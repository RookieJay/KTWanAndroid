package pers.jay.lib_global.http

import pers.jay.common.http.NetworkManager
import pers.jay.lib_global.common.Const
import pers.jay.lib_global.service.WanService

object WanHttpClient : NetworkManager() {

    override fun getBaseUrl(): String {
        return Const.WAN_URL
    }

    fun getWanService(): WanService {
        return getApiService(WanService :: class.java)
    }

}