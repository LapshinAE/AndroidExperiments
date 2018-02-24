package com.example.sdk.commons.di;

import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    FirstFeatureRepository getMainRepository();
}
