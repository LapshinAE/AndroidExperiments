package com.example.sdk.features.firstfeature.di;

import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ActivityModule;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureDetailsViewModel;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;


public class FirstFeatureModule extends ActivityModule {



    public FirstFeatureModule(BaseActivity baseActivity, toothpick.Scope scope) {
        super(baseActivity, scope);

        bindListViewModel();
        bindListViewBinder();
        bindDetailsViewModel();
        bindDetailsViewBinder();
    }

    protected void bindListViewModel() {
        bind(FirstFeatureListViewModel.class).singletonInScope();
    }

    protected void bindListViewBinder() {
        bind(ViewBinder.class).withName(FirstFeatureListQualifier.class).toProviderInstance(() ->
                new ViewBinder(R.layout.activity_main, getScope().getInstance(FirstFeatureListViewModel.class)));
    }

    protected void bindDetailsViewModel() {
        bind(FirstFeatureDetailsViewModel.class).singletonInScope();
    }

    protected void bindDetailsViewBinder() {
        bind(ViewBinder.class).withName(FirstFeatureDetailsQualifier.class).toProviderInstance(() ->
                new ViewBinder(R.layout.activity_details, getScope().getInstance(FirstFeatureDetailsViewModel.class)));
    }

}
