package com.stock.knowledge.net

import com.stock.knowledge.base.FinanceBean
import com.stock.knowledge.base.HkStockBean
import com.stock.knowledge.base.UsaStockBean
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

    /**
     * http://v.juhe.cn/toutiao/index?type=caijing&key=c10a52bbc484e6fbfc571cc40082a9ee
     * 获取财经新闻列表
     */
    @GET("toutiao/index?type=caijing&key=c10a52bbc484e6fbfc571cc40082a9ee")
    fun getFinance(): Flowable<FinanceBean>
}