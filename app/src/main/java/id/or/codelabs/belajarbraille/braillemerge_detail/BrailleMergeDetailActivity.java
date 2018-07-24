package id.or.codelabs.belajarbraille.braillemerge_detail;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class BrailleMergeDetailActivity extends AppCompatActivity implements BrailleMergeDetailContract.View{

    private BrailleMergeDetailPresenter presenter;
    private ImageView imagePenggabungan;
    private TextView namePenggabungan;
    private TextView spellPenggabungan;
    private Button buttonCariHukumBacaan;
    private LinearLayout layoutBrailleDotHijaiyah;
    private LinearLayout layoutBrailleDotTandaBaca;
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
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utility.getTheme(BrailleMergeDetailActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GoogleTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braille_merge_detail);

        initView();
        setupAppbar();

        presenter = new BrailleMergeDetailPresenter(this);
        if (getIntent() != null && getIntent().getStringExtra("penggabungan") != null) {
            presenter.loadPenggabunganDetail(new Gson().fromJson(getIntent().getStringExtra("penggabungan"), PenggabunganModel.class));
        }
    }

    private void setupAppbar() {
        toolbar = findViewById(R.id.toolbar_braillemerge_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        imagePenggabungan = findViewById(R.id.braillemergedetail_imageview_braillemerge);
        namePenggabungan = findViewById(R.id.braillemergedetail_textview_symbol_name);
        spellPenggabungan = findViewById(R.id.braillemergedetail_textview_symbol_spell);
        layoutBrailleDotHijaiyah = findViewById(R.id.braillemergedetail_linearlayout_braille_dots_hijaiyah);
        layoutBrailleDotTandaBaca = findViewById(R.id.braillemergedetail_linearlayout_braille_dots_punctuation);
        buttonCariHukumBacaan = findViewById(R.id.braillemergedetail_button_find_reading_law);
        brailleDotHijaiyah1 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_1);
        brailleDotHijaiyah2 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_2);
        brailleDotHijaiyah3 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_3);
        brailleDotHijaiyah4 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_4);
        brailleDotHijaiyah5 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_5);
        brailleDotHijaiyah6 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_6);
        brailleDotTandaBaca1 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_1);
        brailleDotTandaBaca2 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_2);
        brailleDotTandaBaca3 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_3);
        brailleDotTandaBaca4 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_4);
        brailleDotTandaBaca5 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_5);
        brailleDotTandaBaca6 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_6);
        Drawable drawable = BrailleMergeDetailActivity.this.getResources().getDrawable(R.drawable.ic_google);
        drawable.setBounds(0, 0, 40, 40);
        buttonCariHukumBacaan.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void showPenggabunganDetail(final PenggabunganModel penggabunganModel) {
        if(penggabunganModel.getListBrailleDotsHijaiyah().get(0) == 1){
            brailleDotHijaiyah1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah1.setContentDescription("Titik Braille " + penggabunganModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah1.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsHijaiyah().get(1) == 1){
            brailleDotHijaiyah2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah2.setContentDescription("Titik Braille " + penggabunganModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah2.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsHijaiyah().get(2) == 1){
            brailleDotHijaiyah3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah3.setContentDescription("Titik Braille " + penggabunganModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah3.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsHijaiyah().get(3) == 1){
            brailleDotHijaiyah4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah4.setContentDescription("Titik Braille " + penggabunganModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah4.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsHijaiyah().get(4) == 1){
            brailleDotHijaiyah5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah5.setContentDescription("Titik Braille " + penggabunganModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah5.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsHijaiyah().get(5) == 1){
            brailleDotHijaiyah6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah6.setContentDescription("Titik Braille " + penggabunganModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah6.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsTandaBaca().get(0) == 1){
            brailleDotTandaBaca1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotTandaBaca1.setContentDescription("Titik Braille " + penggabunganModel.getNameTandaBaca());
        } else {
            brailleDotTandaBaca1.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsTandaBaca().get(1) == 1){
            brailleDotTandaBaca2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotTandaBaca2.setContentDescription("Titik Braille " + penggabunganModel.getNameTandaBaca());
        } else {
            brailleDotTandaBaca2.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsTandaBaca().get(2) == 1){
            brailleDotTandaBaca3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotTandaBaca3.setContentDescription("Titik Braille " + penggabunganModel.getNameTandaBaca());
        } else {
            brailleDotTandaBaca3.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsTandaBaca().get(3) == 1){
            brailleDotTandaBaca4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotTandaBaca4.setContentDescription("Titik Braille " + penggabunganModel.getNameTandaBaca());
        } else {
            brailleDotTandaBaca4.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsTandaBaca().get(4) == 1){
            brailleDotTandaBaca5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotTandaBaca5.setContentDescription("Titik Braille " + penggabunganModel.getNameTandaBaca());
        } else {
            brailleDotTandaBaca5.setContentDescription("Bukan Titik ");
        }
        if(penggabunganModel.getListBrailleDotsTandaBaca().get(5) == 1){
            brailleDotTandaBaca6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotTandaBaca6.setContentDescription("Titik Braille " + penggabunganModel.getNameTandaBaca());
        } else {
            brailleDotTandaBaca6.setContentDescription("Bukan Titik ");
        }
        imagePenggabungan.setImageResource(penggabunganModel.getImagePenggabungan());
        namePenggabungan.setText(penggabunganModel.getNamePenggabungan());
        spellPenggabungan.setText(penggabunganModel.getSpellPenggabungan());
        layoutBrailleDotHijaiyah.setContentDescription("Titik-titik Braille " + penggabunganModel.getNameHijaiyah());
        layoutBrailleDotTandaBaca.setContentDescription("Titik-titik Braille " + penggabunganModel.getNameTandaBaca());
        getSupportActionBar().setTitle("Detail Braille " + penggabunganModel.getNamePenggabungan());
        buttonCariHukumBacaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "hukum bacaan " + penggabunganModel.getNamePenggabungan();
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
        return BrailleMergeDetailActivity.this;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
