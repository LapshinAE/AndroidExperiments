package com.example.sdk.di;

import com.example.sdk.R;
import com.example.sdk.activities.BaseActivity;
import com.example.sdk.repositories.MainRepository;
import com.example.sdk.sys.ViewBinder;
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
    @MainListQualifier
    @Provides
    public ViewBinder provideMainViewBinder(BaseActivity baseActivity, MainViewModel mainViewModel) {
        return new ViewBinder(baseActivity, R.layout.activity_main, mainViewModel);
    }


    @PerActivity
    @Provides
    public DetailsViewModel provideDetailsViewModel(BaseActivity baseActivity, MainRepository mainRepository) {
        return new DetailsViewModel(baseActivity, mainRepository);
    }

    @PerActivity
    @DetailsQualifier
    @Provides
    public ViewBinder provideDetailsViewBinder(BaseActivity baseActivity, DetailsViewModel viewModel) {
        return new ViewBinder(baseActivity, R.layout.activity_details, viewModel);
    }
}
