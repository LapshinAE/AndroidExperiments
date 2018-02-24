package com.example.sdk.features.firstfeature.di;

import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ActivityModule;
import com.example.sdk.commons.di.PerActivity;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureDetailsViewModel;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.commons.sys.ViewBinder;

import dagger.Module;
import dagger.Provides;

@Module
public class FirstFeatureModule extends ActivityModule {

    public FirstFeatureModule(BaseActivity activity) {
        super(activity);
    }

    @PerActivity
    @Provides
    public FirstFeatureListViewModel provideMainViewModel(FirstFeatureRepository mainRepository) {
        return new FirstFeatureListViewModel(baseActivity, mainRepository);
    }

    @PerActivity
    @FirstFeatureListQualifier
    @Provides
    public ViewBinder provideMainViewBinder(FirstFeatureListViewModel mainViewModel) {
        return new ViewBinder(R.layout.activity_main, mainViewModel);
    }


    @PerActivity
    @Provides
    public FirstFeatureDetailsViewModel provideDetailsViewModel(FirstFeatureRepository mainRepository) {
        return new FirstFeatureDetailsViewModel(baseActivity, mainRepository);
    }

    @PerActivity
    @DetailsQualifier
    @Provides
    public ViewBinder provideDetailsViewBinder(FirstFeatureDetailsViewModel viewModel) {
        return new ViewBinder(R.layout.activity_details, viewModel);
    }
}
