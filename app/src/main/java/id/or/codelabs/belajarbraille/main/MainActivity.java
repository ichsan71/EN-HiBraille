package id.or.codelabs.belajarbraille.main;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.ThemeSwitcherDialog;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.learn_hijaiyah.LearnHijaiyahActivity;
import id.or.codelabs.belajarbraille.learn_braillemerge.LearnBrailleMergeActivity;
import id.or.codelabs.belajarbraille.learn_punctuation.LearnPunctuationActivity;
import id.or.codelabs.belajarbraille.exercise_hijaiyah.ExerciseHijaiyahActivity;
import id.or.codelabs.belajarbraille.exercise_braillemerge.ExerciseBrailleMergeActivity;
import id.or.codelabs.belajarbraille.exercise_punctuation.ExercisePunctuationActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener{

    Toolbar toolbar;
    private CardView cvBelajarHijaiyah;
    private CardView cvBelajarTandaBaca;
    private CardView cvBelajarPenggabungan;
    private CardView cvLatihanHijaiyah;
    private CardView cvLatihanTandaBaca;
    private CardView cvLatihanPenggabungan;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AccessibilityManager manager = (AccessibilityManager) MainActivity.this
                .getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (manager.isEnabled()) {
            AccessibilityEvent e = AccessibilityEvent.obtain();
            e.setEventType(AccessibilityEvent.TYPE_ANNOUNCEMENT);
            e.setClassName(getClass().getName());
            e.setPackageName(MainActivity.this.getPackageName());
            e.getText().add("Bismillaahirrohmaanirrohiim.");
            manager.sendAccessibilityEvent(e);
        }

        if(Utility.getTheme(MainActivity.this) == null ||
                Utility.getTheme(MainActivity.this) == "Tema Default"){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GoogleTheme);
        }

        initView();
        setupToolbar();

        cvBelajarHijaiyah.setOnClickListener(this);
        cvBelajarTandaBaca.setOnClickListener(this);
        cvBelajarPenggabungan.setOnClickListener(this);
        cvLatihanHijaiyah.setOnClickListener(this);
        cvLatihanTandaBaca.setOnClickListener(this);
        cvLatihanPenggabungan.setOnClickListener(this);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Halaman Utama");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_setting:
                FragmentActivity activity = (FragmentActivity)(getContext());
                FragmentManager fm = activity.getSupportFragmentManager();
                ThemeSwitcherDialog alertDialog = new ThemeSwitcherDialog();
                alertDialog.show(fm, "fragment_alert");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        cvBelajarHijaiyah = findViewById(R.id.main_cardview_learn_hijaiyah);
        cvBelajarTandaBaca = findViewById(R.id.main_cardview_learn_punctuation);
        cvBelajarPenggabungan = findViewById(R.id.main_cardview_learn_braille_merge);
        cvLatihanHijaiyah = findViewById(R.id.main_cardview_exercise_hijaiyah);
        cvLatihanTandaBaca = findViewById(R.id.main_cardview_exercise_punctuation);
        cvLatihanPenggabungan = findViewById(R.id.main_cardview_exercise_braille_merge);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_cardview_learn_hijaiyah:
                showBelajarHijaiyahView();
                break;
            case R.id.main_cardview_learn_punctuation:
                showBelajarTandaBacaView();
                break;
            case R.id.main_cardview_learn_braille_merge:
                showBelajarPenggabunganView();
                break;
            case R.id.main_cardview_exercise_hijaiyah:
                showLatihanHijaiyahView();
                break;
            case R.id.main_cardview_exercise_punctuation:
                showLatihanTandaBacaView();
                break;
            case R.id.main_cardview_exercise_braille_merge:
                showLatihanPenggabunganView();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showBelajarHijaiyahView() {
        Intent intent = new Intent(MainActivity.this, LearnHijaiyahActivity.class);
        startActivity(intent);
    }

    @Override
    public void showBelajarTandaBacaView() {
        Intent intent = new Intent(MainActivity.this, LearnPunctuationActivity.class);
        startActivity(intent);
    }

    @Override
    public void showBelajarPenggabunganView() {
        Intent intent = new Intent(MainActivity.this, LearnBrailleMergeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanHijaiyahView() {
        Intent intent = new Intent(MainActivity.this, ExerciseHijaiyahActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanTandaBacaView() {
        Intent intent = new Intent(MainActivity.this, ExercisePunctuationActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLatihanPenggabunganView() {
        Intent intent = new Intent(MainActivity.this, ExerciseBrailleMergeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AccessibilityManager manager = (AccessibilityManager) MainActivity.this
                .getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (manager.isEnabled()) {
            AccessibilityEvent e = AccessibilityEvent.obtain();
            e.setEventType(AccessibilityEvent.TYPE_ANNOUNCEMENT);
            e.setClassName(getClass().getName());
            e.setPackageName(MainActivity.this.getPackageName());
            e.getText().add("Alhamdulillaahirobbilaalamiin.");
            manager.sendAccessibilityEvent(e);
        }

        super.onBackPressed();
    }
}
