package pers.jay.lib_global.http

import pers.jay.common.http.NetworkManager
import pers.jay.lib_global.common.Const
import pers.jay.lib_global.service.WanService

object WanHttpClient : NetworkManager() {

    init {
        baseUrl(Const.WAN_URL)
        createOkhttpClient()
        getRetrofit()
    }

    override fun baseUrl(baseUrl: String) {
        this.mBaseUrl = baseUrl
    }

    fun getWanService(): WanService {
        return mRetrofit.create(WanService :: class.java)
    }

}