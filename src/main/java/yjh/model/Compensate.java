package yjh.model;

import java.time.LocalDateTime;

public class Compensate {

    private Integer compensateId;
    private Integer voucherDetailId;
    private Integer userId;
    private LocalDateTime compensateDate;
    private String compensateReason;

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

    public String getCompensateReason() {
        return compensateReason;
    }

    public void setCompensateReason(String compensateReason) {
        this.compensateReason = compensateReason;
    }

    @Override
    public String toString() {
        return "Compensate{" +
                "compensateId=" + compensateId +
                ", voucherDetailId=" + voucherDetailId +
                ", userId=" + userId +
                ", compensateDate=" + compensateDate +
                ", compensateReason='" + compensateReason + '\'' +
                '}';
    }
}
