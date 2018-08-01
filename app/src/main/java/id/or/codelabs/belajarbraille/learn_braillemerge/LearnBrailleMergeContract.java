package id.or.codelabs.belajarbraille.learn_braillemerge;

import java.util.List;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.BrailleMergeModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public interface LearnBrailleMergeContract {
    interface View extends BaseView {
        void showBrailleMergeData(List<BrailleMergeModel> brailleMergeDataSet);
    }
    interface Presenter extends BasePresenter {
        void loadBrailleMergeData();
    }
}
