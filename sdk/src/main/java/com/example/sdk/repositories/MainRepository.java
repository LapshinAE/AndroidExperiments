package com.example.sdk.repositories;


import com.example.sdk.models.ItemDetail;
import com.example.sdk.models.ListItem;

import java.util.List;

import io.reactivex.Single;

public interface MainRepository {
    Single<List<ListItem>> getItems();
    Single<ItemDetail> getDetails(int id);
}
