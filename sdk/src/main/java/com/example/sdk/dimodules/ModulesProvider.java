package com.example.sdk.dimodules;


import android.app.Application;

import com.example.sdk.activities.BaseActivity;
import com.example.sdk.di.ApplicationModule;
import com.example.sdk.di.MainModule;

public class ModulesProvider {

    public ApplicationModule createAppModule(Application application) {
        return new ApplicationModule(application);
    }

    public MainModule createMainModule(BaseActivity baseActivity) {
        return new MainModule(baseActivity);
    }

}
