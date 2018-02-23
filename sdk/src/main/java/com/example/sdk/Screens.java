package com.example.sdk;


import android.content.Context;

import com.example.sdk.activities.DetailsActivity;

public class Screens {

    public static void showDetails(Context context, int detailsId) {
        context.startActivity(DetailsActivity.createDetailsActivityIntent(context, detailsId));
    }

}
