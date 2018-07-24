package id.or.codelabs.belajarbraille.learn_hijaiyah;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;
import id.or.codelabs.belajarbraille.hijaiyah_detail.HijaiyahDetailActivity;

public class LearnHijaiyahActivity extends AppCompatActivity implements LearnHijaiyahContract.View,
        LearnHijaiyahAdapter.HijaiyahListener{

    private LearnHijaiyahContract.Presenter presenter;
    private List<Object> hijaiyahDataSet = new ArrayList<>();
    private RecyclerView recyclerViewHijaiyah;
    private LearnHijaiyahAdapter belajarHijaiyahAdapter;
    private Toolbar toolbar;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utility.getTheme(LearnHijaiyahActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GoogleTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_hijaiyah);
        initView();
        setupToolbar();
        setupRecyclerView();

        presenter = new LearnHijaiyahPresenter(this);
        presenter.start();

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
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
    }

    private void callSearch(String newText) {
        belajarHijaiyahAdapter.getFilter().filter(newText);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_learn_hijaiyah);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Braille Hijaiyah");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        searchView = findViewById(R.id.search_view_hijaiyah);
        recyclerViewHijaiyah = findViewById(R.id.learnhijaiyah_recyclerview);
        searchView.findViewById(R.id.action_voice_btn).setContentDescription("Penelusuran Suara");
        searchView.findViewById(R.id.action_up_btn).setContentDescription("Navigasi Naik");
    }

    private void setupRecyclerView() {
        belajarHijaiyahAdapter = new LearnHijaiyahAdapter(getContext(), new ArrayList<HijaiyahModel>(), this);
        recyclerViewHijaiyah.setLayoutManager(new GridLayoutManager(LearnHijaiyahActivity.this, 2));
        recyclerViewHijaiyah.setHasFixedSize(true);
        recyclerViewHijaiyah.setAdapter(belajarHijaiyahAdapter);
    }

    @Override
    public Context getContext() {
        return LearnHijaiyahActivity.this;
    }

    @Override
    public void showHijaiyahData(List<HijaiyahModel> hijaiyahDataSet) {
        belajarHijaiyahAdapter.replaceData(hijaiyahDataSet);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        searchView.setVoiceSearch(true);
        searchView.setHint("Cari simbol hijaiyah..");

        return true;
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
    public void onHijaiyahClick(HijaiyahModel hijaiyahModel) {
        String data = new Gson().toJson(hijaiyahModel);
        Intent intent = new Intent(LearnHijaiyahActivity.this, HijaiyahDetailActivity.class);
        intent.putExtra("hijaiyah", data);
        startActivity(intent);
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
