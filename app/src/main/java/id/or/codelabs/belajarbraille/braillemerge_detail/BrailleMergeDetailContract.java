package id.or.codelabs.belajarbraille.braillemerge_detail;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public interface BrailleMergeDetailContract {
    interface View extends BaseView {
        void showPenggabunganDetail(PenggabunganModel penggabunganModel);
    }

    interface Presenter extends BasePresenter {
        void loadPenggabunganDetail(PenggabunganModel penggabunganModel);
    }
}
