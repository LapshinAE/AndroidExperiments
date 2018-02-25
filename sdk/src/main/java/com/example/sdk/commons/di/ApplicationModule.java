package com.example.sdk.commons.di;


import android.app.Application;

import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepositoryImpl;

import toothpick.config.Module;

public class ApplicationModule extends Module {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;

        bindFirstFeatureRepository();
    }

    protected void bindFirstFeatureRepository() {
        bind(FirstFeatureRepository.class).to(FirstFeatureRepositoryImpl.class).singletonInScope();
    }
}
