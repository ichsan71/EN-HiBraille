package id.or.codelabs.belajarbraille.tandabaca_detail;

import id.or.codelabs.belajarbraille.data.TandaBacaModel;

public class TandaBacaDetailPresenter implements TandaBacaDetailContract.Presenter {

    private final TandaBacaDetailContract.View tandaBacaView;

    public TandaBacaDetailPresenter(TandaBacaDetailContract.View tandaBacaView) {
        this.tandaBacaView = tandaBacaView;
    }


    @Override
    public void loadTandaBacaDetail(TandaBacaModel tandaBacaModel) {
        tandaBacaView.showTandaBacaDetail(tandaBacaModel);
    }

    @Override
    public void start() {

    }
}
