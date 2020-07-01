package com.stock.knowledge;

import android.app.Application;

import com.stock.knowledge.utils.AssetsDatabaseManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AssetsDatabaseManager.initManager(getApplicationContext());
    }
}
