package id.or.codelabs.belajarbraille.belajar_tandabaca;

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
import id.or.codelabs.belajarbraille.data.TandaBacaModel;
import id.or.codelabs.belajarbraille.tandabaca_detail.TandaBacaDetailActivity;

public class BelajarTandaBacaActivity extends AppCompatActivity implements BelajarTandaBacaContract.View, BelajarTandaBacaAdapter.TandaBacaListener {

    private BelajarTandaBacaContract.Presenter presenter;
    private List<Object> tandaBacaDataSet = new ArrayList<>();
    private RecyclerView recyclerViewTandaBaca;
    private BelajarTandaBacaAdapter belajarTandaBacaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_tanda_baca);

        initView();
        setupToolbar();
        setupRecyclerView();

        presenter = new BelajarTandaBacaPresenter(this);
        presenter.start();
    }

    private void initView() {
        recyclerViewTandaBaca = findViewById(R.id.belajartandabaca_recyclerview);
    }

    private void setupToolbar() {
        this.setTitle("Braille Tanda Baca");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupRecyclerView() {
        belajarTandaBacaAdapter = new BelajarTandaBacaAdapter(getContext(), new ArrayList<TandaBacaModel>(), this);
        recyclerViewTandaBaca.setLayoutManager(new GridLayoutManager(BelajarTandaBacaActivity.this, 2));
        recyclerViewTandaBaca.setHasFixedSize(true);
        recyclerViewTandaBaca.setAdapter(belajarTandaBacaAdapter);
    }

    @Override
    public void showTandaBacaData(List<TandaBacaModel> tandaBacaDataSet) {
        belajarTandaBacaAdapter.replaceData(tandaBacaDataSet);
    }

    @Override
    public Context getContext() {
        return BelajarTandaBacaActivity.this;
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
    public void onTandaBacaClick(TandaBacaModel tandaBacaModel) {
        String data = new Gson().toJson(tandaBacaModel);
        Intent intent = new Intent(BelajarTandaBacaActivity.this, TandaBacaDetailActivity.class);
        intent.putExtra("tanda-baca", data);
        startActivity(intent);
    }
}
