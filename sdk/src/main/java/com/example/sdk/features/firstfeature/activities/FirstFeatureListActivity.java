package com.example.sdk.features.firstfeature.activities;

import android.os.Bundle;

import com.example.sdk.commons.MyApplication;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.di.FirstFeatureListQualifier;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public class FirstFeatureListActivity extends BaseActivity {

    @Inject
    @FirstFeatureListQualifier
    ViewBinder viewBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Scope scope = Toothpick.openScopes(MyApplication.getApp(this), this);
        scope.installModules(MyApplication.getApp(this).getModulesProvider().createFirstFeatureModule(this, scope));
        Toothpick.inject(this, scope);
        Toothpick.closeScope(this);

        viewBinder.setContentView(this);
        registerViewModel(viewBinder.getBaseViewModel());
    }
}
