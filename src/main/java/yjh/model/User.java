package yjh.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class User {

    private Integer userId;
    private String username;
    private String password;
    private String userType;
    private String gender;
    private String phone;
    private String address;
    private Double balance;
    private Double totalConsume;
    private Integer consumeTimes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:SS")
    private LocalDateTime registerDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(Double totalConsume) {
        this.totalConsume = totalConsume;
    }

    public Integer getConsumeTimes() {
        return consumeTimes;
    }

    public void setConsumeTimes(Integer consumeTimes) {
        this.consumeTimes = consumeTimes;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", totalConsume=" + totalConsume +
                ", consumeTimes=" + consumeTimes +
                ", registerDate=" + registerDate +
                '}';
    }

}
