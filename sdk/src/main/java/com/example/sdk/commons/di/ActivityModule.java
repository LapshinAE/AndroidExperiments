package com.example.sdk.commons.di;

import com.example.sdk.commons.activities.BaseActivity;

public class ActivityModule {

    protected BaseActivity baseActivity;

    public ActivityModule(BaseActivity activity) {
        baseActivity = activity;
    }
}