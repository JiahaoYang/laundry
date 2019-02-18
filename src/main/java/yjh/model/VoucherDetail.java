package yjh.model;

public class VoucherDetail {

    private Integer voucherDetailId;
    private Integer voucherId;
    private Integer clothesId;
    private Double washPrice;
    private Integer clothesAmount;
    private String isTaken;
    private String isRewash;
    private String isCompensate;
    private String comment;

    public Integer getVoucherDetailId() {
        return voucherDetailId;
    }

    public void setVoucherDetailId(Integer voucherDetailId) {
        this.voucherDetailId = voucherDetailId;
    }

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public Double getWashPrice() {
        return washPrice;
    }

    public void setWashPrice(Double washPrice) {
        this.washPrice = washPrice;
    }

    public Integer getClothesAmount() {
        return clothesAmount;
    }

    public void setClothesAmount(Integer clothesAmount) {
        this.clothesAmount = clothesAmount;
    }

    public String getIsTaken() {
        return isTaken;
    }

    public void setIsTaken(String isTaken) {
        this.isTaken = isTaken;
    }

    public String getIsRewash() {
        return isRewash;
    }

    public void setIsRewash(String isRewash) {
        this.isRewash = isRewash;
    }

    public String getIsCompensate() {
        return isCompensate;
    }

    public void setIsCompensate(String isCompensate) {
        this.isCompensate = isCompensate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "VoucherDetail{" +
                "voucherDetailId=" + voucherDetailId +
                ", voucherId=" + voucherId +
                ", clothesId=" + clothesId +
                ", washPrice=" + washPrice +
                ", clothesAmount=" + clothesAmount +
                ", isTaken='" + isTaken + '\'' +
                ", isRewash='" + isRewash + '\'' +
                ", isCompensate='" + isCompensate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
