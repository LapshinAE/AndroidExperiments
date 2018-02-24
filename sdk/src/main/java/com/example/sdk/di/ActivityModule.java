package com.example.sdk.di;

import android.app.Activity;
import android.content.Context;

import com.example.sdk.activities.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
class ActivityModule {

    protected BaseActivity baseActivity;

    public ActivityModule(BaseActivity activity) {
        baseActivity = activity;
    }

    @Provides
    @ActivityContext
    @PerActivity
    Context provideContext() {
        return baseActivity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return baseActivity;
    }

    @Provides
    @PerActivity
    BaseActivity provideBaseActivity() {
        return baseActivity;
    }
}