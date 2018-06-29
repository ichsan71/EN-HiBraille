package id.or.codelabs.belajarbraille.belajar_tandabaca;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class BelajarTandaBacaPresenter implements BelajarTandaBacaContract.Presenter {

    List<TandaBacaModel> tandaBacaDataSet = new ArrayList<>();
    private final BelajarTandaBacaContract.View belajarTandaBacaView;

    public BelajarTandaBacaPresenter(BelajarTandaBacaContract.View belajarTandaBacaView) {
        this.belajarTandaBacaView = belajarTandaBacaView;
    }

    @Override
    public void start() {
        loadTandaBacaData();
    }

    @Override
    public void loadTandaBacaData() {
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.fathah,"Fathah",
                "Titik braille nomor 2"));
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.kasroh,"Kasroh",
                "Titik braille nomor 1, dan 5"));
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.dhomah,"Dhomah",
                "Titik braille nomor 1, 3, dan 6"));
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.fathah_tanwin,"Fathah Tanwin",
                "Titik braille nomor 2 dan 3"));
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.kasroh_tanwin,"Kasroh Tanwin",
                "Titik braille nomor 3, dan 5"));
        tandaBacaDataSet.add(new TandaBacaModel(R.drawable.tasydid,"Tasydid",
                "Titik braille nomor 6"));
        belajarTandaBacaView.showTandaBacaData(tandaBacaDataSet);
    }

    @Override
    public void openTandaBacaDetail() {
        belajarTandaBacaView.showTandaBacaDetailView();
    }
}
