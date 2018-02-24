package com.example.sdk.features.firstfeature.di;

import com.example.sdk.commons.di.ApplicationComponent;
import com.example.sdk.commons.di.PerActivity;
import com.example.sdk.features.firstfeature.activities.FirstFeatureDetailsActivity;
import com.example.sdk.features.firstfeature.activities.FirstFeatureListActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {FirstFeatureModule.class})
public interface FirstFeatureComponent {
    void inject(FirstFeatureListActivity activity);
    void inject(FirstFeatureDetailsActivity activity);
}
