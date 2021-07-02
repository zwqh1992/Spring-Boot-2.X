package cn.zwqh.springboot;

import cn.zwqh.springboot.entity.OrderType;
import cn.zwqh.springboot.mapper.OrderTypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 订单类型
 * @author: 朝雾轻寒
 * @create: 2021-07-02 15:11
 **/
@SpringBootTest
public class OrderTypeTests {

    @Resource
    private OrderTypeMapper orderTypeMapper;

    @Test
    public void insertOrderType() {
        OrderType orderType1 = new OrderType();
        orderType1.setTypeId(1);
        orderType1.setTypeName("集采批发");
        OrderType orderType2 = new OrderType();
        orderType2.setTypeId(2);
        orderType2.setTypeName("集采代发");
        OrderType orderType3 = new OrderType();
        orderType3.setTypeId(3);
        orderType3.setTypeName("一件代发");

        orderTypeMapper.insertOrderType(orderType1);
        orderTypeMapper.insertOrderType(orderType2);
        orderTypeMapper.insertOrderType(orderType3);

    }
}
