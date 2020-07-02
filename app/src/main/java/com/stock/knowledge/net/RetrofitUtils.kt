package com.stock.knowledge.net

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Logger
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.UnsupportedEncodingException
import java.util.concurrent.TimeUnit

/**
 *
 * @ClassName:      RetrofitUtils
 * @Description:
 * @Author:         dongxie
 * @CreateDate:     2019/7/17 14:32
 */
object RetrofitUtils {

    @Volatile
    private var mRetrofit: Retrofit? = null

    init {
        initRetrofit()
    }

    private fun initRetrofit() {
        val interceptor = HttpLoggingInterceptor(Logger { message ->
            try {
                Log.e("HTTP", message)
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(10, TimeUnit.SECONDS)
        builder.writeTimeout(10, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(false)
        builder.addInterceptor(interceptor)
        val client = builder.build()
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl("http://web.juhe.cn:8080/")
        mRetrofit = retrofitBuilder
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
    }

    fun <T> getApiService(reqServer: Class<T>): T {
        return mRetrofit!!.create(reqServer)
    }

}