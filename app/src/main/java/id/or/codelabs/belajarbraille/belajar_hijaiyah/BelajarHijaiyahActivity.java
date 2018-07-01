package id.or.codelabs.belajarbraille.belajar_hijaiyah;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;
import id.or.codelabs.belajarbraille.hijaiyah_detail.HijaiyahDetailActivity;

public class BelajarHijaiyahActivity extends AppCompatActivity implements BelajarHijaiyahContract.View,
        BelajarHijaiyahAdapter.HijaiyahListener{

    private BelajarHijaiyahContract.Presenter presenter;
    private List<Object> hijaiyahDataSet = new ArrayList<>();
    private RecyclerView recyclerViewHijaiyah;
    private BelajarHijaiyahAdapter belajarHijaiyahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_hijaiyah);
        initView();
        setupToolbar();
        setupRecyclerView();

        presenter = new BelajarHijaiyahPresenter(this);
        presenter.start();
    }

    private void setupToolbar() {
        this.setTitle("Braille Hijaiyah");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        recyclerViewHijaiyah = findViewById(R.id.belajarhijaiyah_recyclerview);
    }

    private void setupRecyclerView() {
        belajarHijaiyahAdapter = new BelajarHijaiyahAdapter(getContext(), new ArrayList<HijaiyahModel>(), this);
        recyclerViewHijaiyah.setLayoutManager(new GridLayoutManager(BelajarHijaiyahActivity.this, 2));
        recyclerViewHijaiyah.setHasFixedSize(true);
        recyclerViewHijaiyah.setAdapter(belajarHijaiyahAdapter);
    }

    @Override
    public Context getContext() {
        return BelajarHijaiyahActivity.this;
    }

    @Override
    public void showHijaiyahData(List<HijaiyahModel> hijaiyahDataSet) {
        belajarHijaiyahAdapter.replaceData(hijaiyahDataSet);
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
        return true;
    }

    @Override
    public void onHijaiyahClick(HijaiyahModel hijaiyahModel) {
        String data = new Gson().toJson(hijaiyahModel);
        Intent intent = new Intent(BelajarHijaiyahActivity.this, HijaiyahDetailActivity.class);
        intent.putExtra("hijaiyah", data);
        startActivity(intent);
    }
}
