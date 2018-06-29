package id.or.codelabs.belajarbraille.data;

public class TandaBacaModel {
    private int imageTandaBaca;
    private String nameTandaBaca;
    private String brailleDotsTandaBaca;

    public TandaBacaModel(int imageTandaBaca, String nameTandaBaca, String brailleDotsTandaBaca) {
        this.imageTandaBaca = imageTandaBaca;
        this.nameTandaBaca = nameTandaBaca;
        this.brailleDotsTandaBaca = brailleDotsTandaBaca;
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
}
