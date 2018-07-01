package id.or.codelabs.belajarbraille.penggabungan_detail;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public interface PenggabunganDetailContract {
    interface View extends BaseView {
        void showPenggabunganDetail(PenggabunganModel penggabunganModel);
    }

    interface Presenter extends BasePresenter {
        void loadPenggabunganDetail(PenggabunganModel penggabunganModel);
    }
}
