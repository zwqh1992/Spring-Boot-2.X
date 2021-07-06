package cn.zwqh.springboot.hint.entity;

import java.io.Serializable;

public class Order implements Serializable {
    
    private static final long serialVersionUID = 661434701950670670L;
    
    private long orderId;
    
    private int userId;
    
    private long addressId;
    
    private String status;
    
    public long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(final long orderId) {
        this.orderId = orderId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public long getAddressId() {
        return addressId;
    }
    
    public void setAddressId(final long addressId) {
        this.addressId = addressId;
    }
    
    @Override
    public String toString() {
        return String.format("order_id: %s, user_id: %s, address_id: %s, status: %s", orderId, userId, addressId, status);
    }
}