package com.stock.knowledge.net

import com.stock.knowledge.base.HkStockBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("finance/stock/hkall?key=ec3d425c24ff99d81b84a3b4ec4bcc0c")
    fun getHkStocks(@Query("page") page: Int): Flowable<HkStockBean>

    @GET("finance/stock/usaall?key=ec3d425c24ff99d81b84a3b4ec4bcc0c")
    fun getUsStocks(@Query("page") page: Int): Flowable<HkStockBean>
}