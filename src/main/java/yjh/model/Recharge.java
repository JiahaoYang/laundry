package yjh.model;

import java.time.LocalDateTime;

public class Recharge {

    private Integer rechargeId;
    private Integer userId;
    private Double money;
    private LocalDateTime rechargeDate;

    public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDateTime getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(LocalDateTime rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "rechargeId=" + rechargeId +
                ", userId=" + userId +
                ", money=" + money +
                ", rechargeDate=" + rechargeDate +
                '}';
    }
}
