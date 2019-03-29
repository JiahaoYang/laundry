package yjh.model;


public class Clothes {

    private Integer clothesId;
    private String clothesName;
    private String brand;
    private String color;
    private String flaw;

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFlaw() {
        return flaw;
    }

    public void setFlaw(String flaw) {
        this.flaw = flaw;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "clothesId=" + clothesId +
                ", clothesName='" + clothesName + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", flaw='" + flaw + '\'' +
                '}';
    }
}
