package com.example.sdk.di;

import android.app.Application;
import android.content.Context;

import com.example.sdk.repositories.MainRepositoriesImpl;
import com.example.sdk.repositories.MainRepository;

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
    public MainRepository provideMainRepository() {
        return new MainRepositoriesImpl();
    }
}
