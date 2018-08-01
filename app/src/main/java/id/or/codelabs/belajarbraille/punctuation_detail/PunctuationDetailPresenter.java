package id.or.codelabs.belajarbraille.punctuation_detail;

import id.or.codelabs.belajarbraille.data.PunctuationModel;

public class PunctuationDetailPresenter implements PunctuationDetailContract.Presenter {

    private final PunctuationDetailContract.View punctuationView;

    public PunctuationDetailPresenter(PunctuationDetailContract.View punctuationView) {
        this.punctuationView = punctuationView;
    }


    @Override
    public void loadPunctuationDetail(PunctuationModel punctuationModel) {
        punctuationView.showPunctuationDetail(punctuationModel);
    }

    @Override
    public void start() {

    }
}
