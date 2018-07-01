package id.or.codelabs.belajarbraille.hijaiyah_detail;

import id.or.codelabs.belajarbraille.data.HijaiyahModel;

public class HijaiyahDetailPresenter implements HijaiyahDetailContract.Presenter {

    private final HijaiyahDetailContract.View hijaiyahView;

    public HijaiyahDetailPresenter(HijaiyahDetailContract.View hijaiyahView) {
        this.hijaiyahView = hijaiyahView;
    }


    @Override
    public void loadHijaiyahDetail(HijaiyahModel hijaiyahModel) {
        hijaiyahView.showHijaiyahDetail(hijaiyahModel);

    }

    @Override
    public void start() {

    }
}
