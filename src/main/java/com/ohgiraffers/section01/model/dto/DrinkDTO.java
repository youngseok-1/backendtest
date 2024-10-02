package com.ohgiraffers.section01.model.dto;

import java.time.LocalDate;

public class DrinkDTO {
    private String code;
    private String name;
    private int price;
    private boolean zero;
    private String company;
    private String type;
    private LocalDate expiryDate;
    private String size;

    public DrinkDTO() {}

    public DrinkDTO(String code, String name, int price, boolean zero, String company, String type, LocalDate expiryDate, String size) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.zero = zero;
        this.company = company;
        this.type = type;
        this.expiryDate = expiryDate;
        this.size = size;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getZero() {
        return zero;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getExpiryDate() { // 변경됨
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DrinkDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", zero=" + zero +
                ", company='" + company + '\'' +
                ", type='" + type + '\'' +
                ", expiryDate=" + expiryDate +
                ", size='" + size + '\'' +
                '}';
    }
}