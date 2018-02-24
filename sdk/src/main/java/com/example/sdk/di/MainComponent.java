package com.example.sdk.di;

import com.example.sdk.activities.DetailsActivity;
import com.example.sdk.activities.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
    void inject(DetailsActivity activity);
}
