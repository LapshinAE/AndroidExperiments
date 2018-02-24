package com.example.sdk.commons.di;

import android.app.Application;
import android.content.Context;

import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepositoryImpl;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    public FirstFeatureRepository provideMainRepository() {
        return new FirstFeatureRepositoryImpl();
    }
}
