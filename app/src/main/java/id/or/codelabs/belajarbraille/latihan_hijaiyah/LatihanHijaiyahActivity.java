package id.or.codelabs.belajarbraille.latihan_hijaiyah;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;


public class LatihanHijaiyahActivity extends AppCompatActivity implements View.OnClickListener, LatihanHijaiyahContract.View{

    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;
    private List<String> listRightAnswer = new ArrayList<>();
    private int countActivity = 0;
    private LatihanHijaiyahContract.Presenter presenter;
    private ImageView imageHijaiyah;
    private TextView nameHijaiyah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_hijaiyah);

        initView();
        setupToolbar();

        presenter = new LatihanHijaiyahPresenter(this);
        presenter.start();
    }

    private void setupToolbar() {
        this.setTitle("Latihan Braille Hijaiyah");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        imageHijaiyah = findViewById(R.id.latihanhijaiyah_imageview_hijaiyah);
        nameHijaiyah = findViewById(R.id.latihanhijaiyah_textview_nama_simbol);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.latihanhijaiyah_framelayout_pesan_suara:
                speak();
                break;
            case R.id.latihanhijaiyah_button_simbol_lain:
                skipToNext();
                break;
        }
    }

    private void skipToNext() {

    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        // Specify the calling package to identify your application
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass()
                .getPackage().getName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //Start the Voice recognizer activity for the result.
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE)
            //If Voice recognition is successful then it returns RESULT_OK
            if (resultCode == RESULT_OK) {
                ArrayList<String> textMatchList = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                int countRightAnswer = 0;
                if (!textMatchList.isEmpty()) {
                    // If first Match contains the 'search' word
                    // Then start web search.
                    for (int i = 0; i <= textMatchList.size() - 1; i++) {
                        for (int j = 0; j <= listRightAnswer.size() - 1; j++) {
                            if (textMatchList.get(i).contains(listRightAnswer.get(j))) {
                                countRightAnswer++;
                            }
                        }
                    }
                    if (countRightAnswer == listRightAnswer.size()){
                        //show dialog
                        Toast.makeText(getApplicationContext(), "Jawaban Benar", Toast.LENGTH_LONG).show();
                        countActivity++;
                    } else {
                        Toast.makeText(getApplicationContext(), "Jawaban Salah", Toast.LENGTH_LONG).show();
                    }
                    //Result code for various error.
                } else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
                    showToastMessage("Audio Error");
                } else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
                    showToastMessage("Client Error");
                } else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
                    showToastMessage("Network Error");
                } else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
                    showToastMessage("No Match");
                } else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
                    showToastMessage("Server Error");
                }
                super.onActivityResult(requestCode, resultCode, data);
            }
    }

    private void showToastMessage(String message) {
        Toast.makeText(LatihanHijaiyahActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showHijaiyahData(List<HijaiyahModel> hijaiyahDataSet) {
        //Get right answer
        if(hijaiyahDataSet.get(countActivity).getListBrailleDots().get(0) == 1){
            listRightAnswer.add("satu");
        }if(hijaiyahDataSet.get(countActivity).getListBrailleDots().get(1) == 1){
            listRightAnswer.add("dua");
        }if(hijaiyahDataSet.get(countActivity).getListBrailleDots().get(2) == 1){
            listRightAnswer.add("tiga");
        }if(hijaiyahDataSet.get(countActivity).getListBrailleDots().get(3) == 1){
            listRightAnswer.add("empat");
        }if(hijaiyahDataSet.get(countActivity).getListBrailleDots().get(4) == 1){
            listRightAnswer.add("lima");
        }if(hijaiyahDataSet.get(countActivity).getListBrailleDots().get(5) == 1){
            listRightAnswer.add("enam");
        }
        imageHijaiyah.setImageResource(hijaiyahDataSet.get(countActivity).getImageHijaiyah());
        nameHijaiyah.setText(hijaiyahDataSet.get(countActivity).getNameHijaiyah());
    }

    @Override
    public Context getContext() {
        return LatihanHijaiyahActivity.this;
    }
}
