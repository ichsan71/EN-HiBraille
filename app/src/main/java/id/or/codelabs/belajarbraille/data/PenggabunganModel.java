package id.or.codelabs.belajarbraille.data;

import java.util.List;

public class PenggabunganModel {
    private int imagePenggabungan;
    private String namePenggabungan;
    private String nameHijaiyah;
    private String nameTandaBaca;
    private String spellPenggabungan;
    private String brailleDotsPenggabungan;
    private List<Integer> listBrailleDotsHijaiyah;
    private List<Integer> listBrailleDotsTandaBaca;

    public PenggabunganModel(int imagePenggabungan, String namePenggabungan, String nameHijaiyah,
                             String nameTandaBaca, String spellPenggabungan,
                             String brailleDotsPenggabungan, List<Integer> listBrailleDotsHijaiyah,
                             List<Integer> listBrailleDotsTandaBaca) {
        this.imagePenggabungan = imagePenggabungan;
        this.namePenggabungan = namePenggabungan;
        this.nameHijaiyah = nameHijaiyah;
        this.nameTandaBaca = nameTandaBaca;
        this.spellPenggabungan = spellPenggabungan;
        this.brailleDotsPenggabungan = brailleDotsPenggabungan;
        this.listBrailleDotsHijaiyah = listBrailleDotsHijaiyah;
        this.listBrailleDotsTandaBaca = listBrailleDotsTandaBaca;
    }

    public int getImagePenggabungan() {
        return imagePenggabungan;
    }

    public void setImagePenggabungan(int imagePenggabungan) {
        this.imagePenggabungan = imagePenggabungan;
    }

    public String getNamePenggabungan() {
        return namePenggabungan;
    }

    public void setNamePenggabungan(String namePenggabungan) {
        this.namePenggabungan = namePenggabungan;
    }

    public String getBrailleDotsPenggabungan() {
        return brailleDotsPenggabungan;
    }

    public void setBrailleDotsPenggabungan(String brailleDotsPenggabungan) {
        this.brailleDotsPenggabungan = brailleDotsPenggabungan;
    }

    public List<Integer> getListBrailleDotsHijaiyah() {
        return listBrailleDotsHijaiyah;
    }

    public void setListBrailleDotsHijaiyah(List<Integer> listBrailleDotsHijaiyah) {
        this.listBrailleDotsHijaiyah = listBrailleDotsHijaiyah;
    }

    public List<Integer> getListBrailleDotsTandaBaca() {
        return listBrailleDotsTandaBaca;
    }

    public void setListBrailleDotsTandaBaca(List<Integer> listBrailleDotsTandaBaca) {
        this.listBrailleDotsTandaBaca = listBrailleDotsTandaBaca;
    }

    public String getSpellPenggabungan() {
        return spellPenggabungan;
    }

    public void setSpellPenggabungan(String spellPenggabungan) {
        this.spellPenggabungan = spellPenggabungan;
    }

    public String getNameHijaiyah() {
        return nameHijaiyah;
    }

    public void setNameHijaiyah(String nameHijaiyah) {
        this.nameHijaiyah = nameHijaiyah;
    }

    public String getNameTandaBaca() {
        return nameTandaBaca;
    }

    public void setNameTandaBaca(String nameTandaBaca) {
        this.nameTandaBaca = nameTandaBaca;
    }
}
