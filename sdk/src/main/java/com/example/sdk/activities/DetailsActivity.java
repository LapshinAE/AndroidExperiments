package com.example.sdk.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sdk.MyApplication;
import com.example.sdk.di.DaggerMainComponent;
import com.example.sdk.di.DetailsQualifier;
import com.example.sdk.sys.ViewBinder;
import com.example.sdk.viewmodels.DetailsViewModel;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity {

    private static final String DETAILS_ID = "details_id";

    public static Intent createDetailsActivityIntent(Context context, int detailsId) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(DETAILS_ID, detailsId);
        return intent;
    }

    @Inject
    @DetailsQualifier
    ViewBinder viewBinder;

    @Inject
    DetailsViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DaggerMainComponent.builder()
                .applicationComponent(MyApplication.getApp(this).getApplicationComponent())
                .mainModule(MyApplication.getApp(this).getModulesProvider().createMainModule(this))
                .build()
                .inject(this);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(DETAILS_ID)) {
            int detailsId = intent.getIntExtra(DETAILS_ID, 0);

            vm.init(detailsId);

            viewBinder.setContentView();
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
