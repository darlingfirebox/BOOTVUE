package com.example.bootvue.entity;

public class UserOrder {
    private String order_time;
    private int order_num;
    private int uid;

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "order_time='" + order_time + '\'' +
                ", order_num=" + order_num +
                ", uid=" + uid +
                '}';
    }
}
