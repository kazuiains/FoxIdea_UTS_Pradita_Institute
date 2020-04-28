package com.adiyusuf.foxidea.modul;

import android.content.Context;
import android.content.res.TypedArray;

import com.adiyusuf.foxidea.R;

import java.util.ArrayList;

public class ApplicationData {
    private Context context;
    private ArrayList<PojoData> dataList;
    private TypedArray fotoData;
    private String[] namaData, kingdomData, kelasData, ordoData, familiData, namaLatinData, descriptionData, suaraData, extra1Data, extra2Data, extra3Data, extra4Data;

    public ApplicationData(Context context, int minLength, int maxLength) {
        this.context = context;
        inisialisasiArray();
        setData(minLength,maxLength);
    }

    private void inisialisasiArray() {
        namaData = context.getResources().getStringArray(R.array.name);
        kingdomData = context.getResources().getStringArray(R.array.kingdom);
        kelasData = context.getResources().getStringArray(R.array.kelas);
        ordoData = context.getResources().getStringArray(R.array.ordo);
        familiData = context.getResources().getStringArray(R.array.famili);
        namaLatinData = context.getResources().getStringArray(R.array.science_name);
        descriptionData = context.getResources().getStringArray(R.array.description);
        suaraData = context.getResources().getStringArray(R.array.additional);
        fotoData = context.getResources().obtainTypedArray(R.array.main_photo);
        extra1Data = context.getResources().getStringArray(R.array.photo1);
        extra2Data = context.getResources().getStringArray(R.array.photo2);
        extra3Data = context.getResources().getStringArray(R.array.photo3);
        extra4Data = context.getResources().getStringArray(R.array.photo4);
    }

    private void setData(int minLength, int maxLength) {

        dataList = new ArrayList<>();

        for (int i = minLength; i < maxLength; i++) {
            PojoData liSt = new PojoData();
            liSt.setFoto(fotoData.getResourceId(i, 1));
            liSt.setNama(namaData[i]);
            liSt.setKingdom(kingdomData[i]);
            liSt.setKelas(kelasData[i]);
            liSt.setOrdo(ordoData[i]);
            liSt.setFamili(familiData[i]);
            liSt.setNamaLatin(namaLatinData[i]);
            liSt.setDescription(descriptionData[i]);
            liSt.setSuara(suaraData[i]);
            liSt.setExtra1(extra1Data[i]);
            liSt.setExtra2(extra2Data[i]);
            liSt.setExtra3(extra3Data[i]);
            liSt.setExtra4(extra4Data[i]);
            dataList.add(liSt);
        }
    }

    public ArrayList<PojoData> getData() {
        return dataList;
    }
}
