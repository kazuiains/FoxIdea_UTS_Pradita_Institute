package com.adiyusuf.foxidea.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adiyusuf.foxidea.R;
import com.adiyusuf.foxidea.modul.PojoData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int FIRST = 1;
    private static int GENAP = 2;
    private static int GANJIL = 3;

    private Context context;
    private ArrayList<PojoData> dataList;

    public ReviewAdapter(Context context, ArrayList<PojoData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == FIRST) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_first_recycler_view, parent, false);
            return new FirstViewHolder(view);

        } else if (viewType == GENAP) { // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.list_item_even_recycler_view, parent, false);
            return new EvenViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_odd_recycler_view, parent, false);
            return new OddViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FIRST;
        } else if (position % 2 == 1) {
            return GANJIL;
        } else {
            return GENAP;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == FIRST) {
            ((FirstViewHolder) holder).setFirstDetails(dataList.get(position));
        } else if (getItemViewType(position) == GANJIL) {
            ((OddViewHolder) holder).setOddDetails(dataList.get(position));
        } else {
            ((EvenViewHolder) holder).setEvenDetails(dataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class FirstViewHolder extends RecyclerView.ViewHolder {
        private ImageView backgroundData;
        private TextView nameData, namaLatinData, descriptionData;
        private ImageView fotoData;

        FirstViewHolder(@NonNull View itemView) {
            super(itemView);
            nameData = itemView.findViewById(R.id.name_list_first);
            namaLatinData = itemView.findViewById(R.id.sub_name_list_first);
            descriptionData = itemView.findViewById(R.id.deskrip_list_first);
            fotoData = itemView.findViewById(R.id.profile_list_first);
            backgroundData = itemView.findViewById(R.id.background_list_first);
        }

        void setFirstDetails(PojoData itemData) {
            nameData.setText(itemData.getNama());
            namaLatinData.setText(itemData.getNamaLatin());
            descriptionData.setText(itemData.getDescription());
            fotoData.setImageResource(itemData.getFoto());

            String linkGambar = itemData.getExtra1();

            Glide.with(context)
                    .load(linkGambar)
                    .apply(new RequestOptions())
                    .into(backgroundData);
        }
    }

    class EvenViewHolder extends RecyclerView.ViewHolder {
        private TextView nameData, namaLatinData, descriptionData;
        private ImageView fotoData;

        EvenViewHolder(@NonNull View itemView) {
            super(itemView);
            nameData = itemView.findViewById(R.id.name_list_even);
            namaLatinData = itemView.findViewById(R.id.sub_name_list_even);
            descriptionData = itemView.findViewById(R.id.deskrip_list_even);
            fotoData = itemView.findViewById(R.id.profile_list_even);
        }

        void setEvenDetails(PojoData itemData) {
            nameData.setText(itemData.getNama());
            namaLatinData.setText(itemData.getNamaLatin());
            descriptionData.setText(itemData.getDescription());
            fotoData.setImageResource(itemData.getFoto());
        }
    }

    class OddViewHolder extends RecyclerView.ViewHolder {
        private TextView nameData, namaLatinData, descriptionData;
        private ImageView fotoData;

        OddViewHolder(@NonNull View itemView) {
            super(itemView);
            nameData = itemView.findViewById(R.id.name_list_odd);
            namaLatinData = itemView.findViewById(R.id.sub_name_list_odd);
            descriptionData = itemView.findViewById(R.id.deskrip_list_odd);
            fotoData = itemView.findViewById(R.id.profile_list_odd);
        }

        void setOddDetails(PojoData itemData) {
            nameData.setText(itemData.getNama());
            namaLatinData.setText(itemData.getNamaLatin());
            descriptionData.setText(itemData.getDescription());
            fotoData.setImageResource(itemData.getFoto());
        }
    }


}
