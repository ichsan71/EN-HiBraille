package id.or.codelabs.belajarbraille.punctuation_detail;

import id.or.codelabs.belajarbraille.data.TandaBacaModel;

public class PunctuationDetailPresenter implements PunctuationDetailContract.Presenter {

    private final PunctuationDetailContract.View tandaBacaView;

    public PunctuationDetailPresenter(PunctuationDetailContract.View tandaBacaView) {
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
