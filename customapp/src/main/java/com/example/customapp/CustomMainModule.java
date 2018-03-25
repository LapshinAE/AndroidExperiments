package com.example.customapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.activities.FirstFeatureListActivity;
import com.example.sdk.features.firstfeature.di.FirstFeatureModule;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;

import javax.inject.Inject;

import toothpick.config.Binding;


class CustomMainModule extends FirstFeatureModule {

    public CustomMainModule(BaseActivity baseActivity) {
        super(baseActivity);

        rebind(FirstFeatureListViewModel.class).to(CustomMainViewModel.class);
        rebindWithName(ViewBinder.class, FirstFeatureListActivity.NAME).to(CustomListViewBinder.class);
    }

    public static class CustomListViewBinder extends ViewBinder {

        @Inject
        public CustomListViewBinder(FirstFeatureListViewModel viewModel) {
            super(R.layout.custom_activity_main, viewModel);
        }
    }

    protected <T> Binding<T> rebind(@NonNull Class<T> key) {
        return rebindWithName(key, null);
    }

    protected <T> Binding<T> rebindWithName(@NonNull Class<T> key, @Nullable String name) {
        Binding oldBinding = null;
        for(Binding binding : getBindingSet()) {
            if (binding.getKey().equals(key) &&
                    (name == null || binding.getName() != null && binding.getName().equals(name))) {
                oldBinding = binding;
            }
        }

        if (oldBinding != null) {
            getBindingSet().remove(oldBinding);
        }

        return bind(key).withName(name);
    }

}
