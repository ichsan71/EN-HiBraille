package id.or.codelabs.belajarbraille.main;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public interface MainContract {
    interface View extends BaseView{
        void showBelajarHijaiyahView();
        void showBelajarTandaBacaView();
        void showBelajarPenggabunganView();
        void showLatihanHijaiyahView();
        void showLatihanTandaBacaView();
        void showLatihanPenggabunganView();
    }
    interface Presenter extends BasePresenter{

    }
}
