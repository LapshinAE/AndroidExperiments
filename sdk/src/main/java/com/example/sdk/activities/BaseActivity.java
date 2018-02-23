package com.example.sdk.activities;

import android.support.v7.app.AppCompatActivity;

import com.example.sdk.sys.BaseViewModel;

import java.util.HashSet;
import java.util.Set;


public class BaseActivity extends AppCompatActivity {

    private Set<BaseViewModel> viewModelSet = new HashSet<>();

    public void registerViewModel(BaseViewModel baseViewModel) {
        viewModelSet.add(baseViewModel);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        clearViewModels();
    }

    private void clearViewModels() {
        for (BaseViewModel viewModel : viewModelSet) {
            viewModel.clear();
        }
        viewModelSet.clear();
    }
}
