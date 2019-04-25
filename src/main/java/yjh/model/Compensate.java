package yjh.model;

import java.time.LocalDateTime;

public class Compensate {

    private Integer compensateId;
    private Integer voucherDetailId;
    private Integer userId;
    private LocalDateTime compensateDate;

    private VoucherDetail voucherDetail;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public VoucherDetail getVoucherDetail() {
        return voucherDetail;
    }

    public void setVoucherDetail(VoucherDetail voucherDetail) {
        this.voucherDetail = voucherDetail;
    }

    public Integer getCompensateId() {
        return compensateId;
    }

    public void setCompensateId(Integer compensateId) {
        this.compensateId = compensateId;
    }

    public Integer getVoucherDetailId() {
        return voucherDetailId;
    }

    public void setVoucherDetailId(Integer voucherDetailId) {
        this.voucherDetailId = voucherDetailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getCompensateDate() {
        return compensateDate;
    }

    public void setCompensateDate(LocalDateTime compensateDate) {
        this.compensateDate = compensateDate;
    }


    @Override
    public String toString() {
        return "Compensate{" +
                "compensateId=" + compensateId +
                ", voucherDetailId=" + voucherDetailId +
                ", userId=" + userId +
                ", compensateDate=" + compensateDate +
                '}';
    }
}
