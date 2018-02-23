package com.example.sdk.activities;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sdk.R;
import com.example.sdk.databinding.ActivityDetailsBinding;
import com.example.sdk.repositories.MainRepositoriesImpl;
import com.example.sdk.viewmodels.DetailsViewModel;

public class DetailsActivity extends BaseActivity {

    private static final String DETAILS_ID = "details_id";

    public static Intent createDetailsActivityIntent(Context context, int detailsId) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(DETAILS_ID, detailsId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(DETAILS_ID)) {
            int detailsId = intent.getIntExtra(DETAILS_ID, 0);

            DetailsViewModel vm = new DetailsViewModel(this, new MainRepositoriesImpl());
            vm.init(detailsId);

            ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
            binding.setVm(vm);
            registerViewModel(vm);
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
