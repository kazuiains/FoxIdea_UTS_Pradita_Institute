package com.adiyusuf.foxidea.ui.detailPage;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.adiyusuf.foxidea.R;
import com.adiyusuf.foxidea.modul.PojoData;
import com.adiyusuf.foxidea.ui.helper.CollapsingToolbarDetail;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_DATA = "Semua_Data_Dari_Item_yang_di_klik";
    private CardView btn1, btn2, btnInfo, btnFoto;
    private LinearLayout pageInfo, pageFoto;
    private ImageView ivBackground, ivFirstProfile, ivInfo1, ivInfo2, ivBottomProfile;
    private TextView tvFirstName, tvFirstIlmiah, tvNameInfo1, tvDeskrip, tvNama, tvIlmiah, tvKingdom, tvKelas, tvOrdo, tvFamili, tvNameInfo2, tvSoundManfaat1, tvSoundManfaat2;
    private String txtNama, txtSuara, txtGambar1, txtGambar2, txtGambar3, txtGambar4, StringEdit, txtKingdom;
    private MediaPlayer mediaPlayer;
    private CollapsingToolbarDetail collapse;

    private View icon1, icon2;
    private String A, P, N, S, D;
    private Drawable play, stop;
    private Dialog myDialog;

    private ImageView ivdata1, ivdata2, ivdata3, ivdata4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        getAndSet();
        if (txtKingdom.equals(A) && !txtSuara.equals(N)) {
            soundListener();
        } else if (txtKingdom.equals(P)) {
            myDialog = new Dialog(this);
        }


    }

    public void init() {
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //font
        Typeface typeface = ResourcesCompat.getFont(getBaseContext(), R.font.gibson_regular);
        //collapsing toolbar
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.cooltoolbar_detail);
        //change font family collapsing toolbar
        collapsingToolbar.setExpandedTitleTypeface(typeface);
        collapsingToolbar.setCollapsedTitleTypeface(typeface);
        //adapterCollapsing
        collapse = new CollapsingToolbarDetail(this);
        //CardView
        btn1 = findViewById(R.id.btn_suara_atau_manfaat1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn_suara_atau_manfaat2);
        btn2.setOnClickListener(this);
        btnInfo = findViewById(R.id.info_layout);
        btnInfo.setOnClickListener(this);
        btnFoto = findViewById(R.id.foto_layout);
        btnFoto.setOnClickListener(this);
        //LinearLayout
        pageInfo = findViewById(R.id.layout_info_page);
        pageFoto = findViewById(R.id.layout_foto_page);
        //ImageView
        ivBackground = findViewById(R.id.background_profil_detail);
        ivFirstProfile = findViewById(R.id.profil_detail);
        ivInfo1 = findViewById(R.id.image_info_profil1);
        ivInfo2 = findViewById(R.id.image_info_profil2);
        ivBottomProfile = findViewById(R.id.profile_image_bottom);
        //TextView
        tvFirstName = findViewById(R.id.name_Profil);
        tvNameInfo1 = findViewById(R.id.name_info_profil1);
        tvNameInfo2 = findViewById(R.id.name_info_profil2);
        tvNama = findViewById(R.id.txt_nama);
        tvFirstIlmiah = findViewById(R.id.sub_name_Profil);
        tvIlmiah = findViewById(R.id.txt_ilmiah);
        tvDeskrip = findViewById(R.id.isi_info1);
        tvKingdom = findViewById(R.id.txt_kingdom);
        tvKelas = findViewById(R.id.txt_kelas);
        tvOrdo = findViewById(R.id.txt_ordo);
        tvFamili = findViewById(R.id.txt_famili);
        tvSoundManfaat1 = findViewById(R.id.txt_suara_atau_manfaat);
        tvSoundManfaat2 = findViewById(R.id.txt_suara_atau_manfaat2);
        //View
        icon1 = findViewById(R.id.icon_btn1);
        icon2 = findViewById(R.id.icon_btn2);
        //page Image
        ivdata1 = findViewById(R.id.image1_page_foto);
        ivdata2 = findViewById(R.id.image2_page_foto);
        ivdata3 = findViewById(R.id.image3_page_foto);
        ivdata4 = findViewById(R.id.image4_page_foto);
    }

    public void getAndSet() {
        A = getString(R.string.A);
        P = getString(R.string.P);
        N = getString(R.string.N);
        S = getString(R.string.berhenti);
        D = getString(R.string.bersuara);
        play = getDrawable(R.drawable.play);
        stop = getDrawable(R.drawable.stop);
        PojoData data = getIntent().getParcelableExtra(EXTRA_DATA);
        assert data != null;
        txtNama = data.getNama();
        String txtIlmiah = data.getNamaLatin();
        txtSuara = data.getSuara();
        txtGambar1 = data.getExtra1();
        txtGambar2 = data.getExtra2();
        txtGambar3 = data.getExtra3();
        txtGambar4 = data.getExtra4();
        txtKingdom = data.getKingdom();
        int gambar = data.getFoto();

        //toolbar
        collapse.setTitle(txtNama);
        //button
        configButtonSoundManfaat();

        tvFirstName.setText(txtNama);
        tvNameInfo1.setText(txtNama);
        tvNameInfo2.setText(txtNama);
        tvNama.setText(txtNama);
        tvFirstIlmiah.setText(txtIlmiah);
        tvIlmiah.setText(txtIlmiah);
        tvDeskrip.setText(data.getDescription());
        tvKingdom.setText(txtKingdom);
        tvKelas.setText(data.getKelas());
        tvOrdo.setText(data.getOrdo());
        tvFamili.setText(data.getFamili());

        ivFirstProfile.setImageResource(gambar);
        ivInfo1.setImageResource(gambar);
        ivInfo2.setImageResource(gambar);
        ivBottomProfile.setImageResource(gambar);

        Glide.with(getBaseContext())
                .load(txtGambar1)
                .apply(new RequestOptions())
                .into(ivBackground);

        Glide.with(getBaseContext())
                .load(txtGambar1)
                .apply(new RequestOptions())
                .into(ivdata1);

        Glide.with(getBaseContext())
                .load(txtGambar2)
                .apply(new RequestOptions())
                .into(ivdata2);

        Glide.with(getBaseContext())
                .load(txtGambar3)
                .apply(new RequestOptions())
                .into(ivdata3);

        Glide.with(getBaseContext())
                .load(txtGambar4)
                .apply(new RequestOptions())
                .into(ivdata4);
    }

    public void configButtonSoundManfaat() {
        if (txtKingdom.equals(A)) {
            if (txtSuara.equals(N)) {
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn1.setFocusable(false);
                btn2.setFocusable(false);
                btn1.setForeground(null);
                btn2.setForeground(null);
                btn1.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.btnBackgroundDisable));
                btn2.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.btnBackgroundDisable));
                tvSoundManfaat1.setTextColor(ContextCompat.getColorStateList(getApplicationContext(), R.color.btnTextDisable));
                tvSoundManfaat2.setTextColor(ContextCompat.getColorStateList(getApplicationContext(), R.color.btnTextDisable));

                StringEdit = txtNama + " " + getString(R.string.tak_bersuara_edit);
                tvSoundManfaat2.setText(getString(R.string.tak_bersuara));
                icon1.setBackground(getDrawable(R.drawable.tak_bersuara));
                icon2.setBackground(getDrawable(R.drawable.tak_bersuara));
            } else {
                StringEdit = getString(R.string.bersuara_edit) + " " + txtNama;
                tvSoundManfaat2.setText(D);
                icon1.setBackground(play);
                icon2.setBackground(play);
            }
        } else {
            StringEdit = getString(R.string.manfaat_edit) + " " + txtNama;
            tvSoundManfaat2.setText(getString(R.string.manfaat));
            icon1.setBackground(getDrawable(R.drawable.manfaat));
            icon2.setBackground(getDrawable(R.drawable.manfaat));
        }

        tvSoundManfaat1.setText(StringEdit);
    }

    public void soundListener() {
        Uri sound = Uri.parse("android.resource://" + getPackageName() + "/raw/" + txtSuara);
        mediaPlayer = MediaPlayer.create(this, sound);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                tvSoundManfaat2.setText(D);
                tvSoundManfaat1.setText(StringEdit);
                icon1.setBackground(play);
                icon2.setBackground(play);
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_suara_atau_manfaat1 || v.getId() == R.id.btn_suara_atau_manfaat2) {
            if (txtKingdom.equals(A) && !txtSuara.equals(N)) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tvSoundManfaat2.setText(D);
                    tvSoundManfaat1.setText(StringEdit);
                    icon1.setBackground(play);
                    icon2.setBackground(play);
                } else {
                    mediaPlayer.start();
                    tvSoundManfaat1.setText(S);
                    tvSoundManfaat2.setText(S);
                    icon1.setBackground(stop);
                    icon2.setBackground(stop);
                }
            } else if (txtKingdom.equals(P)) {
                initDialog();
            }
        } else if (v.getId() == R.id.info_layout) {
            pageFoto.setVisibility(View.GONE);
            pageInfo.setVisibility(View.VISIBLE);
            btnInfo.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.colorAccent));
            btnFoto.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.colorGrayToDarkBlue2));
        } else if (v.getId() == R.id.foto_layout) {
            pageInfo.setVisibility(View.GONE);
            pageFoto.setVisibility(View.VISIBLE);
            btnInfo.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.colorGrayToDarkBlue2));
            btnFoto.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.colorAccent));
        }
    }


    public void initDialog() {
        TextView isi;
        myDialog.setContentView(R.layout.manfaat_view);
        isi = myDialog.findViewById(R.id.isi);
        isi.setText(txtSuara);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void mediaPlayerEnded() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (txtKingdom.equals(A) && !txtSuara.equals(N)) {
            mediaPlayerEnded();
        }
    }

    public boolean onSupportNavigateUp() {
        if (txtKingdom.equals(A) && !txtSuara.equals(N)) {
            mediaPlayerEnded();
        }
        finish();
        return true;
    }
}
