package id.or.codelabs.belajarbraille.hijaiyah_detail;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;

public interface HijaiyahDetailContract {
    interface View extends BaseView {
        void showHijaiyahDetail(HijaiyahModel hijaiyahModel);
    }

    interface Presenter extends BasePresenter {
        void loadHijaiyahDetail(HijaiyahModel hijaiyahModel);
    }
}
