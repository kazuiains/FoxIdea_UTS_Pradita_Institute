package com.adiyusuf.foxidea.modul;

import android.os.Parcel;
import android.os.Parcelable;

public class PojoData implements Parcelable {
    private String nama, kingdom, kelas, ordo, famili, namaLatin, description, suara, extra1, extra2, extra3, extra4;
    private int foto;

    public String getNama() {
        return nama;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    public String getKingdom() {
        return kingdom;
    }

    void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getKelas() {
        return kelas;
    }

    void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getOrdo() {
        return ordo;
    }

    void setOrdo(String ordo) {
        this.ordo = ordo;
    }

    public String getFamili() {
        return famili;
    }

    void setFamili(String famili) {
        this.famili = famili;
    }

    public String getNamaLatin() {
        return namaLatin;
    }

    void setNamaLatin(String namaLatin) {
        this.namaLatin = namaLatin;
    }

    public String getSuara() {
        return suara;
    }

    void setSuara(String suara) {
        this.suara = suara;
    }

    public String getExtra1() {
        return extra1;
    }

    void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

    public String getExtra4() {
        return extra4;
    }

    void setExtra4(String extra4) {
        this.extra4 = extra4;
    }

    public int getFoto() {
        return foto;
    }

    void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.kingdom);
        dest.writeString(this.kelas);
        dest.writeString(this.ordo);
        dest.writeString(this.famili);
        dest.writeString(this.namaLatin);
        dest.writeString(this.description);
        dest.writeString(this.suara);
        dest.writeString(this.extra1);
        dest.writeString(this.extra2);
        dest.writeString(this.extra3);
        dest.writeString(this.extra4);
        dest.writeInt(this.foto);
    }

    PojoData() {
    }

    private PojoData(Parcel in) {
        this.nama = in.readString();
        this.kingdom = in.readString();
        this.kelas = in.readString();
        this.ordo = in.readString();
        this.famili = in.readString();
        this.namaLatin = in.readString();
        this.description = in.readString();
        this.suara = in.readString();
        this.extra1 = in.readString();
        this.extra2 = in.readString();
        this.extra3 = in.readString();
        this.extra4 = in.readString();
        this.foto = in.readInt();
    }

    public static final Parcelable.Creator<PojoData> CREATOR = new Parcelable.Creator<PojoData>() {
        @Override
        public PojoData createFromParcel(Parcel source) {
            return new PojoData(source);
        }

        @Override
        public PojoData[] newArray(int size) {
            return new PojoData[size];
        }
    };
}
