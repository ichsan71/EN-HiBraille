package id.or.codelabs.belajarbraille.data;

public class PenggabunganModel {
    private int imagePenggabungan;
    private String namePenggabungan;
    private String brailleDotsPenggabungan;

    public PenggabunganModel(int imagePenggabungan, String namePenggabungan, String brailleDotsPenggabungan) {
        this.imagePenggabungan = imagePenggabungan;
        this.namePenggabungan = namePenggabungan;
        this.brailleDotsPenggabungan = brailleDotsPenggabungan;
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
}
