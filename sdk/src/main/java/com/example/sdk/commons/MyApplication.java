package com.example.sdk.commons;

import android.app.Application;
import android.content.Context;

import com.example.sdk.commons.di.ApplicationComponent;
import com.example.sdk.commons.di.DaggerApplicationComponent;
import com.example.sdk.commons.dimodules.ModulesProvider;


public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    private ModulesProvider modulesProvider;

    @Override
    public void onCreate() {
        super.onCreate();

        modulesProvider = buildModulesProvider();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(modulesProvider.createAppModule(this))
                .build();
    }

    public static MyApplication getApp(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    protected ModulesProvider buildModulesProvider() {
        return new ModulesProvider();
    }

    public ModulesProvider getModulesProvider() {
        return modulesProvider;
    }
}
