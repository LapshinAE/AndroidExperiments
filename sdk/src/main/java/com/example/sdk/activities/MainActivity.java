package com.example.sdk.activities;

import android.os.Bundle;

import com.example.sdk.MyApplication;
import com.example.sdk.di.DaggerMainComponent;
import com.example.sdk.di.MainListQualifier;
import com.example.sdk.sys.ViewBinder;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    @MainListQualifier
    ViewBinder viewBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .applicationComponent(MyApplication.getApp(this).getApplicationComponent())
                .mainModule(MyApplication.getApp(this).getModulesProvider().createMainModule(this))
                .build()
                .inject(this);

        viewBinder.setContentView();
        registerViewModel(viewBinder.getBaseViewModel());
    }

}
