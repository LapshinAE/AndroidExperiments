package com.example.sdk.sys;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;


public class BaseViewModel extends BaseObservable {

    @BindingAdapter("app:onClick")
    public static void bindOnClick(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runnable.run();
            }
        });
    }

}
