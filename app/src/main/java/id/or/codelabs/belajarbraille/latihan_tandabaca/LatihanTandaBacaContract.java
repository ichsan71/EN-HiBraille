package id.or.codelabs.belajarbraille.latihan_tandabaca;

import java.util.List;

import id.or.codelabs.belajarbraille.BasePresenter;
import id.or.codelabs.belajarbraille.BaseView;
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public interface LatihanTandaBacaContract {
    interface View extends BaseView{
        void showTandaBacaData(List<TandaBacaModel> tandaBacaDataSet);
    }
    interface Presenter extends BasePresenter{
        void loadTandaBacaData();
    }
}
