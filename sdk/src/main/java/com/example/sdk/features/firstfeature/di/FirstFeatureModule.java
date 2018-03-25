package com.example.sdk.features.firstfeature.di;

import com.example.sdk.R;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.commons.di.ActivityModule;
import com.example.sdk.commons.sys.ViewBinder;
import com.example.sdk.features.firstfeature.activities.FirstFeatureDetailsActivity;
import com.example.sdk.features.firstfeature.activities.FirstFeatureListActivity;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureDetailsViewModel;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureListViewModel;

import javax.inject.Inject;


public class FirstFeatureModule extends ActivityModule {

    public FirstFeatureModule(BaseActivity baseActivity) {
        super(baseActivity);

        bindList();

        bind(FirstFeatureDetailsViewModel.class).singletonInScope();
        bind(ViewBinder.class).withName(FirstFeatureDetailsActivity.NAME).to(DetailsViewBinder.class);
    }

    protected void bindList() {
        bind(FirstFeatureListViewModel.class).singletonInScope();
        bind(ViewBinder.class).withName(FirstFeatureListActivity.NAME).to(ListViewBinder.class);
    }

    public static class ListViewBinder extends ViewBinder {

        @Inject
        public ListViewBinder(FirstFeatureListViewModel vm) {
            super(R.layout.activity_main, vm);
        }
    }

    public static class DetailsViewBinder extends ViewBinder {

        @Inject
        public DetailsViewBinder(FirstFeatureDetailsViewModel vm) {
            super(R.layout.activity_details, vm);
        }
    }


}
