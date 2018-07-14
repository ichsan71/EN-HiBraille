package id.or.codelabs.belajarbraille.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import id.or.codelabs.belajarbraille.R;
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
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setupToolbar();

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callSearch(newText);

                return true;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic

            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        cvBelajarHijaiyah.setOnClickListener(this);
        cvBelajarTandaBaca.setOnClickListener(this);
        cvBelajarPenggabungan.setOnClickListener(this);
        cvLatihanHijaiyah.setOnClickListener(this);
        cvLatihanTandaBaca.setOnClickListener(this);
        cvLatihanPenggabungan.setOnClickListener(this);
    }

    private void callSearch(String query) {
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Halaman Utama");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        searchView.setVoiceSearch(true);
        searchView.setHint("Cari simbol..");

        return true;
    }


    private void initView() {
        searchView = findViewById(R.id.search_view);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                break;
            case R.id.action_setting:
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
