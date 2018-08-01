package id.or.codelabs.belajarbraille.punctuation_detail;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.PunctuationModel;

public interface PunctuationDetailContract {
    interface View extends BaseView {
        void showPunctuationDetail(PunctuationModel tandaBacaModel);
    }

    interface Presenter extends BasePresenter {
        void loadPunctuationDetail(PunctuationModel tandaBacaModel);
    }
}
