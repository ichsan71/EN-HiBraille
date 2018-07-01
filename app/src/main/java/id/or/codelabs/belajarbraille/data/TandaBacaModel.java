package id.or.codelabs.belajarbraille.data;

import java.util.List;

public class TandaBacaModel {
    private int imageTandaBaca;
    private String nameTandaBaca;
    private String brailleDotsTandaBaca;
    private List<Integer> listBrailleDots;

    public TandaBacaModel(int imageTandaBaca, String nameTandaBaca, String brailleDotsTandaBaca,
                          List<Integer> listBrailleDots) {
        this.imageTandaBaca = imageTandaBaca;
        this.nameTandaBaca = nameTandaBaca;
        this.brailleDotsTandaBaca = brailleDotsTandaBaca;
        this.listBrailleDots = listBrailleDots;
    }

    public int getImageTandaBaca() {
        return imageTandaBaca;
    }

    public void setImageTandaBaca(int imageTandaBaca) {
        this.imageTandaBaca = imageTandaBaca;
    }

    public String getNameTandaBaca() {
        return nameTandaBaca;
    }

    public void setNameTandaBaca(String nameTandaBaca) {
        this.nameTandaBaca = nameTandaBaca;
    }

    public String getBrailleDotsTandaBaca() {
        return brailleDotsTandaBaca;
    }

    public void setBrailleDotsTandaBaca(String brailleDotsTandaBaca) {
        this.brailleDotsTandaBaca = brailleDotsTandaBaca;
    }

    public List<Integer> getListBrailleDots() {
        return listBrailleDots;
    }

    public void setListBrailleDots(List<Integer> listBrailleDots) {
        this.listBrailleDots = listBrailleDots;
    }
}
