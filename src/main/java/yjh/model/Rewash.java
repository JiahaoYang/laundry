package yjh.model;

import java.time.LocalDateTime;

public class Rewash {

    private Integer rewashId;
    private Integer voucherDetailId;
    private Integer userId;
    private LocalDateTime rewashDate;
    private LocalDateTime takeDate;
    private String rewashReason;

    public Integer getRewashId() {
        return rewashId;
    }

    public void setRewashId(Integer rewashId) {
        this.rewashId = rewashId;
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

    public LocalDateTime getRewashDate() {
        return rewashDate;
    }

    public void setRewashDate(LocalDateTime rewashDate) {
        this.rewashDate = rewashDate;
    }

    public LocalDateTime getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(LocalDateTime takeDate) {
        this.takeDate = takeDate;
    }

    public String getRewashReason() {
        return rewashReason;
    }

    public void setRewashReason(String rewashReason) {
        this.rewashReason = rewashReason;
    }

    @Override
    public String toString() {
        return "Rewash{" +
                "rewashId=" + rewashId +
                ", voucherDetailId=" + voucherDetailId +
                ", userId=" + userId +
                ", rewashDate=" + rewashDate +
                ", takeDate=" + takeDate +
                ", rewashReason='" + rewashReason + '\'' +
                '}';
    }
}
