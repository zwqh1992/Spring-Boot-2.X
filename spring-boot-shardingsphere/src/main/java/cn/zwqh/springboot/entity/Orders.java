package cn.zwqh.springboot.entity;

/**
 * @description: 订单
 * @author: zwqh
 * @create: 2021-07-01 15:24
 **/
public class Orders {

    private Integer orderId;
    private Integer orderType;
    private Integer userId;
    private Double orderAmount;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderType=" + orderType +
                ", userId=" + userId +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
