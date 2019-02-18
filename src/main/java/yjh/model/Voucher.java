package yjh.model;

import java.time.LocalDateTime;

public class Voucher {

    private Integer voucherId;
    private LocalDateTime getDate;
    private LocalDateTime takeDate;
    private Double price;
    private String state;
    private Integer userId;
    private String comment;

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public LocalDateTime getGetDate() {
        return getDate;
    }

    public void setGetDate(LocalDateTime getDate) {
        this.getDate = getDate;
    }

    public LocalDateTime getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(LocalDateTime takeDate) {
        this.takeDate = takeDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "voucherId=" + voucherId +
                ", getDate=" + getDate +
                ", takeDate=" + takeDate +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
