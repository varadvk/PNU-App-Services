package com.uni.pnu.entity;

public class OrderDetails {

    private String key;
    private String orderId;
    private Integer amount;
    private String currency;

    public OrderDetails(String key, String orderId, Integer amount, String currency) {
        this.key = key;
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
