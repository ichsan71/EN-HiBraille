package id.or.codelabs.belajarbraille.braillemerge_detail;

import id.or.codelabs.belajarbraille.data.BrailleMergeModel;

public class BrailleMergeDetailPresenter implements BrailleMergeDetailContract.Presenter {

    private final BrailleMergeDetailContract.View brailleMergeView;

    public BrailleMergeDetailPresenter(BrailleMergeDetailContract.View brailleMergeView) {
        this.brailleMergeView = brailleMergeView;
    }

    @Override
    public void loadBrailleMergeDetail(BrailleMergeModel brailleMergeModel) {
        brailleMergeView.showBrailleMergeDetail(brailleMergeModel);
    }

    @Override
    public void start() {

    }
}
