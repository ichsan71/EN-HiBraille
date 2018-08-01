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

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.data.BrailleMergeModel;

public class BrailleMergeDetailActivity extends AppCompatActivity implements BrailleMergeDetailContract.View{

    private BrailleMergeDetailPresenter presenter;
    private ImageView imageBrailleMerge;
    private Button buttonFindReadingLaw;
    private LinearLayout layoutBrailleDotHijaiyah;
    private LinearLayout layoutBrailleDotPunctuation;
    private View brailleDotHijaiyah1;
    private View brailleDotHijaiyah2;
    private View brailleDotHijaiyah3;
    private View brailleDotHijaiyah4;
    private View brailleDotHijaiyah5;
    private View brailleDotHijaiyah6;
    private View brailleDotPunctuation1;
    private View brailleDotPunctuation2;
    private View brailleDotPunctuation3;
    private View brailleDotPunctuation4;
    private View brailleDotPunctuation5;
    private View brailleDotPunctuation6;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utility.getTheme(BrailleMergeDetailActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GreenTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braille_merge_detail);

        initView();
        setupAppbar();

        presenter = new BrailleMergeDetailPresenter(this);
        if (getIntent() != null && getIntent().getStringExtra("braille-merge") != null) {
            presenter.loadBrailleMergeDetail(new Gson().fromJson(getIntent().getStringExtra("braille-merge"), BrailleMergeModel.class));
        }
    }

    private void setupAppbar() {
        toolbar = findViewById(R.id.toolbar_braillemerge_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeActionContentDescription("Navigasi Kembali");
    }

    private void initView() {
        imageBrailleMerge = findViewById(R.id.braillemergedetail_imageview_braillemerge);
        layoutBrailleDotHijaiyah = findViewById(R.id.braillemergedetail_linearlayout_braille_dots_hijaiyah);
        layoutBrailleDotPunctuation = findViewById(R.id.braillemergedetail_linearlayout_braille_dots_punctuation);
        buttonFindReadingLaw = findViewById(R.id.braillemergedetail_button_find_reading_law);
        brailleDotHijaiyah1 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_1);
        brailleDotHijaiyah2 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_2);
        brailleDotHijaiyah3 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_3);
        brailleDotHijaiyah4 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_4);
        brailleDotHijaiyah5 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_5);
        brailleDotHijaiyah6 = findViewById(R.id.braillemergedetail_braille_dot_hijaiyah_6);
        brailleDotPunctuation1 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_1);
        brailleDotPunctuation2 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_2);
        brailleDotPunctuation3 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_3);
        brailleDotPunctuation4 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_4);
        brailleDotPunctuation5 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_5);
        brailleDotPunctuation6 = findViewById(R.id.braillemergedetail_braille_dot_punctuation_6);
        Drawable drawable = BrailleMergeDetailActivity.this.getResources().getDrawable(R.drawable.ic_google);
        drawable.setBounds(0, 0, 40, 40);
        buttonFindReadingLaw.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void showBrailleMergeDetail(final BrailleMergeModel brailleMergeModel) {
        if(brailleMergeModel.getListBrailleDotsHijaiyah().get(0) == 1){
            brailleDotHijaiyah1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah1.setContentDescription("Titik Braille " + brailleMergeModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah1.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsHijaiyah().get(1) == 1){
            brailleDotHijaiyah2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah2.setContentDescription("Titik Braille " + brailleMergeModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah2.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsHijaiyah().get(2) == 1){
            brailleDotHijaiyah3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah3.setContentDescription("Titik Braille " + brailleMergeModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah3.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsHijaiyah().get(3) == 1){
            brailleDotHijaiyah4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah4.setContentDescription("Titik Braille " + brailleMergeModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah4.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsHijaiyah().get(4) == 1){
            brailleDotHijaiyah5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah5.setContentDescription("Titik Braille " + brailleMergeModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah5.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsHijaiyah().get(5) == 1){
            brailleDotHijaiyah6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotHijaiyah6.setContentDescription("Titik Braille " + brailleMergeModel.getNameHijaiyah());
        } else {
            brailleDotHijaiyah6.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsPunctuation().get(0) == 1){
            brailleDotPunctuation1.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotPunctuation1.setContentDescription("Titik Braille " + brailleMergeModel.getNamePunctuation());
        } else {
            brailleDotPunctuation1.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsPunctuation().get(1) == 1){
            brailleDotPunctuation2.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotPunctuation2.setContentDescription("Titik Braille " + brailleMergeModel.getNamePunctuation());
        } else {
            brailleDotPunctuation2.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsPunctuation().get(2) == 1){
            brailleDotPunctuation3.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotPunctuation3.setContentDescription("Titik Braille " + brailleMergeModel.getNamePunctuation());
        } else {
            brailleDotPunctuation3.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsPunctuation().get(3) == 1){
            brailleDotPunctuation4.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotPunctuation4.setContentDescription("Titik Braille " + brailleMergeModel.getNamePunctuation());
        } else {
            brailleDotPunctuation4.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsPunctuation().get(4) == 1){
            brailleDotPunctuation5.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotPunctuation5.setContentDescription("Titik Braille " + brailleMergeModel.getNamePunctuation());
        } else {
            brailleDotPunctuation5.setContentDescription("Bukan Titik ");
        }
        if(brailleMergeModel.getListBrailleDotsPunctuation().get(5) == 1){
            brailleDotPunctuation6.setBackground(ContextCompat.getDrawable(this, R.drawable.active_braille_dot));
            brailleDotPunctuation6.setContentDescription("Titik Braille " + brailleMergeModel.getNamePunctuation());
        } else {
            brailleDotPunctuation6.setContentDescription("Bukan Titik ");
        }
        imageBrailleMerge.setImageResource(brailleMergeModel.getImageBrailleMerge());
        imageBrailleMerge.setContentDescription(brailleMergeModel.getNameBrailleMerge() + "." +
        brailleMergeModel.getSpellBrailleMerge() + "." + getString(R.string.braillemerge_detail_guide) + ".");
        layoutBrailleDotHijaiyah.setContentDescription("Titik-titik Braille " + brailleMergeModel.getNameHijaiyah());
        layoutBrailleDotPunctuation.setContentDescription("Titik-titik Braille " + brailleMergeModel.getNamePunctuation());
        getSupportActionBar().setTitle("Detail Braille " + brailleMergeModel.getNameBrailleMerge());
        toolbar.setContentDescription("Detail Braille " + brailleMergeModel.getNameBrailleMerge() + ". 16 Elemen Layar.");
        buttonFindReadingLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "hukum bacaan " + brailleMergeModel.getNameBrailleMerge();
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
