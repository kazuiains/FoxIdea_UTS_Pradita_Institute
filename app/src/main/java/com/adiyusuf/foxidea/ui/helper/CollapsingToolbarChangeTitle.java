package com.adiyusuf.foxidea.ui.helper;

import android.app.Activity;
import android.content.Context;

import com.adiyusuf.foxidea.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollapsingToolbarChangeTitle {

    private Context conText;

    public CollapsingToolbarChangeTitle(Context conText) {
        this.conText = conText;
    }

    public void setTitle(final String title) {
        final CollapsingToolbarLayout coolToolbar = ((Activity) conText).findViewById(R.id.cooltoolbar);
        AppBarLayout appBarlayout = ((Activity) conText).findViewById(R.id.app_bar);

        appBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarlayout, int verticalValue) {
                coolToolbar.setTitle(title);
            }
        });
    }
}
