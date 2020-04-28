package com.adiyusuf.foxidea.ui.mainPage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adiyusuf.foxidea.R;
import com.adiyusuf.foxidea.ui.helper.CollapsingToolbarChangeTitle;

public class TentangFragment extends Fragment {
    private CollapsingToolbarChangeTitle changeTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tentang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeTitle = new CollapsingToolbarChangeTitle(getContext());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        String titleToolbar = getString(R.string.menu_tentang);
        changeTitle.setTitle(titleToolbar);
    }
}
