package com.adiyusuf.foxidea.ui.mainPage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adiyusuf.foxidea.ui.detailPage.DetailActivity;
import com.adiyusuf.foxidea.R;
import com.adiyusuf.foxidea.modul.ApplicationData;
import com.adiyusuf.foxidea.modul.PojoData;
import com.adiyusuf.foxidea.ui.adapter.ReviewAdapter;
import com.adiyusuf.foxidea.ui.helper.CollapsingToolbarChangeTitle;
import com.adiyusuf.foxidea.ui.helper.IcsRecyclerView;

import java.util.ArrayList;

public class LautFragment extends Fragment {
    private CollapsingToolbarChangeTitle changeTitle;
    private ApplicationData data;
    private RecyclerView recyclerView;
    private ArrayList<PojoData> dataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
        clickRecyclerView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ApplicationData(getContext(), 10, 20);
    }

    private void initialize(View view) {
        //get data
        dataList = data.getData();
        //helper for Toolbar
        changeTitle = new CollapsingToolbarChangeTitle(getContext());
        //adapter
        ReviewAdapter adapter = new ReviewAdapter(getContext(), dataList);
        //recyclerView
        recyclerView = view.findViewById(R.id.rv_xml);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void clickRecyclerView() {
        IcsRecyclerView.addTo(recyclerView).setOnItemClickListener(new IcsRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                PojoData iTem = dataList.get(position);
                Intent intentJump = new Intent(getContext(), DetailActivity.class);
                intentJump.putExtra(DetailActivity.EXTRA_DATA, iTem);
                startActivity(intentJump);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        String titleToolbar = getString(R.string.menu_laut);
        changeTitle.setTitle(titleToolbar);
    }
}