package com.example.sdk;

import android.app.Application;
import android.content.Context;

import com.example.sdk.di.ApplicationComponent;
import com.example.sdk.di.ApplicationModule;
import com.example.sdk.di.DaggerApplicationComponent;


public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static MyApplication getApp(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
