package com.example.sdk.di;

import com.example.sdk.activities.BaseActivity;
import com.example.sdk.repositories.MainRepository;
import com.example.sdk.viewmodels.DetailsViewModel;
import com.example.sdk.viewmodels.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule extends ActivityModule {

    public MainModule(BaseActivity activity) {
        super(activity);
    }

    @PerActivity
    @Provides
    public MainViewModel provideMainViewModel(BaseActivity baseActivity, MainRepository mainRepository) {
        return new MainViewModel(baseActivity, mainRepository);
    }

    @PerActivity
    @Provides
    public DetailsViewModel provideDetailsViewModel(BaseActivity baseActivity, MainRepository mainRepository) {
        return new DetailsViewModel(baseActivity, mainRepository);
    }
}
