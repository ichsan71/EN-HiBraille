package id.or.codelabs.belajarbraille.exercise_hijaiyah;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;

public class ExerciseHijaiyahPresenter implements ExerciseHijaiyahContract.Presenter{
    List<HijaiyahModel> hijaiyahDataSet = new ArrayList<>();
    private final ExerciseHijaiyahContract.View latihanHijaiyahView;

    public ExerciseHijaiyahPresenter(ExerciseHijaiyahContract.View latihanHijaiyahView) {
        this.latihanHijaiyahView = latihanHijaiyahView;
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
        hijaiyahDataSet.add(new HijaiyahModel(R.drawable.kha,"Kha",
                "Titik braille nomor 1, 3, 4, dan 6", listBrailleDots7));
        latihanHijaiyahView.showHijaiyahData(hijaiyahDataSet);
    }
}
