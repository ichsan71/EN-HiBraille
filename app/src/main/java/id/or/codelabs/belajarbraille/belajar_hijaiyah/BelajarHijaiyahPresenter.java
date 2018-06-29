package id.or.codelabs.belajarbraille.belajar_hijaiyah;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class BelajarHijaiyahPresenter implements BelajarHijaiyahContract.Presenter {

    List<HijaiyahModel> hijaiyahDataSet = new ArrayList<>();
    private final BelajarHijaiyahContract.View belajarHijaiyahView;

    public BelajarHijaiyahPresenter(BelajarHijaiyahContract.View belajarHijaiyahView) {
        this.belajarHijaiyahView = belajarHijaiyahView;
    }

    @Override
    public void start() {
        loadHijaiyahData();
    }

    @Override
    public void loadHijaiyahData() {
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.alif,"Alif",
                "Titik braille nomor 1"));
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ba,"Ba",
                "Titik braille nomor 1, dan 2"));
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ta,"Ta",
                "Titik braille nomor 2, 3, 4, dan 5"));
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.tsa,"Tsa",
                "Titik braille nomor 1, 4, 5, dan 6"));
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.jim,"Jim",
                "Titik braille nomor 2, 4, dan 5"));
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ha,"Ha",
                "Titik braille nomor 1, 5, dan 6"));
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.kha,"Kha",
                "Titik braille nomor 1, 3, 4, dan 6"));
        belajarHijaiyahView.showHijaiyahData(hijaiyahDataSet);
    }

    @Override
    public void openHijaiyahDetail() {
        belajarHijaiyahView.showHijaiyahDetailView();
    }
}
