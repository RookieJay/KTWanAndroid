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

/**
 * 网络管理类
 */
abstract class NetworkManager {

    lateinit var mOkHttpClient: OkHttpClient
    lateinit var mRetrofit: Retrofit

    companion object {
        const val READ_WRITE_TIME_OUT = 5000L
        const val CONNECT_TIME_OUT = 3000L
    }

    init {
        createOkhttpClient()
        getRetrofit()
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
        val baseUrl = getBaseUrl()
        if (TextUtils.isEmpty(baseUrl)) {
            throw RuntimeException("baseUrl can not be empty")
        }
        mRetrofit = Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create()) // use Gson
                            .addConverterFactory(ScalarsConverterFactory.create()) // to receive none-json response
                            .client(mOkHttpClient)
                            .build()
        return mRetrofit
    }

    fun <T> getApiService(tClass: Class<T>): T {
        Objects.requireNonNull(tClass, "api service class can not be null")
        return mRetrofit.create(tClass)
    }

    abstract fun getBaseUrl() : String

}