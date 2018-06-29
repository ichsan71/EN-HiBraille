package id.or.codelabs.belajarbraille.belajar_penggabungan;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class BelajarPenggabunganPresenter implements BelajarPenggabunganContract.Presenter {

    List<PenggabunganModel> penggabunganDataSet = new ArrayList<>();
    private final BelajarPenggabunganContract.View belajarPenggabunganView;

    public BelajarPenggabunganPresenter(BelajarPenggabunganContract.View belajarPenggabunganView) {
        this.belajarPenggabunganView = belajarPenggabunganView;
    }

    @Override
    public void start() {
        loadPenggabunganData();
    }

    @Override
    public void loadPenggabunganData() {
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.alif,"Fathah",
                "Titik braille nomor 2"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.kasroh,"Kasroh",
                "Titik braille nomor 1, dan 5"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.dhomah,"Dhomah",
                "Titik braille nomor 1, 3, dan 6"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.fathah_tanwin,"Fathah Tanwin",
                "Titik braille nomor 2 dan 3"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.kasroh_tanwin,"Kasroh Tanwin",
                "Titik braille nomor 3, dan 5"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.tasydid,"Tasydid",
                "Titik braille nomor 6"));
        belajarPenggabunganView.showPenggabunganData(penggabunganDataSet);
    }

    @Override
    public void openPenggabunganDetail() {
        belajarPenggabunganView.showPenggabunganDetailView();
    }
}
