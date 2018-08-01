package id.or.codelabs.belajarbraille.learn_punctuation;

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

import id.or.codelabs.belajarbraille.GridRecyclerViewItemSpaces;
import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.data.PunctuationModel;
import id.or.codelabs.belajarbraille.punctuation_detail.PunctuationDetailActivity;

public class LearnPunctuationActivity extends AppCompatActivity implements LearnPunctuationContract.View, LearnPunctuationAdapter.PunctuationListener {

    private LearnPunctuationContract.Presenter presenter;
    private List<Object> punctuationDataSet = new ArrayList<>();
    private RecyclerView recyclerViewPunctuation;
    private LearnPunctuationAdapter belajarPunctuationAdapter;
    private Toolbar toolbar;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utility.getTheme(LearnPunctuationActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GreenTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_punctuation);

        initView();
        setupToolbar();
        setupRecyclerView();

        presenter = new LearnPunctuationPresenter(this);
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
        belajarPunctuationAdapter.getFilter().filter(newText);
    }

    private void initView() {
        searchView = findViewById(R.id.search_view_punctuation);
        recyclerViewPunctuation = findViewById(R.id.learnpunctuation_recyclerview);
        searchView.findViewById(R.id.action_voice_btn).setContentDescription("Penelusuran Suara");
        searchView.findViewById(R.id.action_up_btn).setContentDescription("Navigasi Naik");
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_learn_punctuation);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Braille Tanda Baca");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeActionContentDescription("Navigasi Kembali");
    }

    private void setupRecyclerView() {
        belajarPunctuationAdapter = new LearnPunctuationAdapter(getContext(), new ArrayList<PunctuationModel>(), this);
        recyclerViewPunctuation.setLayoutManager(new GridLayoutManager(LearnPunctuationActivity.this, 2));
        int spacing = getResources().getDimensionPixelSize(R.dimen.item_spaces);
        recyclerViewPunctuation.addItemDecoration(new GridRecyclerViewItemSpaces(spacing));
        recyclerViewPunctuation.setHasFixedSize(true);
        recyclerViewPunctuation.setAdapter(belajarPunctuationAdapter);
    }

    @Override
    public void showPunctuationData(List<PunctuationModel> punctuationDataSet) {
        belajarPunctuationAdapter.replaceData(punctuationDataSet);
        toolbar.setContentDescription("Menu Belajar Braille Tanda Baca. " + String.valueOf(punctuationDataSet.size()) + " Simbol.");
    }

    @Override
    public Context getContext() {
        return LearnPunctuationActivity.this;
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
        searchView.setHint("Cari simbol tanda baca..");

        return true;
    }

    @Override
    public void onPunctuationClick(PunctuationModel punctuationModel) {
        String data = new Gson().toJson(punctuationModel);
        Intent intent = new Intent(LearnPunctuationActivity.this, PunctuationDetailActivity.class);
        intent.putExtra("punctuation", data);
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
