package id.or.codelabs.belajarbraille.penggabungan_detail;

import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class PenggabunganDetailPresenter implements PenggabunganDetailContract.Presenter {

    private final PenggabunganDetailContract.View penggabunganView;

    public PenggabunganDetailPresenter(PenggabunganDetailContract.View penggabunganView) {
        this.penggabunganView = penggabunganView;
    }

    @Override
    public void loadPenggabunganDetail(PenggabunganModel penggabunganModel) {
        penggabunganView.showPenggabunganDetail(penggabunganModel);
    }

    @Override
    public void start() {

    }
}
