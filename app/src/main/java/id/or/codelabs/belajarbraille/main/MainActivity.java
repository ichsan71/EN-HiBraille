package id.or.codelabs.belajarbraille.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.ThemeSwitcherDialog;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.belajar_hijaiyah.BelajarHijaiyahActivity;
import id.or.codelabs.belajarbraille.belajar_penggabungan.BelajarPenggabunganActivity;
import id.or.codelabs.belajarbraille.belajar_tandabaca.BelajarTandaBacaActivity;
import id.or.codelabs.belajarbraille.latihan_hijaiyah.LatihanHijaiyahActivity;
import id.or.codelabs.belajarbraille.latihan_penggabungan.LatihanPenggabunganActivity;
import id.or.codelabs.belajarbraille.latihan_tandabaca.LatihanTandaBacaActivity;

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


        if(Utility.getTheme(MainActivity.this) == null || Utility.getTheme(MainActivity.this) == "Tema Default"){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GoogleTheme);
        }

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
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Halaman Utama");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_setting:
                FragmentActivity activity = (FragmentActivity)(getContext());
                FragmentManager fm = activity.getSupportFragmentManager();
                ThemeSwitcherDialog alertDialog = new ThemeSwitcherDialog();
                alertDialog.show(fm, "fragment_alert");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        cvBelajarHijaiyah = findViewById(R.id.main_cardview_belajar_hijaiyah);
        cvBelajarTandaBaca = findViewById(R.id.main_cardview_belajar_tanda_baca);
        cvBelajarPenggabungan = findViewById(R.id.main_cardview_belajar_penggabungan);
        cvLatihanHijaiyah = findViewById(R.id.main_cardview_latihan_hijaiyah);
        cvLatihanTandaBaca = findViewById(R.id.main_cardview_latihan_tanda_baca);
        cvLatihanPenggabungan = findViewById(R.id.main_cardview_latihan_penggabungan);
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
        Intent intent = new Intent(MainActivity.this, LatihanHijaiyahActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanTandaBacaView() {
        Intent intent = new Intent(MainActivity.this, LatihanTandaBacaActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanPenggabunganView() {
        Intent intent = new Intent(MainActivity.this, LatihanPenggabunganActivity.class);
        startActivity(intent);
    }
}
