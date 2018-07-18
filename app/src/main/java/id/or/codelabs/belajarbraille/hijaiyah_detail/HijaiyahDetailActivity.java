package id.or.codelabs.belajarbraille.hijaiyah_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
    private Toolbar toolbar;

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
        toolbar = findViewById(R.id.toolbar_hijaiyah_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public void showHijaiyahDetail(final HijaiyahModel hijaiyahModel) {
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
        getSupportActionBar().setTitle("Detail Braille " + hijaiyahModel.getNameHijaiyah());
        buttonCariHukumBacaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String query = "hukum bacaan " + hijaiyahModel.getNameHijaiyah();
                 String escapedQuery = null;
                 try {
                     escapedQuery = URLEncoder.encode(query, "UTF-8");
                 } catch (UnsupportedEncodingException e) {
                     e.printStackTrace();
                 }
                 Uri uri = Uri.parse("http://www.google.com/#q=" + escapedQuery);
                 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(intent);
            }
        });
    }

    @Override
    public Context getContext() {
        return HijaiyahDetailActivity.this;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }
}
