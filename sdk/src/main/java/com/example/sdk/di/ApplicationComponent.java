package com.example.sdk.di;

import com.example.sdk.repositories.MainRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    MainRepository getMainRepository();
}
