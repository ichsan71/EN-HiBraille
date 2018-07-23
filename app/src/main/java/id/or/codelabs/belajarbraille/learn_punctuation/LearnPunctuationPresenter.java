package id.or.codelabs.belajarbraille.learn_punctuation;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class LearnPunctuationPresenter implements LearnPunctuationContract.Presenter {

    List<TandaBacaModel> tandaBacaDataSet = new ArrayList<>();
    private final LearnPunctuationContract.View belajarTandaBacaView;

    public LearnPunctuationPresenter(LearnPunctuationContract.View belajarTandaBacaView) {
        this.belajarTandaBacaView = belajarTandaBacaView;
    }

    @Override
    public void start() {
        loadTandaBacaData();
    }

    @Override
    public void loadTandaBacaData() {
        List<Integer> listBrailleDots = new ArrayList<>();
        listBrailleDots.add(0);
        listBrailleDots.add(1);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.fathah,"Fathah",
                "Titik braille nomor 2", listBrailleDots));
        List<Integer> listBrailleDots2 = new ArrayList<>();
        listBrailleDots2.add(1);
        listBrailleDots2.add(0);
        listBrailleDots2.add(0);
        listBrailleDots2.add(0);
        listBrailleDots2.add(1);
        listBrailleDots2.add(0);
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.kasroh,"Kasroh",
                "Titik braille nomor 1, dan 5", listBrailleDots2));
        List<Integer> listBrailleDots3 = new ArrayList<>();
        listBrailleDots3.add(1);
        listBrailleDots3.add(0);
        listBrailleDots3.add(1);
        listBrailleDots3.add(0);
        listBrailleDots3.add(0);
        listBrailleDots3.add(1);
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.dhomah,"Dhomah",
                "Titik braille nomor 1, 3, dan 6", listBrailleDots3));
        List<Integer> listBrailleDots4 = new ArrayList<>();
        listBrailleDots4.add(0);
        listBrailleDots4.add(1);
        listBrailleDots4.add(1);
        listBrailleDots4.add(0);
        listBrailleDots4.add(0);
        listBrailleDots4.add(0);
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.fathah_tanwin,"Fathah Tanwin",
                "Titik braille nomor 2 dan 3", listBrailleDots4));
        List<Integer> listBrailleDots5 = new ArrayList<>();
        listBrailleDots5.add(0);
        listBrailleDots5.add(0);
        listBrailleDots5.add(1);
        listBrailleDots5.add(0);
        listBrailleDots5.add(1);
        listBrailleDots5.add(0);
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.kasroh_tanwin,"Kasroh Tanwin",
                "Titik braille nomor 3, dan 5", listBrailleDots5));
        List<Integer> listBrailleDots6 = new ArrayList<>();
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(1);
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.tasydid,"Tasydid",
                "Titik braille nomor 6", listBrailleDots6));
        belajarTandaBacaView.showTandaBacaData(tandaBacaDataSet);
    }
}
