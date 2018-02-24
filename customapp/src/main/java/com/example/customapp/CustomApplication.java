package com.example.customapp;

import android.app.Application;

import com.example.sdk.commons.MyApplication;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ApplicationModule;
import com.example.sdk.features.firstfeature.di.FirstFeatureModule;
import com.example.sdk.commons.dimodules.ModulesProvider;


public class CustomApplication extends MyApplication {

    @Override
    protected ModulesProvider buildModulesProvider() {
        return new ModulesProvider() {

            @Override
            public ApplicationModule createAppModule(Application application) {
                return new CustomApplicationModule(application);
            }

            @Override
            public FirstFeatureModule createFirstFeatureModule(BaseActivity baseActivity) {
                return new CustomMainModule(baseActivity);
            }
        };
    }
}
