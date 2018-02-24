package com.example.sdk.commons.sys;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;

import com.example.sdk.BR;
import com.example.sdk.commons.activities.BaseActivity;

public class ViewBinder {

    private BaseActivity baseActivity;
    private @LayoutRes int resId;
    private BaseViewModel baseViewModel;

    public ViewBinder(BaseActivity baseActivity, int resId, BaseViewModel baseViewModel) {
        this.baseActivity = baseActivity;
        this.resId = resId;
        this.baseViewModel = baseViewModel;
    }

    public void setContentView() {
        ViewDataBinding dataBinding = DataBindingUtil.setContentView(baseActivity, resId);
        dataBinding.setVariable(BR.vm, baseViewModel);
    }

    public BaseViewModel getBaseViewModel() {
        return baseViewModel;
    }
}
