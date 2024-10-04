package com.ohgiraffers.section01.model.dto;

public class SellDTO {
    private String sellCode;
    private String isAvailable;
    private String drinkCode;

    public SellDTO(String sellCode, String isAvailable, String drinkCode) {
        this.sellCode = sellCode;
        this.isAvailable = isAvailable;
        this.drinkCode = drinkCode;
    }

    public String getSellCode() {
        return sellCode;
    }

    public void setSellCode(String sellCode) {
        this.sellCode = sellCode;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getDrinkCode() {
        return drinkCode;
    }

    public void setDrinkCode(String drinkCode) {
        this.drinkCode = drinkCode;
    }

    @Override
    public String toString() {
        return "SellDTO{" +
                "sellCode='" + sellCode + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                ", drinkCode='" + drinkCode + '\'' +
                '}';
    }
}