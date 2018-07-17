package id.or.codelabs.belajarbraille.belajar_penggabungan;

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
import id.or.codelabs.belajarbraille.data.PenggabunganModel;
import id.or.codelabs.belajarbraille.penggabungan_detail.PenggabunganDetailActivity;

public class BelajarPenggabunganActivity extends AppCompatActivity implements BelajarPenggabunganContract.View,
        BelajarPenggabunganAdapter.PenggabunganListener{

    private BelajarPenggabunganContract.Presenter presenter;
    private List<Object> penggabunganDataSet = new ArrayList<>();
    private RecyclerView recyclerViewPenggabungan;
    private BelajarPenggabunganAdapter belajarPenggabunganAdapter;
    private Toolbar toolbar;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_penggabungan);

        initView();
        setupToolbar();
        setupRecyclerView();

        presenter = new BelajarPenggabunganPresenter(this);
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
        searchView = findViewById(R.id.search_view_penggabungan);
        recyclerViewPenggabungan = findViewById(R.id.belajarpenggabungan_recyclerview);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_belajar_penggabungan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Braille Gabungan");
    }

    private void setupRecyclerView() {
        belajarPenggabunganAdapter = new BelajarPenggabunganAdapter(getContext(), new ArrayList<PenggabunganModel>(), this);
        recyclerViewPenggabungan.setLayoutManager(new GridLayoutManager(BelajarPenggabunganActivity.this, 2));
        recyclerViewPenggabungan.setHasFixedSize(true);
        recyclerViewPenggabungan.setAdapter(belajarPenggabunganAdapter);
    }

    @Override
    public void showPenggabunganData(List<PenggabunganModel> penggabunganDataSet) {
        belajarPenggabunganAdapter.replaceData(penggabunganDataSet);
    }

    @Override
    public Context getContext() {
        return BelajarPenggabunganActivity.this;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        searchView.setVoiceSearch(true);
        searchView.setHint("Cari simbol gabungan..");

        return true;
    }

    @Override
    public void onPenggabunganClick(PenggabunganModel penggabunganModel) {
        String data = new Gson().toJson(penggabunganModel);
        Intent intent = new Intent(BelajarPenggabunganActivity.this, PenggabunganDetailActivity.class);
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
