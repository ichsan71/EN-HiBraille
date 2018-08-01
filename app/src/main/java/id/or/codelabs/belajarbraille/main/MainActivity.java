package id.or.codelabs.belajarbraille.main;

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
import id.or.codelabs.belajarbraille.exercise_braillemerge.ExerciseBrailleMergeActivity;
import id.or.codelabs.belajarbraille.exercise_hijaiyah.ExerciseHijaiyahActivity;
import id.or.codelabs.belajarbraille.exercise_punctuation.ExercisePunctuationActivity;
import id.or.codelabs.belajarbraille.learn_braillemerge.LearnBrailleMergeActivity;
import id.or.codelabs.belajarbraille.learn_hijaiyah.LearnHijaiyahActivity;
import id.or.codelabs.belajarbraille.learn_punctuation.LearnPunctuationActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener{

    Toolbar toolbar;
    private CardView cvLearnHijaiyah;
    private CardView cvLearnPunctuation;
    private CardView cvLearnBrailleMerge;
    private CardView cvExerciseHijaiyah;
    private CardView cvExercisePunctuation;
    private CardView cvExerciseBrailleMerge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utility.getTheme(MainActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GreenTheme);
        }

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

        initView();
        setupToolbar();

        cvLearnHijaiyah.setOnClickListener(this);
        cvLearnPunctuation.setOnClickListener(this);
        cvLearnBrailleMerge.setOnClickListener(this);
        cvExerciseHijaiyah.setOnClickListener(this);
        cvExercisePunctuation.setOnClickListener(this);
        cvExerciseBrailleMerge.setOnClickListener(this);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_main);
        toolbar.setContentDescription("Halaman Utama. 6 Menu.");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Halaman Utama");
        getSupportActionBar().setHomeActionContentDescription("Navigasi Kembali");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

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
        cvLearnHijaiyah = findViewById(R.id.main_cardview_learn_hijaiyah);
        cvLearnPunctuation = findViewById(R.id.main_cardview_learn_punctuation);
        cvLearnBrailleMerge = findViewById(R.id.main_cardview_learn_braille_merge);
        cvExerciseHijaiyah = findViewById(R.id.main_cardview_exercise_hijaiyah);
        cvExercisePunctuation = findViewById(R.id.main_cardview_exercise_punctuation);
        cvExerciseBrailleMerge = findViewById(R.id.main_cardview_exercise_braille_merge);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_cardview_learn_hijaiyah:
                showLearnHijaiyahView();
                break;
            case R.id.main_cardview_learn_punctuation:
                showLearnPunctuationView();
                break;
            case R.id.main_cardview_learn_braille_merge:
                showLearnBrailleMergeView();
                break;
            case R.id.main_cardview_exercise_hijaiyah:
                showExerciseHijaiyahView();
                break;
            case R.id.main_cardview_exercise_punctuation:
                showExercisePunctuationView();
                break;
            case R.id.main_cardview_exercise_braille_merge:
                showExerciseBrailleMergeView();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLearnHijaiyahView() {
        Intent intent = new Intent(MainActivity.this, LearnHijaiyahActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLearnPunctuationView() {
        Intent intent = new Intent(MainActivity.this, LearnPunctuationActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLearnBrailleMergeView() {
        Intent intent = new Intent(MainActivity.this, LearnBrailleMergeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showExerciseHijaiyahView() {
        Intent intent = new Intent(MainActivity.this, ExerciseHijaiyahActivity.class);
        startActivity(intent);
    }

    @Override
    public void showExercisePunctuationView() {
        Intent intent = new Intent(MainActivity.this, ExercisePunctuationActivity.class);
        startActivity(intent);
    }

    @Override
    public void showExerciseBrailleMergeView() {
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
