package id.or.codelabs.belajarbraille.data;

import java.util.List;

public class BrailleMergeModel {
    private int imageBrailleMerge;
    private String nameBrailleMerge;
    private String nameHijaiyah;
    private String namePunctuation;
    private String spellBrailleMerge;
    private String brailleDotsBrailleMerge;
    private List<Integer> listBrailleDotsHijaiyah;
    private List<Integer> listBrailleDotsPunctuation;

    public BrailleMergeModel(int imageBrailleMerge, String nameBrailleMerge, String nameHijaiyah,
                             String namePunctuation, String spellBrailleMerge,
                             String brailleDotsBrailleMerge, List<Integer> listBrailleDotsHijaiyah,
                             List<Integer> listBrailleDotsPunctuation) {
        this.imageBrailleMerge = imageBrailleMerge;
        this.nameBrailleMerge = nameBrailleMerge;
        this.nameHijaiyah = nameHijaiyah;
        this.namePunctuation = namePunctuation;
        this.spellBrailleMerge = spellBrailleMerge;
        this.brailleDotsBrailleMerge = brailleDotsBrailleMerge;
        this.listBrailleDotsHijaiyah = listBrailleDotsHijaiyah;
        this.listBrailleDotsPunctuation = listBrailleDotsPunctuation;
    }

    public int getImageBrailleMerge() {
        return imageBrailleMerge;
    }

    public void setImageBrailleMerge(int imageBrailleMerge) {
        this.imageBrailleMerge = imageBrailleMerge;
    }

    public String getNameBrailleMerge() {
        return nameBrailleMerge;
    }

    public void setNameBrailleMerge(String nameBrailleMerge) {
        this.nameBrailleMerge = nameBrailleMerge;
    }

    public String getBrailleDotsBrailleMerge() {
        return brailleDotsBrailleMerge;
    }

    public void setBrailleDotsBrailleMerge(String brailleDotsBrailleMerge) {
        this.brailleDotsBrailleMerge = brailleDotsBrailleMerge;
    }

    public List<Integer> getListBrailleDotsHijaiyah() {
        return listBrailleDotsHijaiyah;
    }

    public void setListBrailleDotsHijaiyah(List<Integer> listBrailleDotsHijaiyah) {
        this.listBrailleDotsHijaiyah = listBrailleDotsHijaiyah;
    }

    public List<Integer> getListBrailleDotsPunctuation() {
        return listBrailleDotsPunctuation;
    }

    public void setListBrailleDotsPunctuation(List<Integer> listBrailleDotsPunctuation) {
        this.listBrailleDotsPunctuation = listBrailleDotsPunctuation;
    }

    public String getSpellBrailleMerge() {
        return spellBrailleMerge;
    }

    public void setSpellBrailleMerge(String spellBrailleMerge) {
        this.spellBrailleMerge = spellBrailleMerge;
    }

    public String getNameHijaiyah() {
        return nameHijaiyah;
    }

    public void setNameHijaiyah(String nameHijaiyah) {
        this.nameHijaiyah = nameHijaiyah;
    }

    public String getNamePunctuation() {
        return namePunctuation;
    }

    public void setNamePunctuation(String namePunctuation) {
        this.namePunctuation = namePunctuation;
    }
}
