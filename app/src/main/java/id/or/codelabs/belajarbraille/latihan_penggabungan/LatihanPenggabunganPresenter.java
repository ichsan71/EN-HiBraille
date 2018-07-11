package id.or.codelabs.belajarbraille.latihan_penggabungan;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class LatihanPenggabunganPresenter implements LatihanPenggabunganContract.Presenter{

    List<PenggabunganModel> penggabunganDataSet = new ArrayList<>();
    private final LatihanPenggabunganContract.View latihanPenggabunganView;

    public LatihanPenggabunganPresenter(LatihanPenggabunganContract.View latihanPenggabunganView) {
        this.latihanPenggabunganView = latihanPenggabunganView;
    }

    @Override
    public void loadPenggabunganData() {
        List<Integer> listBrailleDotsHijaiyah = new ArrayList<>();
        listBrailleDotsHijaiyah.add(1);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        List<Integer> listBrailleDotsTandaBaca = new ArrayList<>();
        listBrailleDotsTandaBaca.add(0);
        listBrailleDotsTandaBaca.add(1);
        listBrailleDotsTandaBaca.add(0);
        listBrailleDotsTandaBaca.add(0);
        listBrailleDotsTandaBaca.add(0);
        listBrailleDotsTandaBaca.add(0);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.alif_fathah,"Alif Fathah",
                "a","Titik braille nomor 1 diikuti dengan titik braille nomor 2",
                listBrailleDotsHijaiyah, listBrailleDotsTandaBaca));
        List<Integer> listBrailleDotsHijaiyah2 = new ArrayList<>();
        listBrailleDotsHijaiyah2.add(1);
        listBrailleDotsHijaiyah2.add(1);
        listBrailleDotsHijaiyah2.add(0);
        listBrailleDotsHijaiyah2.add(0);
        listBrailleDotsHijaiyah2.add(0);
        listBrailleDotsHijaiyah2.add(0);
        List<Integer> listBrailleDotsTandaBaca2 = new ArrayList<>();
        listBrailleDotsTandaBaca2.add(0);
        listBrailleDotsTandaBaca2.add(1);
        listBrailleDotsTandaBaca2.add(0);
        listBrailleDotsTandaBaca2.add(0);
        listBrailleDotsTandaBaca2.add(0);
        listBrailleDotsTandaBaca2.add(0);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ba_fathah,"Ba Fathah",
                "ba","Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 2",
                listBrailleDotsHijaiyah2, listBrailleDotsTandaBaca2));
        List<Integer> listBrailleDotsHijaiyah3 = new ArrayList<>();
        listBrailleDotsHijaiyah3.add(0);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(0);
        List<Integer> listBrailleDotsTandaBaca3 = new ArrayList<>();
        listBrailleDotsTandaBaca3.add(0);
        listBrailleDotsTandaBaca3.add(1);
        listBrailleDotsTandaBaca3.add(0);
        listBrailleDotsTandaBaca3.add(0);
        listBrailleDotsTandaBaca3.add(0);
        listBrailleDotsTandaBaca3.add(0);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ta_fathah,"Ta Fathah",
                "ta","Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 2",
                listBrailleDotsHijaiyah3, listBrailleDotsTandaBaca3));
        List<Integer> listBrailleDotsHijaiyah4 = new ArrayList<>();
        listBrailleDotsHijaiyah4.add(1);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        List<Integer> listBrailleDotsTandaBaca4 = new ArrayList<>();
        listBrailleDotsTandaBaca4.add(1);
        listBrailleDotsTandaBaca4.add(0);
        listBrailleDotsTandaBaca4.add(0);
        listBrailleDotsTandaBaca4.add(0);
        listBrailleDotsTandaBaca4.add(1);
        listBrailleDotsTandaBaca4.add(0);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.alif_kasroh,"Alif Kasroh",
                "i","Titik braille nomor 1 diikuti dengan titik braille nomor 1, dan 5",
                listBrailleDotsHijaiyah4, listBrailleDotsTandaBaca4));
        List<Integer> listBrailleDotsHijaiyah5 = new ArrayList<>();
        listBrailleDotsHijaiyah5.add(1);
        listBrailleDotsHijaiyah5.add(1);
        listBrailleDotsHijaiyah5.add(0);
        listBrailleDotsHijaiyah5.add(0);
        listBrailleDotsHijaiyah5.add(0);
        listBrailleDotsHijaiyah5.add(0);
        List<Integer> listBrailleDotsTandaBaca5 = new ArrayList<>();
        listBrailleDotsTandaBaca5.add(1);
        listBrailleDotsTandaBaca5.add(0);
        listBrailleDotsTandaBaca5.add(0);
        listBrailleDotsTandaBaca5.add(0);
        listBrailleDotsTandaBaca5.add(1);
        listBrailleDotsTandaBaca5.add(0);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ba_kasroh,"Ba Kasroh",
                "bi","Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 1, dan 5",
                listBrailleDotsHijaiyah5, listBrailleDotsTandaBaca5));
        List<Integer> listBrailleDotsHijaiyah6 = new ArrayList<>();
        listBrailleDotsHijaiyah6.add(0);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(0);
        List<Integer> listBrailleDotsTandaBaca6 = new ArrayList<>();
        listBrailleDotsTandaBaca6.add(1);
        listBrailleDotsTandaBaca6.add(0);
        listBrailleDotsTandaBaca6.add(0);
        listBrailleDotsTandaBaca6.add(0);
        listBrailleDotsTandaBaca6.add(1);
        listBrailleDotsTandaBaca6.add(0);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ta_kasroh,"Ta Kasroh",
                "ti","Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 1, dan 5",
                listBrailleDotsHijaiyah6, listBrailleDotsTandaBaca6));
        List<Integer> listBrailleDotsHijaiyah7 = new ArrayList<>();
        listBrailleDotsHijaiyah7.add(1);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        List<Integer> listBrailleDotsTandaBaca7 = new ArrayList<>();
        listBrailleDotsTandaBaca7.add(1);
        listBrailleDotsTandaBaca7.add(0);
        listBrailleDotsTandaBaca7.add(1);
        listBrailleDotsTandaBaca7.add(0);
        listBrailleDotsTandaBaca7.add(0);
        listBrailleDotsTandaBaca7.add(1);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.alif_dhomah,"Alif Dhomah",
                "u","Titik braille nomor 1 diikuti dengan titik braille nomor 1, 3, dan 6",
                listBrailleDotsHijaiyah7, listBrailleDotsHijaiyah7));
        List<Integer> listBrailleDotsHijaiyah8 = new ArrayList<>();
        listBrailleDotsHijaiyah8.add(1);
        listBrailleDotsHijaiyah8.add(1);
        listBrailleDotsHijaiyah8.add(0);
        listBrailleDotsHijaiyah8.add(0);
        listBrailleDotsHijaiyah8.add(0);
        listBrailleDotsHijaiyah8.add(0);
        List<Integer> listBrailleDotsTandaBaca8 = new ArrayList<>();
        listBrailleDotsTandaBaca8.add(1);
        listBrailleDotsTandaBaca8.add(0);
        listBrailleDotsTandaBaca8.add(1);
        listBrailleDotsTandaBaca8.add(0);
        listBrailleDotsTandaBaca8.add(0);
        listBrailleDotsTandaBaca8.add(1);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ba_dhomah,"Ba Dhomah",
                "bu","Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 1, 3, dan 6",
                listBrailleDotsHijaiyah8, listBrailleDotsTandaBaca8));
        List<Integer> listBrailleDotsHijaiyah9 = new ArrayList<>();
        listBrailleDotsHijaiyah9.add(1);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        List<Integer> listBrailleDotsTandaBaca9 = new ArrayList<>();
        listBrailleDotsTandaBaca9.add(0);
        listBrailleDotsTandaBaca9.add(2);
        listBrailleDotsTandaBaca9.add(0);
        listBrailleDotsTandaBaca9.add(0);
        listBrailleDotsTandaBaca9.add(0);
        listBrailleDotsTandaBaca9.add(0);
        penggabunganDataSet.add(new PenggabunganModel(R.drawable.ta_dhomah,"Ta Dhomah",
                "tu","Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 1, 3, dan 6",
                listBrailleDotsHijaiyah9, listBrailleDotsTandaBaca9));
        latihanPenggabunganView.showPenggabunganData(penggabunganDataSet);
    }

    @Override
    public void start() {
        loadPenggabunganData();
    }
}
