package id.or.codelabs.belajarbraille.tandabaca_detail;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

public interface TandaBacaDetailContract {
    interface View extends BaseView {
        void showTandaBacaDetail(TandaBacaModel tandaBacaModel);
    }

    interface Presenter extends BasePresenter {
        void loadTandaBacaDetail(TandaBacaModel tandaBacaModel);
    }
}
