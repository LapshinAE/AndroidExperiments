package com.example.customapp;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.firstfeature.di.FirstFeatureModule;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;
import com.example.sdk.commons.sys.ViewBinder;


public class CustomMainModule extends FirstFeatureModule {
    public CustomMainModule(BaseActivity activity) {
        super(activity);
    }

    @Override
    public FirstFeatureListViewModel provideMainViewModel(FirstFeatureRepository mainRepository) {
        return new CustomMainViewModel(baseActivity, mainRepository);
    }

    @Override
    public ViewBinder provideMainViewBinder( FirstFeatureListViewModel mainViewModel) {
        return new ViewBinder(baseActivity, R.layout.custom_activity_main, mainViewModel);
    }
}
