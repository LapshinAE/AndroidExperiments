package com.example.customapp;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.activities.FirstFeatureListActivity;
import com.example.sdk.features.firstfeature.di.FirstFeatureModule;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureDetailsViewModel;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;

import javax.inject.Inject;

import toothpick.Scope;


class CustomMainModule extends FirstFeatureModule {

    CustomMainModule(BaseActivity activity) {
        super(activity);
    }

    /*@Override
    protected void bindList() {
        bind(FirstFeatureListViewModel.class).to(CustomMainViewModel.class);
        bind(ViewBinder.class).withName(FirstFeatureListActivity.NAME).to(CustomListViewBinder.class);
    }

    public static class CustomListViewBinder extends ViewBinder {

        @Inject
        public CustomListViewBinder(FirstFeatureListViewModel vm) {
            super(R.layout.custom_activity_main, vm);
        }
    }*/
}
