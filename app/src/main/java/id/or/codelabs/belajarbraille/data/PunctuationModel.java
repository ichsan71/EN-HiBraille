package id.or.codelabs.belajarbraille.data;

import java.util.List;

public class PunctuationModel {
    private int imagePunctuation;
    private String namePunctuation;
    private String brailleDotsPunctuation;
    private List<Integer> listBrailleDots;

    public PunctuationModel(int imagePunctuation, String namePunctuation, String brailleDotsPunctuation,
                            List<Integer> listBrailleDots) {
        this.imagePunctuation = imagePunctuation;
        this.namePunctuation = namePunctuation;
        this.brailleDotsPunctuation = brailleDotsPunctuation;
        this.listBrailleDots = listBrailleDots;
    }

    public int getImagePunctuation() {
        return imagePunctuation;
    }

    public void setImagePunctuation(int imagePunctuation) {
        this.imagePunctuation = imagePunctuation;
    }

    public String getNamePunctuation() {
        return namePunctuation;
    }

    public void setNamePunctuation(String namePunctuation) {
        this.namePunctuation = namePunctuation;
    }

    public String getBrailleDotsPunctuation() {
        return brailleDotsPunctuation;
    }

    public void setBrailleDotsPunctuation(String brailleDotsPunctuation) {
        this.brailleDotsPunctuation = brailleDotsPunctuation;
    }

    public List<Integer> getListBrailleDots() {
        return listBrailleDots;
    }

    public void setListBrailleDots(List<Integer> listBrailleDots) {
        this.listBrailleDots = listBrailleDots;
    }
}
