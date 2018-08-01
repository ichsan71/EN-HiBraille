package id.or.codelabs.belajarbraille.learn_braillemerge;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.BrailleMergeModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class LearnBrailleMergePresenter implements LearnBrailleMergeContract.Presenter {

    List<BrailleMergeModel> brailleMergeDataSet = new ArrayList<>();
    private final LearnBrailleMergeContract.View belajarBrailleMergeView;

    public LearnBrailleMergePresenter(LearnBrailleMergeContract.View belajarBrailleMergeView) {
        this.belajarBrailleMergeView = belajarBrailleMergeView;
    }

    @Override
    public void start() {
        loadBrailleMergeData();
    }

    @Override
    public void loadBrailleMergeData() {
        List<Integer> listBrailleDotsHijaiyah = new ArrayList<>();
        listBrailleDotsHijaiyah.add(1);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        listBrailleDotsHijaiyah.add(0);
        List<Integer> listBrailleDotsPunctuation = new ArrayList<>();
        listBrailleDotsPunctuation.add(0);
        listBrailleDotsPunctuation.add(1);
        listBrailleDotsPunctuation.add(0);
        listBrailleDotsPunctuation.add(0);
        listBrailleDotsPunctuation.add(0);
        listBrailleDotsPunctuation.add(0);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.alif_fathah,"Alif Fathah",
                "Alif", "Fathah","a",
                "Titik braille nomor 1 diikuti dengan titik braille nomor 2",
                listBrailleDotsHijaiyah, listBrailleDotsPunctuation));
        List<Integer> listBrailleDotsHijaiyah2 = new ArrayList<>();
        listBrailleDotsHijaiyah2.add(1);
        listBrailleDotsHijaiyah2.add(1);
        listBrailleDotsHijaiyah2.add(0);
        listBrailleDotsHijaiyah2.add(0);
        listBrailleDotsHijaiyah2.add(0);
        listBrailleDotsHijaiyah2.add(0);
        List<Integer> listBrailleDotsPunctuation2 = new ArrayList<>();
        listBrailleDotsPunctuation2.add(0);
        listBrailleDotsPunctuation2.add(1);
        listBrailleDotsPunctuation2.add(0);
        listBrailleDotsPunctuation2.add(0);
        listBrailleDotsPunctuation2.add(0);
        listBrailleDotsPunctuation2.add(0);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.ba_fathah,"Ba Fathah",
                "Ba", "Fathah", "ba",
                "Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 2",
                listBrailleDotsHijaiyah2, listBrailleDotsPunctuation2));
        List<Integer> listBrailleDotsHijaiyah3 = new ArrayList<>();
        listBrailleDotsHijaiyah3.add(0);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(1);
        listBrailleDotsHijaiyah3.add(0);
        List<Integer> listBrailleDotsPunctuation3 = new ArrayList<>();
        listBrailleDotsPunctuation3.add(0);
        listBrailleDotsPunctuation3.add(1);
        listBrailleDotsPunctuation3.add(0);
        listBrailleDotsPunctuation3.add(0);
        listBrailleDotsPunctuation3.add(0);
        listBrailleDotsPunctuation3.add(0);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.ta_fathah,"Ta Fathah",
                "Ta", "Fathah", "ta",
                "Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 2",
                listBrailleDotsHijaiyah3, listBrailleDotsPunctuation3));
        List<Integer> listBrailleDotsHijaiyah4 = new ArrayList<>();
        listBrailleDotsHijaiyah4.add(1);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        listBrailleDotsHijaiyah4.add(0);
        List<Integer> listBrailleDotsPunctuation4 = new ArrayList<>();
        listBrailleDotsPunctuation4.add(1);
        listBrailleDotsPunctuation4.add(0);
        listBrailleDotsPunctuation4.add(0);
        listBrailleDotsPunctuation4.add(0);
        listBrailleDotsPunctuation4.add(1);
        listBrailleDotsPunctuation4.add(0);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.alif_kasroh,"Alif Kasroh",
                "Alif", "Kasroh", "i",
                "Titik braille nomor 1 diikuti dengan titik braille nomor 1, dan 5",
                listBrailleDotsHijaiyah4, listBrailleDotsPunctuation4));
        List<Integer> listBrailleDotsHijaiyah5 = new ArrayList<>();
        listBrailleDotsHijaiyah5.add(1);
        listBrailleDotsHijaiyah5.add(1);
        listBrailleDotsHijaiyah5.add(0);
        listBrailleDotsHijaiyah5.add(0);
        listBrailleDotsHijaiyah5.add(0);
        listBrailleDotsHijaiyah5.add(0);
        List<Integer> listBrailleDotsPunctuation5 = new ArrayList<>();
        listBrailleDotsPunctuation5.add(1);
        listBrailleDotsPunctuation5.add(0);
        listBrailleDotsPunctuation5.add(0);
        listBrailleDotsPunctuation5.add(0);
        listBrailleDotsPunctuation5.add(1);
        listBrailleDotsPunctuation5.add(0);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.ba_kasroh,"Ba Kasroh",
                "Ba", "Kasroh", "bi",
                "Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 1, dan 5",
                listBrailleDotsHijaiyah5, listBrailleDotsPunctuation5));
        List<Integer> listBrailleDotsHijaiyah6 = new ArrayList<>();
        listBrailleDotsHijaiyah6.add(0);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(1);
        listBrailleDotsHijaiyah6.add(0);
        List<Integer> listBrailleDotsPunctuation6 = new ArrayList<>();
        listBrailleDotsPunctuation6.add(1);
        listBrailleDotsPunctuation6.add(0);
        listBrailleDotsPunctuation6.add(0);
        listBrailleDotsPunctuation6.add(0);
        listBrailleDotsPunctuation6.add(1);
        listBrailleDotsPunctuation6.add(0);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.ta_kasroh,"Ta Kasroh",
                "Ta", "Kasroh", "ti",
                "Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 1, dan 5",
                listBrailleDotsHijaiyah6, listBrailleDotsPunctuation6));
        List<Integer> listBrailleDotsHijaiyah7 = new ArrayList<>();
        listBrailleDotsHijaiyah7.add(1);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        listBrailleDotsHijaiyah7.add(0);
        List<Integer> listBrailleDotsPunctuation7 = new ArrayList<>();
        listBrailleDotsPunctuation7.add(1);
        listBrailleDotsPunctuation7.add(0);
        listBrailleDotsPunctuation7.add(1);
        listBrailleDotsPunctuation7.add(0);
        listBrailleDotsPunctuation7.add(0);
        listBrailleDotsPunctuation7.add(1);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.alif_dhomah,"Alif Dhomah",
                "Alif", "Dhomah", "u",
                "Titik braille nomor 1 diikuti dengan titik braille nomor 1, 3, dan 6",
                listBrailleDotsHijaiyah7, listBrailleDotsHijaiyah7));
        List<Integer> listBrailleDotsHijaiyah8 = new ArrayList<>();
        listBrailleDotsHijaiyah8.add(1);
        listBrailleDotsHijaiyah8.add(1);
        listBrailleDotsHijaiyah8.add(0);
        listBrailleDotsHijaiyah8.add(0);
        listBrailleDotsHijaiyah8.add(0);
        listBrailleDotsHijaiyah8.add(0);
        List<Integer> listBrailleDotsPunctuation8 = new ArrayList<>();
        listBrailleDotsPunctuation8.add(1);
        listBrailleDotsPunctuation8.add(0);
        listBrailleDotsPunctuation8.add(1);
        listBrailleDotsPunctuation8.add(0);
        listBrailleDotsPunctuation8.add(0);
        listBrailleDotsPunctuation8.add(1);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.ba_dhomah,"Ba Dhomah",
                "Ba", "Dhomah", "bu","Titik braille nomor 1, dan 2 diikuti dengan titik braille nomor 1, 3, dan 6",
                listBrailleDotsHijaiyah8, listBrailleDotsPunctuation8));
        List<Integer> listBrailleDotsHijaiyah9 = new ArrayList<>();
        listBrailleDotsHijaiyah9.add(1);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        listBrailleDotsHijaiyah9.add(0);
        List<Integer> listBrailleDotsPunctuation9 = new ArrayList<>();
        listBrailleDotsPunctuation9.add(0);
        listBrailleDotsPunctuation9.add(2);
        listBrailleDotsPunctuation9.add(0);
        listBrailleDotsPunctuation9.add(0);
        listBrailleDotsPunctuation9.add(0);
        listBrailleDotsPunctuation9.add(0);
        brailleMergeDataSet.add(new BrailleMergeModel(R.drawable.ta_dhomah,"Ta Dhomah",
                "Ta", "Dhomah", "tu",
                "Titik braille nomor 2, 3, 4, dan 5 diikuti dengan titik braille nomor 1, 3, dan 6",
                listBrailleDotsHijaiyah9, listBrailleDotsPunctuation9));
        belajarBrailleMergeView.showBrailleMergeData(brailleMergeDataSet);
    }
}
