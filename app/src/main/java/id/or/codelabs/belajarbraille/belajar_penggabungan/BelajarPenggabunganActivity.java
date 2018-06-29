package id.or.codelabs.belajarbraille.belajar_penggabungan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class BelajarPenggabunganActivity extends AppCompatActivity implements BelajarPenggabunganContract.View{

    private BelajarPenggabunganContract.Presenter presenter;
    private List<Object> penggabunganDataSet = new ArrayList<>();
    private RecyclerView recyclerViewPenggabungan;
    private BelajarPenggabunganAdapter.PenggabunganListener penggabunganListener;
    private BelajarPenggabunganAdapter belajarPenggabunganAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_penggabungan);

        initView();
        setupToolbar();
        setupRecyclerView();

        presenter = new BelajarPenggabunganPresenter(this);
        presenter.start();
    }

    private void initView() {
        recyclerViewPenggabungan = findViewById(R.id.belajarpenggabungan_recyclerview);
    }

    private void setupToolbar() {
        this.setTitle("Braille Gabungan");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupRecyclerView() {
        belajarPenggabunganAdapter = new BelajarPenggabunganAdapter(getContext(), new ArrayList<PenggabunganModel>(), penggabunganListener);
        recyclerViewPenggabungan.setLayoutManager(new GridLayoutManager(BelajarPenggabunganActivity.this, 2));
        recyclerViewPenggabungan.setHasFixedSize(true);
        recyclerViewPenggabungan.setAdapter(belajarPenggabunganAdapter);
    }

    @Override
    public void showPenggabunganData(List<PenggabunganModel> penggabunganDataSet) {
        belajarPenggabunganAdapter.replaceData(penggabunganDataSet);
    }

    @Override
    public void showPenggabunganDetailView() {

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
        return true;
    }
}
