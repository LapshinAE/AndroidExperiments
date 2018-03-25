package com.example.sdk.commons.di;

import com.example.sdk.commons.activities.BaseActivity;

import toothpick.config.Module;


public class ActivityModule extends Module {

    public ActivityModule(BaseActivity baseActivity) {
        bind(BaseActivity.class).toInstance(baseActivity);
    }

}
