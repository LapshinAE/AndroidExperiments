package com.example.sdk.viewmodels;

import android.databinding.ObservableField;

import com.example.sdk.activities.BaseActivity;
import com.example.sdk.models.ItemDetail;
import com.example.sdk.repositories.MainRepository;
import com.example.sdk.sys.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class DetailsViewModel extends BaseViewModel {

    private MainRepository mainRepository;

    private ObservableField<ItemDetail> details = new ObservableField<>();

    public DetailsViewModel(BaseActivity baseActivity, MainRepository repository) {
        super(baseActivity);
        this.mainRepository = repository;
    }

    public void init(int id) {
        setLoading(true);
        regiserDisposables(
                mainRepository.getDetails(id)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((itemDetail, throwable) -> {
                            setLoading(false);
                            details.set(itemDetail);
                        })
        );

    }

    public ObservableField<ItemDetail> getDetails() {
        return details;
    }
}
