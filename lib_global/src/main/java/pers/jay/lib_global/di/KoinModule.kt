package pers.jay.lib_global.di

import org.koin.dsl.module
import pers.jay.lib_global.http.WanHttpClient
import pers.jay.lib_global.service.WanService

val viewModelModule = module {
}

val httpModule = module {
    single { val wanService: WanService = WanHttpClient.getWanService() }
}

val appModule = listOf(viewModelModule, httpModule)