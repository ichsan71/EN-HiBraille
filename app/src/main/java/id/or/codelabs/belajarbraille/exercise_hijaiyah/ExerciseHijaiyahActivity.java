package id.or.codelabs.belajarbraille.exercise_hijaiyah;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.Utility;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;


public class ExerciseHijaiyahActivity extends AppCompatActivity implements ExerciseHijaiyahContract.View{

    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;
    private List<String> listRightAnswer = new ArrayList<>();
    private int countActivity = 0;
    private ExerciseHijaiyahContract.Presenter presenter;
    private ImageView imageHijaiyah;
    private TextView nameHijaiyah;
    private ImageButton buttonSpeechRecognizer;
    private List<HijaiyahModel> listHijaiyah;
    private Button buttonNextSymbol;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Utility.getTheme(ExerciseHijaiyahActivity.this).trim().equals("Tema Default")){
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.GreenTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_hijaiyah);

        initView();
        setupToolbar();

        presenter = new ExerciseHijaiyahPresenter(this);
        presenter.start();

        buttonSpeechRecognizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputVoiceDialog();
            }
        });

        buttonNextSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSymbol();
            }
        });
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar_latihan_hijaiyah);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Latihan Braille Hijaiyah");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        imageHijaiyah = findViewById(R.id.latihanhijaiyah_imageview_hijaiyah);
//        nameHijaiyah = findViewById(R.id.latihanhijaiyah_textview_nama_simbol);
        buttonSpeechRecognizer = findViewById(R.id.latihanhijaiyah_button_pesan_suara);
        buttonNextSymbol = findViewById(R.id.latihanhijaiyah_button_simbol_lain);
    }

    private void showInputVoiceDialog() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ID");
        try {
            startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Perangkatmu tidak mendukung fitur ini.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case VOICE_RECOGNITION_REQUEST_CODE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Toast.makeText(getApplicationContext(), result.get(0), Toast.LENGTH_SHORT).show();
                    int countRightAnswer = 0;
                    if (!result.isEmpty()) {
                        for (int i = 0; i <= result.size() - 1; i++) {
                            for (int j = 0; j <= listRightAnswer.size() - 1; j++) {
                                if (result.get(i).contains(listRightAnswer.get(j))) {
                                    Log.e("hasil", result.get(i));
                                    countRightAnswer++;
                                }
                            }
                        }
                        Log.e("jumlah count", String.valueOf(countRightAnswer));
                        Log.e("jumlah list", String.valueOf(listRightAnswer.size()));
                        if (countRightAnswer == listRightAnswer.size()) {
                            //Toast.makeText(getApplicationContext(), "Jawaban Benar", Toast.LENGTH_LONG).show();
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle("Selamat!");
                            builder.setMessage("Jawabanmu benar. Ketuk dua kali pada tombol Lanjutkan untuk melanjutkan latihan.");
                            builder.setPositiveButton("Lanjutkan", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    changeSymbol();
                                }
                            });
                            // create and show the alert dialog
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        } else {
                            //Toast.makeText(getApplicationContext(), "Jawaban Salah", Toast.LENGTH_LONG).show();
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle("Sayang Sekali,");
                            builder.setMessage("Jawabanmu belum benar. Silahkan coba lagi.");
                            builder.setPositiveButton("Lanjutkan", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    changeSymbol();
                                }
                            });
                            builder.setNegativeButton("Coba Lagi", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            // create and show the alert dialog
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    }
                } else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
                    showToastMessage("Error audio.");
                } else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
                    showToastMessage("Error client.");
                } else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
                    showToastMessage("Periksa koneksi internet perangkatmu.");
                } else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
                    showToastMessage("Tidak ditemukan jawaban.");
                } else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
                    showToastMessage("Error server.");
                }
                break;
            }

        }
    }

    private void changeSymbol() {
        countActivity++;
        listRightAnswer.clear();
        addRightAnswer();
    }

    private void showToastMessage(String message) {
        Toast.makeText(ExerciseHijaiyahActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showHijaiyahData(List<HijaiyahModel> hijaiyahDataSet) {
        //Get right answer
        listHijaiyah = hijaiyahDataSet;
        addRightAnswer();
    }

    private void addRightAnswer() {
        if(listHijaiyah.get(countActivity).getListBrailleDots().get(0) == 1){
            listRightAnswer.add("satu");
        }if(listHijaiyah.get(countActivity).getListBrailleDots().get(1) == 1){
            listRightAnswer.add("dua");
        }if(listHijaiyah.get(countActivity).getListBrailleDots().get(2) == 1){
            listRightAnswer.add("tiga");
        }if(listHijaiyah.get(countActivity).getListBrailleDots().get(3) == 1){
            listRightAnswer.add("empat");
        }if(listHijaiyah.get(countActivity).getListBrailleDots().get(4) == 1){
            listRightAnswer.add("lima");
        }if(listHijaiyah.get(countActivity).getListBrailleDots().get(5) == 1){
            listRightAnswer.add("enam");
        }
        imageHijaiyah.setImageResource(listHijaiyah.get(countActivity).getImageHijaiyah());
        imageHijaiyah.setContentDescription(listHijaiyah.get(countActivity).getNameHijaiyah() + "."
        + getString(R.string.exercise_question));
        //nameHijaiyah.setText(listHijaiyah.get(countActivity).getNameHijaiyah());
    }

    @Override
    public Context getContext() {
        return ExerciseHijaiyahActivity.this;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
