package com.example.sdk.features.firstfeature.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sdk.commons.MyApplication;
import com.example.sdk.commons.activities.BaseActivity;
import com.example.sdk.features.firstfeature.di.DaggerFirstFeatureComponent;
import com.example.sdk.features.firstfeature.di.DetailsQualifier;
import com.example.sdk.features.firstfeature.viewmodels.FirstFeatureDetailsViewModel;
import com.example.sdk.commons.sys.ViewBinder;

import javax.inject.Inject;

public class FirstFeatureDetailsActivity extends BaseActivity {

    private static final String DETAILS_ID = "details_id";

    public static Intent createDetailsActivityIntent(Context context, int detailsId) {
        Intent intent = new Intent(context, FirstFeatureDetailsActivity.class);
        intent.putExtra(DETAILS_ID, detailsId);
        return intent;
    }

    @Inject
    @DetailsQualifier
    ViewBinder viewBinder;

    @Inject
    FirstFeatureDetailsViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DaggerFirstFeatureComponent.builder()
                .applicationComponent(MyApplication.getApp(this).getApplicationComponent())
                .firstFeatureModule(MyApplication.getApp(this).getModulesProvider().createFirstFeatureModule(this))
                .build()
                .inject(this);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(DETAILS_ID)) {
            int detailsId = intent.getIntExtra(DETAILS_ID, 0);

            vm.init(detailsId);

            viewBinder.setContentView(this);
            registerViewModel(viewBinder.getBaseViewModel());
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
