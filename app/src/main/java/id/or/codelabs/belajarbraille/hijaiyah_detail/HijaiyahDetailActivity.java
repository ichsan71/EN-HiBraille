package id.or.codelabs.belajarbraille.hijaiyah_detail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;

public class HijaiyahDetailActivity extends AppCompatActivity implements HijaiyahDetailContract.View {

    private HijaiyahDetailContract.Presenter presenter;
    private ImageView imageHijaiyah;
    private TextView nameHijaiyah;
    private Button buttonCariHukumBacaan;
    private View brailleDot1;
    private View brailleDot2;
    private View brailleDot3;
    private View brailleDot4;
    private View brailleDot5;
    private View brailleDot6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah_detail);

        initView();
        setupAppbar();

        presenter = new HijaiyahDetailPresenter(this);
        if (getIntent() != null && getIntent().getStringExtra("hijaiyah") != null) {
            presenter.loadHijaiyahDetail(new Gson().fromJson(getIntent().getStringExtra("hijaiyah"), HijaiyahModel.class));
        }
    }

    private void setupAppbar() {
        this.setTitle("Detail Braille");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        imageHijaiyah = findViewById(R.id.hijaiyahdetail_imageview_hijaiyah);
        nameHijaiyah = findViewById(R.id.hijaiyahdetail_textview_nama_simbol);
        buttonCariHukumBacaan = findViewById(R.id.hijaiyahdetail_button_tombol_cari_hukum_bacaan);
        brailleDot1 = findViewById(R.id.hijaiyahdetail_titik_braille_1);
        brailleDot2 = findViewById(R.id.hijaiyahdetail_titik_braille_2);
        brailleDot3 = findViewById(R.id.hijaiyahdetail_titik_braille_3);
        brailleDot4 = findViewById(R.id.hijaiyahdetail_titik_braille_4);
        brailleDot5 = findViewById(R.id.hijaiyahdetail_titik_braille_5);
        brailleDot6 = findViewById(R.id.hijaiyahdetail_titik_braille_6);
        Drawable drawable = HijaiyahDetailActivity.this.getResources().getDrawable(R.drawable.ic_google);
        drawable.setBounds(0, 0, 40, 40);
        buttonCariHukumBacaan.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void showHijaiyahDetail(HijaiyahModel hijaiyahModel) {
        if(hijaiyahModel.getListBrailleDots().get(0) == 1){
            brailleDot1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(hijaiyahModel.getListBrailleDots().get(1) == 1){
            brailleDot2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(hijaiyahModel.getListBrailleDots().get(2) == 1){
            brailleDot3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(hijaiyahModel.getListBrailleDots().get(3) == 1){
            brailleDot4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(hijaiyahModel.getListBrailleDots().get(4) == 1){
            brailleDot5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(hijaiyahModel.getListBrailleDots().get(5) == 1){
            brailleDot6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }
        imageHijaiyah.setImageResource(hijaiyahModel.getImageHijaiyah());
        nameHijaiyah.setText(hijaiyahModel.getNameHijaiyah());
    }

    @Override
    public Context getContext() {
        return HijaiyahDetailActivity.this;
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
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }
}