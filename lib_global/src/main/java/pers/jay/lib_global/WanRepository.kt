package pers.jay.lib_global

import pers.jay.lib_global.http.WanResponse

open class WanRepository {

    suspend fun <T : Any> wanApiCall(call: suspend () -> WanResponse<T>) : WanResponse<T> {
        return call.invoke()
    }

}