package id.or.codelabs.belajarbraille.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.belajar_hijaiyah.BelajarHijaiyahActivity;
import id.or.codelabs.belajarbraille.belajar_penggabungan.BelajarPenggabunganActivity;
import id.or.codelabs.belajarbraille.belajar_tandabaca.BelajarTandaBacaActivity;
import id.or.codelabs.belajarbraille.latihan_hijaiyah.LatihanHijaiyah_Activity;
import id.or.codelabs.belajarbraille.latihan_penggabungan.LatihanPenggabungan_Activity;
import id.or.codelabs.belajarbraille.latihan_tandabaca.LatihanTandaBaca_Activity;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener{

    Toolbar toolbar;
    private CardView cvBelajarHijaiyah;
    private CardView cvBelajarTandaBaca;
    private CardView cvBelajarPenggabungan;
    private CardView cvLatihanHijaiyah;
    private CardView cvLatihanTandaBaca;
    private CardView cvLatihanPenggabungan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setupToolbar();
        cvBelajarHijaiyah.setOnClickListener(this);
        cvBelajarTandaBaca.setOnClickListener(this);
        cvBelajarPenggabungan.setOnClickListener(this);
        cvLatihanHijaiyah.setOnClickListener(this);
        cvLatihanTandaBaca.setOnClickListener(this);
        cvLatihanPenggabungan.setOnClickListener(this);

    }

    private void setupToolbar() {
        this.setTitle("Halaman Utama");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initView() {
        cvBelajarHijaiyah = (CardView)findViewById(R.id.main_cardview_belajar_hijaiyah);
        cvBelajarTandaBaca = (CardView)findViewById(R.id.main_cardview_belajar_tanda_baca);
        cvBelajarPenggabungan = (CardView)findViewById(R.id.main_cardview_belajar_penggabungan);
        cvLatihanHijaiyah = (CardView)findViewById(R.id.main_cardview_latihan_hijaiyah);
        cvLatihanTandaBaca = (CardView)findViewById(R.id.main_cardview_latihan_tanda_baca);
        cvLatihanPenggabungan = (CardView)findViewById(R.id.main_cardview_latihan_penggabungan);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_cardview_belajar_hijaiyah:
                showBelajarHijaiyahView();
                break;
            case R.id.main_cardview_belajar_tanda_baca:
                showBelajarTandaBacaView();
                break;
            case R.id.main_cardview_belajar_penggabungan:
                showBelajarPenggabunganView();
                break;
            case R.id.main_cardview_latihan_hijaiyah:
                showLatihanHijaiyahView();
                break;
            case R.id.main_cardview_latihan_tanda_baca:
                showLatihanTandaBacaView();
                break;
            case R.id.main_cardview_latihan_penggabungan:
                showLatihanPenggabunganView();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showBelajarHijaiyahView() {
        Intent intent = new Intent(MainActivity.this, BelajarHijaiyahActivity.class);
        startActivity(intent);
    }

    @Override
    public void showBelajarTandaBacaView() {
        Intent intent = new Intent(MainActivity.this, BelajarTandaBacaActivity.class);
        startActivity(intent);
    }

    @Override
    public void showBelajarPenggabunganView() {
        Intent intent = new Intent(MainActivity.this, BelajarPenggabunganActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanHijaiyahView() {
        Intent intent = new Intent(MainActivity.this, LatihanHijaiyah_Activity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanTandaBacaView() {
        Intent intent = new Intent(MainActivity.this, LatihanTandaBaca_Activity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanPenggabunganView() {
        Intent intent = new Intent(MainActivity.this, LatihanPenggabungan_Activity.class);
        startActivity(intent);
    }
}
