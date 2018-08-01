package id.or.codelabs.belajarbraille.exercise_punctuation;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.PunctuationModel;

public class ExercisePunctuationPresenter implements ExercisePunctuationContract.Presenter{

    List<PunctuationModel> punctuationDataSet = new ArrayList<>();
    private final ExercisePunctuationContract.View latihanPunctuationView;

    public ExercisePunctuationPresenter(ExercisePunctuationContract.View latihanPunctuationView) {
        this.latihanPunctuationView = latihanPunctuationView;
    }

    @Override
    public void loadPunctuationData() {
        List<Integer> listBrailleDots = new ArrayList<>();
        listBrailleDots.add(0);
        listBrailleDots.add(1);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        punctuationDataSet.add(new PunctuationModel(R.drawable.fathah,"Fathah",
                "titik braille nomor 2", listBrailleDots));
        List<Integer> listBrailleDots2 = new ArrayList<>();
        listBrailleDots2.add(1);
        listBrailleDots2.add(0);
        listBrailleDots2.add(0);
        listBrailleDots2.add(0);
        listBrailleDots2.add(1);
        listBrailleDots2.add(0);
        punctuationDataSet.add(new PunctuationModel(R.drawable.kasroh,"Kasroh",
                "titik braille nomor 1, dan 5", listBrailleDots2));
        List<Integer> listBrailleDots3 = new ArrayList<>();
        listBrailleDots3.add(1);
        listBrailleDots3.add(0);
        listBrailleDots3.add(1);
        listBrailleDots3.add(0);
        listBrailleDots3.add(0);
        listBrailleDots3.add(1);
        punctuationDataSet.add(new PunctuationModel(R.drawable.dhomah,"Dhomah",
                "titik braille nomor 1, 3, dan 6", listBrailleDots3));
        List<Integer> listBrailleDots4 = new ArrayList<>();
        listBrailleDots4.add(0);
        listBrailleDots4.add(1);
        listBrailleDots4.add(1);
        listBrailleDots4.add(0);
        listBrailleDots4.add(0);
        listBrailleDots4.add(0);
        punctuationDataSet.add(new PunctuationModel(R.drawable.fathah_tanwin,"Fathah Tanwin",
                "titik braille nomor 2 dan 3", listBrailleDots4));
        List<Integer> listBrailleDots5 = new ArrayList<>();
        listBrailleDots5.add(0);
        listBrailleDots5.add(0);
        listBrailleDots5.add(1);
        listBrailleDots5.add(0);
        listBrailleDots5.add(1);
        listBrailleDots5.add(0);
        punctuationDataSet.add(new PunctuationModel(R.drawable.kasroh_tanwin,"Kasroh Tanwin",
                "titik braille nomor 3, dan 5", listBrailleDots5));
        List<Integer> listBrailleDots6 = new ArrayList<>();
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(1);
        punctuationDataSet.add(new PunctuationModel(R.drawable.tasydid,"Tasydid",
                "titik braille nomor 6", listBrailleDots6));
        latihanPunctuationView.showPunctuationData(punctuationDataSet);
    }

    @Override
    public void start() {
        loadPunctuationData();
    }
}
