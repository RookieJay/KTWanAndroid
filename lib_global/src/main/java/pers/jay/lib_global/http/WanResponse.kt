package pers.jay.lib_global.http

data class WanResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)