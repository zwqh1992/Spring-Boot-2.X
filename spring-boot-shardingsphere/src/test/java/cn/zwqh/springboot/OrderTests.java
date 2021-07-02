package cn.zwqh.springboot;

import cn.zwqh.springboot.entity.Orders;
import cn.zwqh.springboot.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 测试
 * @author: zwqh
 * @create: 2021-07-01 15:26
 **/
@SpringBootTest
public class OrderTests {

    @Resource
    private OrdersMapper ordersMapper;

    @Test
    public void addOrders() {
        for (int i = 1; i <= 10; i++) {
            Orders orders = new Orders();
            orders.setOrderId(i);
            orders.setUserId(i % 3);
            orders.setOrderType(i % 2);
            orders.setOrderAmount(1000.0 * i);
            ordersMapper.insert(orders);
        }
    }

    @Test
    public void queryOrders() {
        Orders orders = ordersMapper.selectOne(1);
        System.out.println(orders);
    }


}
