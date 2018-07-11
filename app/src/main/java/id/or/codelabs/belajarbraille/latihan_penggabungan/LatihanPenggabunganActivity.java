package id.or.codelabs.belajarbraille.latihan_penggabungan;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class LatihanPenggabunganActivity extends AppCompatActivity implements LatihanPenggabunganContract.View {

    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;
    private List<String> listRightAnswer = new ArrayList<>();
    private int countActivity = 0;
    private LatihanPenggabunganContract.Presenter presenter;
    private ImageView imagePenggabungan;
    private TextView namePenggabungan;
    private ImageButton buttonSpeechRecognizer;
    private List<PenggabunganModel> listPenggabungan;
    private Button buttonNextSymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_penggabungan);

        initView();
        setupToolbar();

        presenter = new LatihanPenggabunganPresenter(this);
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

    private void setupToolbar() {
        this.setTitle("Latihan Braille Penggabungan");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        imagePenggabungan = findViewById(R.id.latihanpenggabungan_imageview_penggabungan);
        namePenggabungan = findViewById(R.id.latihanpenggabungan_textview_nama_simbol);
        buttonSpeechRecognizer = findViewById(R.id.latihanpenggabungan_button_pesan_suara);
        buttonNextSymbol = findViewById(R.id.latihanpenggabungan_button_simbol_lain);
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
                            builder.setTitle("Selamat!");
                            builder.setMessage("Jawabanmu benar. Ketuk dua kali pada tombol Lanjutkan untuk melanjutkan latihan.");
                            builder.setPositiveButton("Lanjutkan", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    countActivity++;
                                    listRightAnswer.clear();
                                    addRightAnswer();
                                    finish();
                                }
                            });
                            builder.setNegativeButton("Coba Lagi", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
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

    private void addRightAnswer() {
        if(listPenggabungan.get(countActivity).getListBrailleDotsHijaiyah().get(0) == 1){
            listRightAnswer.add("satu");
        }if(listPenggabungan.get(countActivity).getListBrailleDotsHijaiyah().get(1) == 1){
            listRightAnswer.add("dua");
        }if(listPenggabungan.get(countActivity).getListBrailleDotsHijaiyah().get(2) == 1){
            listRightAnswer.add("tiga");
        }if(listPenggabungan.get(countActivity).getListBrailleDotsHijaiyah().get(3) == 1){
            listRightAnswer.add("empat");
        }if(listPenggabungan.get(countActivity).getListBrailleDotsHijaiyah().get(4) == 1){
            listRightAnswer.add("lima");
        }if(listPenggabungan.get(countActivity).getListBrailleDotsHijaiyah().get(5) == 1){
            listRightAnswer.add("enam");
        }

        imagePenggabungan.setImageResource(listPenggabungan.get(countActivity).getImagePenggabungan());
        namePenggabungan.setText(listPenggabungan.get(countActivity).getNamePenggabungan());
    }

    private void showToastMessage(String message) {
        Toast.makeText(LatihanPenggabunganActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPenggabunganData(List<PenggabunganModel> penggabunganDataSet) {
        //Get right answer
        listPenggabungan = penggabunganDataSet;
        addRightAnswer();
    }

    @Override
    public Context getContext() {
        return LatihanPenggabunganActivity.this;
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
