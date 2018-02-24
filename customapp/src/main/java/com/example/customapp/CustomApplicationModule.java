package com.example.customapp;

import android.app.Application;

import com.example.sdk.commons.di.ApplicationModule;
import com.example.sdk.features.firstfeature.models.ItemDetail;
import com.example.sdk.features.firstfeature.models.ListItem;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepository;
import com.example.sdk.features.firstfeature.repositories.FirstFeatureRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;


public class CustomApplicationModule extends ApplicationModule {
    public CustomApplicationModule(Application application) {
        super(application);
    }

    @Override
    public FirstFeatureRepository provideMainRepository() {
        return new FirstFeatureRepositoryImpl() {
            @Override
            public Single<List<ListItem>> getItems() {
                return super.getItems()
                        .map(listItems -> {
                            List<ListItem> items = new ArrayList<>();
                            for (ListItem item : listItems) {
                                items.add(new ListItem(item.getId(), "Custom " + item.getName()));
                            }
                            return items;
                        });
            }

            @Override
            public Single<ItemDetail> getDetails(int id) {
                return super.getDetails(id).map(itemDetail ->
                        new ItemDetail(itemDetail.getId(),
                                "Custom " + itemDetail.getName(),
                                "Custom " + itemDetail.getDescription()));
            }
        };
    }


}
