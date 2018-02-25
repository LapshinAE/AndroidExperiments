package com.example.customapp;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.activities.FirstFeatureListActivity;
import com.example.sdk.features.firstfeature.di.FirstFeatureModule;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;

import toothpick.Scope;


class CustomMainModule extends FirstFeatureModule {

    CustomMainModule(BaseActivity activity, Scope scope) {
        super(activity, scope);

        bind(FirstFeatureListViewModel.class).toProviderInstance(() ->
                new CustomMainViewModel(scope.getInstance(BaseActivity.class), scope.getInstance(FirstFeatureRepository.class)));
        bind(ViewBinder.class).withName(FirstFeatureListActivity.NAME).toProviderInstance(() ->
                new ViewBinder(R.layout.custom_activity_main, scope.getInstance(FirstFeatureListViewModel.class)));
    }
}
