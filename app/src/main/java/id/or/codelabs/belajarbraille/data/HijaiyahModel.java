package id.or.codelabs.belajarbraille.data;

import java.util.List;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class HijaiyahModel {

    private int imageHijaiyah;
    private String nameHijaiyah;
    private String brailleDotsHijaiyah;
    private List<Integer> listBrailleDots;

    public HijaiyahModel(int imageHijaiyah, String nameHijaiyah, String brailleDotsHijaiyah,
                         List<Integer> listBrailleDots) {
        this.imageHijaiyah = imageHijaiyah;
        this.nameHijaiyah = nameHijaiyah;
        this.brailleDotsHijaiyah = brailleDotsHijaiyah;
        this.listBrailleDots = listBrailleDots;
    }

    public int getImageHijaiyah() {
        return imageHijaiyah;
    }

    public void setImageHijaiyah(int imageHijaiyah) {
        this.imageHijaiyah = imageHijaiyah;
    }

    public String getNameHijaiyah() {
        return nameHijaiyah;
    }

    public void setNameHijaiyah(String nameHijaiyah) {
        this.nameHijaiyah = nameHijaiyah;
    }

    public String getBrailleDotsHijaiyah() {
        return brailleDotsHijaiyah;
    }

    public void setBrailleDotsHijaiyah(String brailleDotsHijaiyah) {
        this.brailleDotsHijaiyah = brailleDotsHijaiyah;
    }

    public List<Integer> getListBrailleDots() {
        return listBrailleDots;
    }

    public void setListBrailleDots(List<Integer> listBrailleDots) {
        this.listBrailleDots = listBrailleDots;
    }
}
