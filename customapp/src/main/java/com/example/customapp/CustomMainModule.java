package com.example.customapp;

import com.example.sdk.activities.BaseActivity;
import com.example.sdk.di.MainModule;
import com.example.sdk.repositories.MainRepository;
import com.example.sdk.sys.ViewBinder;
import com.example.sdk.viewmodels.MainViewModel;


public class CustomMainModule extends MainModule {
    public CustomMainModule(BaseActivity activity) {
        super(activity);
    }

    @Override
    public MainViewModel provideMainViewModel(BaseActivity baseActivity, MainRepository mainRepository) {
        return new CustomMainViewModel(baseActivity, mainRepository);
    }

    @Override
    public ViewBinder provideMainViewBinder(BaseActivity baseActivity, MainViewModel mainViewModel) {
        return new ViewBinder(baseActivity, R.layout.custom_activity_main, mainViewModel);
    }
}
