package com.example.sdk.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.sdk.R;
import com.example.sdk.databinding.ActivityMainBinding;
import com.example.sdk.repositories.MainRepositoriesImpl;
import com.example.sdk.viewmodels.MainViewModel;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainViewModel vm = new MainViewModel(this, new MainRepositoriesImpl());
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(vm);
        registerViewModel(vm);
    }

}
