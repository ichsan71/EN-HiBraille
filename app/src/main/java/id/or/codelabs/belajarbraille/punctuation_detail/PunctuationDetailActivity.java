package id.or.codelabs.belajarbraille.punctuation_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

public class PunctuationDetailActivity extends AppCompatActivity implements PunctuationDetailContract.View{

    private PunctuationDetailContract.Presenter presenter;
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
        if(Utility.getTheme(PunctuationDetailActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GreenTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punctuation_detail);

        initView();
        setupAppbar();

        presenter = new PunctuationDetailPresenter(this);
        if (getIntent() != null && getIntent().getStringExtra("tanda-baca") != null) {
            presenter.loadTandaBacaDetail(new Gson().fromJson(getIntent().getStringExtra("tanda-baca"), TandaBacaModel.class));
        }
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_punctuation_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupAppbar() {
        imageTandaBaca = findViewById(R.id.punctuationdetail_imageview_punctuation);
//        nameTandaBaca = findViewById(R.id.punctuationdetail_textview_symbol_name);
        buttonCariHukumBacaan = findViewById(R.id.punctuationdetail_button_find_reading_law);
        brailleDot1 = findViewById(R.id.punctuationdetail_braille_dot_1);
        brailleDot2 = findViewById(R.id.punctuationdetail_braille_dot_2);
        brailleDot3 = findViewById(R.id.punctuationdetail_braille_dot_3);
        brailleDot4 = findViewById(R.id.punctuationdetail_braille_dot_4);
        brailleDot5 = findViewById(R.id.punctuationdetail_braille_dot_5);
        brailleDot6 = findViewById(R.id.punctuationdetail_braille_dot_6);
        Drawable drawable = PunctuationDetailActivity.this.getResources().getDrawable(R.drawable.ic_google);
        drawable.setBounds(0, 0, 40, 40);
        buttonCariHukumBacaan.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void showTandaBacaDetail(final TandaBacaModel tandaBacaModel) {
        if(tandaBacaModel.getListBrailleDots().get(0) == 1){
            brailleDot1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDot1.setContentDescription("Titik Braille " + tandaBacaModel.getNameTandaBaca());
        } else {
            brailleDot1.setContentDescription("Bukan Titik ");
        }
        if(tandaBacaModel.getListBrailleDots().get(1) == 1){
            brailleDot2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDot2.setContentDescription("Titik Braille " + tandaBacaModel.getNameTandaBaca());
        } else {
            brailleDot2.setContentDescription("Bukan Titik ");
        }
        if(tandaBacaModel.getListBrailleDots().get(2) == 1){
            brailleDot3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDot3.setContentDescription("Titik Braille " + tandaBacaModel.getNameTandaBaca());
        } else {
            brailleDot3.setContentDescription("Bukan Titik ");
        }
        if(tandaBacaModel.getListBrailleDots().get(3) == 1){
            brailleDot4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDot4.setContentDescription("Titik Braille " + tandaBacaModel.getNameTandaBaca());
        } else {
            brailleDot4.setContentDescription("Bukan Titik ");
        }
        if(tandaBacaModel.getListBrailleDots().get(4) == 1){
            brailleDot5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDot5.setContentDescription("Titik Braille " + tandaBacaModel.getNameTandaBaca());
        } else {
            brailleDot5.setContentDescription("Bukan Titik ");
        }
        if(tandaBacaModel.getListBrailleDots().get(5) == 1){
            brailleDot6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDot6.setContentDescription("Titik Braille " + tandaBacaModel.getNameTandaBaca());
        } else {
            brailleDot6.setContentDescription("Bukan Titik ");
        }
        imageTandaBaca.setImageResource(tandaBacaModel.getImageTandaBaca());
        imageTandaBaca.setContentDescription(tandaBacaModel.getNameTandaBaca() + "." + getString(R.string.punctuation_detail_guide) + ".");
        //nameTandaBaca.setText(tandaBacaModel.getNameTandaBaca());
        getSupportActionBar().setTitle("Detail Braille " + tandaBacaModel.getNameTandaBaca());
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
        return PunctuationDetailActivity.this;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
