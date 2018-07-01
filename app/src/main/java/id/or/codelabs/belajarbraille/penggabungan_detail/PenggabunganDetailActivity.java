package id.or.codelabs.belajarbraille.penggabungan_detail;

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
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class PenggabunganDetailActivity extends AppCompatActivity implements PenggabunganDetailContract.View{

    private PenggabunganDetailPresenter presenter;
    private ImageView imagePenggabungan;
    private TextView namePenggabungan;
    private TextView spellPenggabungan;
    private Button buttonCariHukumBacaan;
    private View brailleDotHijaiyah1;
    private View brailleDotHijaiyah2;
    private View brailleDotHijaiyah3;
    private View brailleDotHijaiyah4;
    private View brailleDotHijaiyah5;
    private View brailleDotHijaiyah6;
    private View brailleDotTandaBaca1;
    private View brailleDotTandaBaca2;
    private View brailleDotTandaBaca3;
    private View brailleDotTandaBaca4;
    private View brailleDotTandaBaca5;
    private View brailleDotTandaBaca6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penggabungan_detail);

        initView();
        setupAppbar();

        presenter = new PenggabunganDetailPresenter(this);
        if (getIntent() != null && getIntent().getStringExtra("penggabungan") != null) {
            presenter.loadPenggabunganDetail(new Gson().fromJson(getIntent().getStringExtra("penggabungan"), PenggabunganModel.class));
        }
    }

    private void setupAppbar() {
        this.setTitle("Detail Braille");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        imagePenggabungan = findViewById(R.id.penggabungandetail_imageview_penggabungan);
        namePenggabungan = findViewById(R.id.penggabungandetail_textview_nama_simbol);
        spellPenggabungan = findViewById(R.id.penggabungandetail_textview_cara_baca_simbol);
        buttonCariHukumBacaan = findViewById(R.id.penggabungandetail_button_tombol_cari_hukum_bacaan);
        brailleDotHijaiyah1 = findViewById(R.id.penggabungandetail_titik_braille_hijaiyah_1);
        brailleDotHijaiyah2 = findViewById(R.id.penggabungandetail_titik_braille_hijaiyah_2);
        brailleDotHijaiyah3 = findViewById(R.id.penggabungandetail_titik_braille_hijaiyah_3);
        brailleDotHijaiyah4 = findViewById(R.id.penggabungandetail_titik_braille_hijaiyah_4);
        brailleDotHijaiyah5 = findViewById(R.id.penggabungandetail_titik_braille_hijaiyah_5);
        brailleDotHijaiyah6 = findViewById(R.id.penggabungandetail_titik_braille_hijaiyah_6);
        brailleDotTandaBaca1 = findViewById(R.id.penggabungandetail_titik_braille_tandabaca_1);
        brailleDotTandaBaca2 = findViewById(R.id.penggabungandetail_titik_braille_tandabaca_2);
        brailleDotTandaBaca3 = findViewById(R.id.penggabungandetail_titik_braille_tandabaca_3);
        brailleDotTandaBaca4 = findViewById(R.id.penggabungandetail_titik_braille_tandabaca_4);
        brailleDotTandaBaca5 = findViewById(R.id.penggabungandetail_titik_braille_tandabaca_5);
        brailleDotTandaBaca6 = findViewById(R.id.penggabungandetail_titik_braille_tandabaca_6);
        Drawable drawable = PenggabunganDetailActivity.this.getResources().getDrawable(R.drawable.ic_google);
        drawable.setBounds(0, 0, 40, 40);
        buttonCariHukumBacaan.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void showPenggabunganDetail(PenggabunganModel penggabunganModel) {
        if(penggabunganModel.getListBrailleDotsHijaiyah().get(0) == 1){
            brailleDotHijaiyah1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsHijaiyah().get(1) == 1){
            brailleDotHijaiyah2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsHijaiyah().get(2) == 1){
            brailleDotHijaiyah3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsHijaiyah().get(3) == 1){
            brailleDotHijaiyah4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsHijaiyah().get(4) == 1){
            brailleDotHijaiyah5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsHijaiyah().get(5) == 1){
            brailleDotHijaiyah6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }
        if(penggabunganModel.getListBrailleDotsTandaBaca().get(0) == 1){
            brailleDotTandaBaca1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsTandaBaca().get(1) == 1){
            brailleDotTandaBaca2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsTandaBaca().get(2) == 1){
            brailleDotTandaBaca3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsTandaBaca().get(3) == 1){
            brailleDotTandaBaca4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsTandaBaca().get(4) == 1){
            brailleDotTandaBaca5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(penggabunganModel.getListBrailleDotsTandaBaca().get(5) == 1){
            brailleDotTandaBaca6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }
        imagePenggabungan.setImageResource(penggabunganModel.getImagePenggabungan());
        namePenggabungan.setText(penggabunganModel.getNamePenggabungan());
        spellPenggabungan.setText(penggabunganModel.getSpellPenggabungan());
    }

    @Override
    public Context getContext() {
        return PenggabunganDetailActivity.this;
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
