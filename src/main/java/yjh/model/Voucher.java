package yjh.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class Voucher {

    private Integer voucherId;
    private LocalDateTime getDate;
    private String takeDate;
    private Double price;
    private String state;
    private Integer userId;
    //正在洗衣 洗衣完成 已被取走
    private String comment;

    //非数据库字段, 收衣单与收衣单明细为一对多关系
    private List<VoucherDetail> voucherDetailList;
    private User user;

    public List<VoucherDetail> getVoucherDetailList() {
        return voucherDetailList;
    }

    public void setVoucherDetailList(List<VoucherDetail> voucherDetailList) {
        this.voucherDetailList = voucherDetailList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(String takeDate) {
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
