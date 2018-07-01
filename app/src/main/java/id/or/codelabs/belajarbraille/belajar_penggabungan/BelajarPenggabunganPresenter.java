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
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.alif_fathah,"Fathah",
                "Titik braille nomor 1 diikuti dengan titik braille nomor 2"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ba_fathah,"Fathah",
                "Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 2"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ta_fathah,"Fathah",
                "Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 2"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.alif_kasroh,"Fathah",
                "Titik braille nomor 1 diikuti dengan titik braille nomor 1, dan 5"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ba_kasroh,"Fathah",
                "Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 1, dan 5"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ta_kasroh,"Fathah",
                "Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 1, dan 5"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.alif_dhomah,"Fathah",
                "Titik braille nomor 1 diikuti dengan titik braille nomor 1, 3, dan 6"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ba_dhomah,"Fathah",
                "Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 1, 3, dan 6"));
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ta_dhomah,"Fathah",
                "Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 1, 3, dan 6"));
        belajarPenggabunganView.showPenggabunganData(penggabunganDataSet);
    }

    @Override
    public void openPenggabunganDetail() {
        belajarPenggabunganView.showPenggabunganDetailView();
    }
}
