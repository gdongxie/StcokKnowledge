package com.stock.knowledge;

import com.stock.knowledge.utils.AssetsDatabaseManager;
import com.supermax.base.QsApplication;
import com.supermax.base.common.http.HttpBuilder;

public class MyApplication extends QsApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AssetsDatabaseManager.initManager(getApplicationContext());
    }

    @Override
    public boolean isLogOpen() {
        return false;
    }

    @Override
    public void initHttpAdapter(HttpBuilder builder) throws Exception {

    }
}
