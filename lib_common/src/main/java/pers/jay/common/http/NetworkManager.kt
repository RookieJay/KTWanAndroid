package pers.jay.common.http

import android.text.TextUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.RuntimeException
import java.util.*
import java.util.concurrent.TimeUnit

abstract class NetworkManager {

    lateinit var mOkHttpClient: OkHttpClient
    lateinit var mRetrofit: Retrofit
    lateinit var mBaseUrl: String


    companion object {
        const val READ_WRITE_TIME_OUT = 5000L
        const val CONNECT_TIME_OUT = 3000L
    }

    fun createOkhttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        mOkHttpClient = builder.readTimeout(READ_WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                                .writeTimeout(READ_WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                                .addNetworkInterceptor(HttpLoggingInterceptor())
                                .build()
        return mOkHttpClient
    }

    fun getRetrofit(): Retrofit {
        if (TextUtils.isEmpty(mBaseUrl)) {
            throw RuntimeException("baseUrl method must be called first")
        }
        mRetrofit = Retrofit.Builder()
                            .baseUrl(mBaseUrl)
                            .addConverterFactory(GsonConverterFactory.create()) //使用Gson
                            .addConverterFactory(ScalarsConverterFactory.create()) //接收非json字符串build()
                            .client(mOkHttpClient)
                            .build()
        return mRetrofit
    }

    fun <T> getApiService(tClass: Class<T>): T {
        Objects.requireNonNull(tClass, "api service class can not be null")
        return mRetrofit.create(tClass)
    }

    abstract fun baseUrl(baseUrl : String)

}