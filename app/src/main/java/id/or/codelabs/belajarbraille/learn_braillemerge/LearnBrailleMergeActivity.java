package id.or.codelabs.belajarbraille.learn_braillemerge;

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
import id.or.codelabs.belajarbraille.braillemerge_detail.BrailleMergeDetailActivity;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class LearnBrailleMergeActivity extends AppCompatActivity implements LearnBrailleMergeContract.View,
        LearnBrailleMergeAdapter.PenggabunganListener{

    private LearnBrailleMergeContract.Presenter presenter;
    private List<Object> penggabunganDataSet = new ArrayList<>();
    private RecyclerView recyclerViewPenggabungan;
    private LearnBrailleMergeAdapter belajarPenggabunganAdapter;
    private Toolbar toolbar;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utility.getTheme(LearnBrailleMergeActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GoogleTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_braille_merge);

        initView();
        setupToolbar();
        setupRecyclerView();

        presenter = new LearnBrailleMergePresenter(this);
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
        belajarPenggabunganAdapter.getFilter().filter(newText);
    }

    private void initView() {
        searchView = findViewById(R.id.search_view_braille_merge);
        recyclerViewPenggabungan = findViewById(R.id.learnbraillemerge_recyclerview);
        searchView.findViewById(R.id.action_voice_btn).setContentDescription("Penelusuran Suara");
        searchView.findViewById(R.id.action_up_btn).setContentDescription("Navigasi Naik");
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_learn_braille_merge);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Braille Gabungan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupRecyclerView() {
        belajarPenggabunganAdapter = new LearnBrailleMergeAdapter(getContext(), new ArrayList<PenggabunganModel>(), this);
        recyclerViewPenggabungan.setLayoutManager(new GridLayoutManager(LearnBrailleMergeActivity.this, 2));
        recyclerViewPenggabungan.setHasFixedSize(true);
        recyclerViewPenggabungan.setAdapter(belajarPenggabunganAdapter);
    }

    @Override
    public void showPenggabunganData(List<PenggabunganModel> penggabunganDataSet) {
        belajarPenggabunganAdapter.replaceData(penggabunganDataSet);
    }

    @Override
    public Context getContext() {
        return LearnBrailleMergeActivity.this;
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
        searchView.setHint("Cari simbol gabungan..");

        return true;
    }

    @Override
    public void onPenggabunganClick(PenggabunganModel penggabunganModel) {
        String data = new Gson().toJson(penggabunganModel);
        Intent intent = new Intent(LearnBrailleMergeActivity.this, BrailleMergeDetailActivity.class);
        intent.putExtra("penggabungan", data);
        startActivity(intent);
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
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
