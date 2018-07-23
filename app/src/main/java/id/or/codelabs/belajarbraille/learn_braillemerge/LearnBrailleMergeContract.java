package id.or.codelabs.belajarbraille.learn_braillemerge;

import java.util.List;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public interface LearnBrailleMergeContract {
    interface View extends BaseView {
        void showPenggabunganData(List<PenggabunganModel> penggabunganDataSet);
    }
    interface Presenter extends BasePresenter {
        void loadPenggabunganData();
    }
}
