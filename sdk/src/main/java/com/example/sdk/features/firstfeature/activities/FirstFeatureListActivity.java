package com.example.sdk.features.firstfeature.activities;

import android.os.Bundle;

import com.example.sdk.commons.MyApplication;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.firstfeature.di.DaggerFirstFeatureComponent;
import com.example.sdk.features.firstfeature.di.FirstFeatureListQualifier;
import com.example.sdk.commons.sys.ViewBinder;

import javax.inject.Inject;

public class FirstFeatureListActivity extends BaseActivity {

    @Inject
    @FirstFeatureListQualifier
    ViewBinder viewBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerFirstFeatureComponent.builder()
                .applicationComponent(MyApplication.getApp(this).getApplicationComponent())
                .firstFeatureModule(MyApplication.getApp(this).getModulesProvider().createFirstFeatureModule(this))
                .build()
                .inject(this);

        viewBinder.setContentView();
        registerViewModel(viewBinder.getBaseViewModel());
    }

}
