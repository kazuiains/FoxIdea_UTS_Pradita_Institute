package com.adiyusuf.foxidea.ui.helper;

import android.app.Activity;
import android.content.Context;

import com.adiyusuf.foxidea.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollapsingToolbarDetail {
    private Context conText;

    public CollapsingToolbarDetail(Context conText) {
        this.conText = conText;
    }

    public void setTitle(final String title) {

        final CollapsingToolbarLayout coolToolbar = ((Activity)conText).findViewById(R.id.cooltoolbar_detail);
        coolToolbar.setTitle(" ");
        AppBarLayout appBarlayout = ((Activity)conText).findViewById(R.id.app_bar_detail);
        appBarlayout.setExpanded(true);

        appBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarlayout, int verticalValue) {
                if (scrollRange == -1) {
                    scrollRange = appBarlayout.getTotalScrollRange();
                }
                if (scrollRange + verticalValue == 0) {
                    coolToolbar.setTitle(title);
                    isShow = true;
                } else if (isShow) {
                    coolToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
