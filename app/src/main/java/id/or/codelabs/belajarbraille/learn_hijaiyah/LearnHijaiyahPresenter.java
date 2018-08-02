package id.or.codelabs.belajarbraille.learn_hijaiyah;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class LearnHijaiyahPresenter implements LearnHijaiyahContract.Presenter {

    List<HijaiyahModel> hijaiyahDataSet = new ArrayList<>();
    private final LearnHijaiyahContract.View belajarHijaiyahView;

    public LearnHijaiyahPresenter(LearnHijaiyahContract.View belajarHijaiyahView) {
        this.belajarHijaiyahView = belajarHijaiyahView;
    }

    @Override
    public void start() {
        loadHijaiyahData();
    }

    @Override
    public void loadHijaiyahData() {
        List<Integer> listBrailleDots = new ArrayList<>();
        listBrailleDots.add(1);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        listBrailleDots.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.alif,"Alif",
                "Titik braille nomor 1", listBrailleDots));
        List<Integer> listBrailleDots2 = new ArrayList<>();
        listBrailleDots2.add(1);
        listBrailleDots2.add(1);
        listBrailleDots2.add(0);
        listBrailleDots2.add(0);
        listBrailleDots2.add(0);
        listBrailleDots2.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ba,"Ba",
                "Titik braille nomor 1, dan 2", listBrailleDots2));
        List<Integer> listBrailleDots3 = new ArrayList<>();
        listBrailleDots3.add(0);
        listBrailleDots3.add(1);
        listBrailleDots3.add(1);
        listBrailleDots3.add(1);
        listBrailleDots3.add(1);
        listBrailleDots3.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ta,"Ta",
                "Titik braille nomor 2, 3, 4, dan 5", listBrailleDots3));
        List<Integer> listBrailleDots4 = new ArrayList<>();
        listBrailleDots4.add(1);
        listBrailleDots4.add(0);
        listBrailleDots4.add(0);
        listBrailleDots4.add(1);
        listBrailleDots4.add(1);
        listBrailleDots4.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.tsa,"Tsa",
                "Titik braille nomor 1, 4, 5, dan 6", listBrailleDots4));
        List<Integer> listBrailleDots5 = new ArrayList<>();
        listBrailleDots5.add(0);
        listBrailleDots5.add(1);
        listBrailleDots5.add(0);
        listBrailleDots5.add(1);
        listBrailleDots5.add(0);
        listBrailleDots5.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.jim,"Jim",
                "Titik braille nomor 2, 4, dan 5", listBrailleDots5));
        List<Integer> listBrailleDots6 = new ArrayList<>();
        listBrailleDots6.add(1);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(0);
        listBrailleDots6.add(1);
        listBrailleDots6.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ha,"Ha",
                "Titik braille nomor 1, 5, dan 6", listBrailleDots6));
        List<Integer> listBrailleDots7 = new ArrayList<>();
        listBrailleDots7.add(1);
        listBrailleDots7.add(0);
        listBrailleDots7.add(1);
        listBrailleDots7.add(1);
        listBrailleDots7.add(0);
        listBrailleDots7.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.kha,"Kho",
                "Titik braille nomor 1, 3, 4, dan 6", listBrailleDots7));
        List<Integer> listBrailleDots8 = new ArrayList<>();
        listBrailleDots8.add(1);
        listBrailleDots8.add(0);
        listBrailleDots8.add(0);
        listBrailleDots8.add(1);
        listBrailleDots8.add(1);
        listBrailleDots8.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.da,"Dal",
                "Titik braille nomor 1, 4, dan 5", listBrailleDots8));
        List<Integer> listBrailleDots9 = new ArrayList<>();
        listBrailleDots9.add(0);
        listBrailleDots9.add(1);
        listBrailleDots9.add(1);
        listBrailleDots9.add(1);
        listBrailleDots9.add(0);
        listBrailleDots9.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.dha,"Dzal",
                "Titik braille nomor 2, 3, 4, dan 6", listBrailleDots9));
        List<Integer> listBrailleDots10 = new ArrayList<>();
        listBrailleDots10.add(1);
        listBrailleDots10.add(1);
        listBrailleDots10.add(1);
        listBrailleDots10.add(0);
        listBrailleDots10.add(1);
        listBrailleDots10.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ro,"Ro",
                "Titik braille nomor 1, 2, 3, dan 5", listBrailleDots10));
        List<Integer> listBrailleDots11 = new ArrayList<>();
        listBrailleDots11.add(1);
        listBrailleDots11.add(0);
        listBrailleDots11.add(1);
        listBrailleDots11.add(0);
        listBrailleDots11.add(1);
        listBrailleDots11.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.zay,"Zay",
                "Titik braille nomor 1, 3, 5, dan 6", listBrailleDots11));
        List<Integer> listBrailleDots12 = new ArrayList<>();
        listBrailleDots12.add(1);
        listBrailleDots12.add(0);
        listBrailleDots12.add(1);
        listBrailleDots12.add(0);
        listBrailleDots12.add(1);
        listBrailleDots12.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.sin,"Sin",
                "Titik braille nomor 2, 3, dan 4", listBrailleDots12));
        List<Integer> listBrailleDots13 = new ArrayList<>();
        listBrailleDots13.add(1);
        listBrailleDots13.add(0);
        listBrailleDots13.add(0);
        listBrailleDots13.add(1);
        listBrailleDots13.add(0);
        listBrailleDots13.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.syin,"Syin",
                "Titik braille nomor 1, 4, dan 6", listBrailleDots13));
        List<Integer> listBrailleDots14 = new ArrayList<>();
        listBrailleDots14.add(1);
        listBrailleDots14.add(1);
        listBrailleDots14.add(1);
        listBrailleDots14.add(1);
        listBrailleDots14.add(0);
        listBrailleDots14.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.sod,"Sod",
                "Titik braille nomor 1, 2, 3, 4, dan 6", listBrailleDots14));
        List<Integer> listBrailleDots15 = new ArrayList<>();
        listBrailleDots15.add(1);
        listBrailleDots15.add(1);
        listBrailleDots15.add(0);
        listBrailleDots15.add(1);
        listBrailleDots15.add(0);
        listBrailleDots15.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.do_, "Do",
                "Titik braille nomor 1, 2, 4, dan 6", listBrailleDots15));
        List<Integer> listBrailleDots16 = new ArrayList<>();
        listBrailleDots16.add(0);
        listBrailleDots16.add(1);
        listBrailleDots16.add(1);
        listBrailleDots16.add(1);
        listBrailleDots16.add(1);
        listBrailleDots16.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.to, "To",
                "Titik braille nomor 2, 3, 4, 5, dan 6", listBrailleDots16));
        List<Integer> listBrailleDots17 = new ArrayList<>();
        listBrailleDots17.add(1);
        listBrailleDots17.add(1);
        listBrailleDots17.add(1);
        listBrailleDots17.add(1);
        listBrailleDots17.add(1);
        listBrailleDots17.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.tho, "Tho",
                "Titik braille nomor 1, 2, 3, 4, 5, dan 6", listBrailleDots17));
        List<Integer> listBrailleDots18 = new ArrayList<>();
        listBrailleDots18.add(1);
        listBrailleDots18.add(1);
        listBrailleDots18.add(1);
        listBrailleDots18.add(0);
        listBrailleDots18.add(1);
        listBrailleDots18.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ayn, "Ayn",
                "Titik braille nomor 1, 2, 3, 5, dan 6", listBrailleDots18));
        List<Integer> listBrailleDots19 = new ArrayList<>();
        listBrailleDots19.add(1);
        listBrailleDots19.add(1);
        listBrailleDots19.add(0);
        listBrailleDots19.add(0);
        listBrailleDots19.add(0);
        listBrailleDots19.add(1);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ayn, "Goyn",
                "Titik braille nomor 1, 2, dan 6", listBrailleDots19));
        List<Integer> listBrailleDots20 = new ArrayList<>();
        listBrailleDots20.add(1);
        listBrailleDots20.add(1);
        listBrailleDots20.add(0);
        listBrailleDots20.add(1);
        listBrailleDots20.add(0);
        listBrailleDots20.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.fa, "Fa",
                "Titik braille nomor 1, 2, dan 4", listBrailleDots20));
        List<Integer> listBrailleDots21 = new ArrayList<>();
        listBrailleDots21.add(1);
        listBrailleDots21.add(1);
        listBrailleDots21.add(1);
        listBrailleDots21.add(1);
        listBrailleDots21.add(1);
        listBrailleDots21.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.qof, "Qof",
                "Titik braille nomor 1, 2, 3, 4, dan 5", listBrailleDots21));
        List<Integer> listBrailleDots22 = new ArrayList<>();
        listBrailleDots22.add(1);
        listBrailleDots22.add(0);
        listBrailleDots22.add(1);
        listBrailleDots22.add(0);
        listBrailleDots22.add(0);
        listBrailleDots22.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.kaf, "Kaf",
                "Titik braille nomor 1, dan 3", listBrailleDots22));
        List<Integer> listBrailleDots23 = new ArrayList<>();
        listBrailleDots23.add(1);
        listBrailleDots23.add(1);
        listBrailleDots23.add(1);
        listBrailleDots23.add(0);
        listBrailleDots23.add(0);
        listBrailleDots23.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.lam, "Lam",
                "Titik braille nomor 1, 2, dan 3", listBrailleDots23));
        List<Integer> listBrailleDots24 = new ArrayList<>();
        listBrailleDots24.add(1);
        listBrailleDots24.add(1);
        listBrailleDots24.add(1);
        listBrailleDots24.add(0);
        listBrailleDots24.add(0);
        listBrailleDots24.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.mim, "Mim",
                "Titik braille nomor 1, 3, dan 4", listBrailleDots24));
        List<Integer> listBrailleDots25 = new ArrayList<>();
        listBrailleDots25.add(1);
        listBrailleDots25.add(0);
        listBrailleDots25.add(1);
        listBrailleDots25.add(1);
        listBrailleDots25.add(1);
        listBrailleDots25.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.nun, "Nun",
                "Titik braille nomor 1, 3, 4, dan 5", listBrailleDots25));
        List<Integer> listBrailleDots26 = new ArrayList<>();
        listBrailleDots26.add(1);
        listBrailleDots26.add(0);
        listBrailleDots26.add(1);
        listBrailleDots26.add(1);
        listBrailleDots26.add(1);
        listBrailleDots26.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.wauw, "Wauw",
                "Titik braille nomor 2, 4, 5, dan 6", listBrailleDots26));
        List<Integer> listBrailleDots27 = new ArrayList<>();
        listBrailleDots27.add(1);
        listBrailleDots27.add(1);
        listBrailleDots27.add(0);
        listBrailleDots27.add(0);
        listBrailleDots27.add(1);
        listBrailleDots27.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ha_2, "Hamzah",
                "Titik braille nomor 1, 2, dan 5", listBrailleDots27));
        List<Integer> listBrailleDots28 = new ArrayList<>();
        listBrailleDots28.add(0);
        listBrailleDots28.add(1);
        listBrailleDots28.add(0);
        listBrailleDots28.add(1);
        listBrailleDots28.add(0);
        listBrailleDots28.add(0);
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.ya, "Ya",
                "Titik braille nomor 2, dan 4", listBrailleDots28));
        belajarHijaiyahView.showHijaiyahData(hijaiyahDataSet);
    }

}
