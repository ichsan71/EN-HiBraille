package id.or.codelabs.belajarbraille.tandabaca_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

public class TandaBacaDetailActivity extends AppCompatActivity implements TandaBacaDetailContract.View{

    private TandaBacaDetailContract.Presenter presenter;
    private ImageView imageTandaBaca;
    private TextView nameTandaBaca;
    private Button buttonCariHukumBacaan;
    private View brailleDot1;
    private View brailleDot2;
    private View brailleDot3;
    private View brailleDot4;
    private View brailleDot5;
    private View brailleDot6;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanda_baca_detail);

        initView();
        setupAppbar();

        presenter = new TandaBacaDetailPresenter(this);
        if (getIntent() != null && getIntent().getStringExtra("tanda-baca") != null) {
            presenter.loadTandaBacaDetail(new Gson().fromJson(getIntent().getStringExtra("tanda-baca"), TandaBacaModel.class));
        }
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_tanda_baca_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail Braille");
    }

    private void setupAppbar() {
        imageTandaBaca = findViewById(R.id.tandabacadetail_imageview_tandabaca);
        nameTandaBaca = findViewById(R.id.tandabacadetail_textview_nama_simbol);
        buttonCariHukumBacaan = findViewById(R.id.tandabacadetail_button_tombol_cari_hukum_bacaan);
        brailleDot1 = findViewById(R.id.tandabacadetail_titik_braille_1);
        brailleDot2 = findViewById(R.id.tandabacadetail_titik_braille_2);
        brailleDot3 = findViewById(R.id.tandabacadetail_titik_braille_3);
        brailleDot4 = findViewById(R.id.tandabacadetail_titik_braille_4);
        brailleDot5 = findViewById(R.id.tandabacadetail_titik_braille_5);
        brailleDot6 = findViewById(R.id.tandabacadetail_titik_braille_6);
        Drawable drawable = TandaBacaDetailActivity.this.getResources().getDrawable(R.drawable.ic_google);
        drawable.setBounds(0, 0, 40, 40);
        buttonCariHukumBacaan.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void showTandaBacaDetail(final TandaBacaModel tandaBacaModel) {
        if(tandaBacaModel.getListBrailleDots().get(0) == 1){
            brailleDot1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(tandaBacaModel.getListBrailleDots().get(1) == 1){
            brailleDot2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(tandaBacaModel.getListBrailleDots().get(2) == 1){
            brailleDot3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(tandaBacaModel.getListBrailleDots().get(3) == 1){
            brailleDot4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(tandaBacaModel.getListBrailleDots().get(4) == 1){
            brailleDot5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }if(tandaBacaModel.getListBrailleDots().get(5) == 1){
            brailleDot6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
        }
        imageTandaBaca.setImageResource(tandaBacaModel.getImageTandaBaca());
        nameTandaBaca.setText(tandaBacaModel.getNameTandaBaca());
        buttonCariHukumBacaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "hukum bacaan " + tandaBacaModel.getNameTandaBaca();
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
        return TandaBacaDetailActivity.this;
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
