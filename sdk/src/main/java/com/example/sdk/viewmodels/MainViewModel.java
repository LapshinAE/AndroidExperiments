package com.example.sdk.viewmodels;

import com.example.sdk.R;
import com.example.sdk.Screens;
import com.example.sdk.activities.BaseActivity;
import com.example.sdk.models.ListItem;
import com.example.sdk.repositories.MainRepository;
import com.example.sdk.sys.BaseViewModel;
import com.example.sdk.sys.DataBindingRenderer;
import com.example.sdk.sys.ListConfig;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class MainViewModel extends BaseViewModel {

    private MainRepository mainRepository;

    private RendererRecyclerViewAdapter rendererRecyclerViewAdapter;
    private ListConfig listConfig;

    public MainViewModel(BaseActivity baseActivity, MainRepository repository) {
        super(baseActivity);
        setLoading(true);

        this.mainRepository = repository;

        rendererRecyclerViewAdapter = new RendererRecyclerViewAdapter();
        rendererRecyclerViewAdapter.registerRenderer(
                new DataBindingRenderer<>(ListItem.class, getContext(), R.layout.layout_list_item,
                        item -> Screens.showDetails(getContext(), item.getId())));

        listConfig = new ListConfig.Builder(rendererRecyclerViewAdapter)
                .setHasFixedSize(true)
                .build(baseActivity);

        regiserDisposables(
                mainRepository.getItems()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((listItems, throwable) -> {
                        rendererRecyclerViewAdapter.setItems(listItems);
                        setLoading(false);
                    })
        );
    }

    public ListConfig getListConfig() {
        return listConfig;
    }

}
