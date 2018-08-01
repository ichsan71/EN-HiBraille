package id.or.codelabs.belajarbraille.learn_punctuation;

import java.util.List;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.PunctuationModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public interface LearnPunctuationContract {
    interface View extends BaseView {
        void showPunctuationData(List<PunctuationModel> punctuationDataSet);
    }
    interface Presenter extends BasePresenter {
        void loadPunctuationData();
    }
}
