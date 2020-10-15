package com.stock.answer.net

import com.stock.answer.beans.AppconfigBean
import com.stock.answer.beans.HkStockBean
import com.stock.answer.beans.UsaStockBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("vzMr1bgG.mock/appconfig")
    fun getData(): Flowable<AppconfigBean>
}