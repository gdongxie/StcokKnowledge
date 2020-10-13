package com.stock.answer.net

import com.stock.answer.beans.AppconfigBean
import com.stock.answer.beans.HkStockBean
import com.stock.answer.beans.UsaStockBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /**
     *  http://web.juhe.cn:8080/finance/stock/hkall?key=ec3d425c24ff99d81b84a3b4ec4bcc0c
     *  获取港股数据列表
     */
    @GET("finance/stock/hkall?key=ec3d425c24ff99d81b84a3b4ec4bcc0c")
    fun getHkStocks(@Query("page") page: Int): Flowable<HkStockBean>

    /**
     * http://web.juhe.cn:8080/finance/stock/usaall?key=ec3d425c24ff99d81b84a3b4ec4bcc0c
     * 获取美股数据列表
     */
    @GET("finance/stock/usaall?key=ec3d425c24ff99d81b84a3b4ec4bcc0c")
    fun getUsStocks(@Query("page") page: Int): Flowable<UsaStockBean>

    @GET("vzMr1bgG.mock/appconfig")
    fun getData(): Flowable<AppconfigBean>
}