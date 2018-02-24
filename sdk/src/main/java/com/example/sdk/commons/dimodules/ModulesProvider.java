package com.example.sdk.commons.dimodules;


import android.app.Application;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ApplicationModule;
import com.example.sdk.features.firstfeature.di.FirstFeatureModule;

public class ModulesProvider {

    public ApplicationModule createAppModule(Application application) {
        return new ApplicationModule(application);
    }

    public FirstFeatureModule createFirstFeatureModule(BaseActivity baseActivity) {
        return new FirstFeatureModule(baseActivity);
    }

}
