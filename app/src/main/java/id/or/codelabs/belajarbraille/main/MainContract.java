package id.or.codelabs.belajarbraille.main;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public interface MainContract {
    interface View extends BaseView{
        void showLearnHijaiyahView();
        void showLearnPunctuationView();
        void showLearnBrailleMergeView();
        void showExerciseHijaiyahView();
        void showExercisePunctuationView();
        void showExerciseBrailleMergeView();
    }
    interface Presenter extends BasePresenter{

    }
}
