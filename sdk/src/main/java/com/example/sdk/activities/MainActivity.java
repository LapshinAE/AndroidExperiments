package com.example.sdk.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.sdk.MyApplication;
import com.example.sdk.R;
import com.example.sdk.databinding.ActivityMainBinding;
import com.example.sdk.di.DaggerMainComponent;
import com.example.sdk.viewmodels.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .applicationComponent(MyApplication.getApp(this).getApplicationComponent())
                .mainModule(MyApplication.getApp(this).getModulesProvider().createMainModule(this))
                .build()
                .inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(vm);
        registerViewModel(vm);
    }

}
