package com.example.customapp;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.di.FirstFeatureListQualifier;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.features.firstfeature.di.FirstFeatureModule;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;

import toothpick.Scope;


public class CustomMainModule extends FirstFeatureModule {

    private Scope scope;

    CustomMainModule(BaseActivity activity, Scope scope) {
        super(activity, scope);
        this.scope = scope;
    }

    @Override
    protected void bindListViewModel() {
        bind(FirstFeatureListViewModel.class).toProviderInstance(() ->
                new CustomMainViewModel(scope.getInstance(BaseActivity.class), scope.getInstance(FirstFeatureRepository.class)));
    }

    @Override
    protected void bindListViewBinder() {
        bind(ViewBinder.class).withName(FirstFeatureListQualifier.class).toProviderInstance(() ->
                new ViewBinder(R.layout.custom_activity_main, scope.getInstance(FirstFeatureListViewModel.class)));
    }
}
