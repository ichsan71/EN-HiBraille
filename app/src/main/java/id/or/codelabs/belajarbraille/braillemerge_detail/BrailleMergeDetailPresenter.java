package id.or.codelabs.belajarbraille.braillemerge_detail;

import id.or.codelabs.belajarbraille.data.PenggabunganModel;

public class BrailleMergeDetailPresenter implements BrailleMergeDetailContract.Presenter {

    private final BrailleMergeDetailContract.View penggabunganView;

    public BrailleMergeDetailPresenter(BrailleMergeDetailContract.View penggabunganView) {
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
