package id.or.codelabs.belajarbraille.braillemerge_detail;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.BrailleMergeModel;

public interface BrailleMergeDetailContract {
    interface View extends BaseView {
        void showBrailleMergeDetail(BrailleMergeModel brailleMergeModel);
    }

    interface Presenter extends BasePresenter {
        void loadBrailleMergeDetail(BrailleMergeModel brailleMergeModel);
    }
}
