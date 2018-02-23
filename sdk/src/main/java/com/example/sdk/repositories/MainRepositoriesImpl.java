package com.example.sdk.repositories;

import com.example.sdk.models.ItemDetail;
import com.example.sdk.models.ListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;


public class MainRepositoriesImpl implements MainRepository {

    private List<ListItem> items;
    private Map<Integer, ItemDetail> details;

    public MainRepositoriesImpl() {
        items = new ArrayList<>();
        details = new HashMap<>();
        for (int i=0; i<100; i++) {
            ListItem listItem = new ListItem(i, "Item number " + String.valueOf(i));
            items.add(listItem);
            details.put(i, new ItemDetail(listItem,  "Details for item " +  String.valueOf(i)));
        }
    }

    @Override
    public Single<List<ListItem>> getItems() {
        return Single.just(items).delay(1, TimeUnit.SECONDS);
    }

    @Override
    public Single<ItemDetail> getDetails(int id) {
        return Single.just(details.get(id)).delay(1, TimeUnit.SECONDS);
    }
}
