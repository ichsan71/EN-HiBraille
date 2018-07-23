package id.or.codelabs.belajarbraille.exercise_hijaiyah;

import java.util.List;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.HijaiyahModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public interface ExerciseHijaiyahContract {
    interface View extends BaseView{
        void showHijaiyahData(List<HijaiyahModel> hijaiyahDataSet);
    }
    interface Presenter extends BasePresenter{
        void loadHijaiyahData();
    }
}
