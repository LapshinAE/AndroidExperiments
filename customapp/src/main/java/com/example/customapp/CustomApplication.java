package com.example.customapp;

import android.app.Application;

import com.example.sdk.MyApplication;
import com.example.sdk.di.ApplicationModule;
import com.example.sdk.dimodules.ModulesProvider;


public class CustomApplication extends MyApplication {

    @Override
    protected ModulesProvider buildModulesProvider() {
        return new ModulesProvider() {

            @Override
            public ApplicationModule createAppModule(Application application) {
                return new CustomApplicationModule(application);
            }
        };
    }
}
