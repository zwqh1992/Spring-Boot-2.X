package cn.zwqh.springboot.mapper;

import cn.zwqh.springboot.entity.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

/**
 * @program: spring-boot-shardingsphere
 * @description: 订单
 * @author: zwqh
 * @create: 2021-07-01 15:23
 **/
@Repository
@Mapper
public interface OrdersMapper {

    @Insert("insert into t_orders(order_id,order_type,user_id,order_amount) values(#{orderId},#{orderType},#{userId},#{orderAmount})")
    void insert(Orders orders);

    @Select("select * from t_orders where order_id = #{orderId}")
    @Results({
            @Result(property = "orderId", column = "order_id",jdbcType = JdbcType.INTEGER),
            @Result(property = "orderType", column = "order_type",jdbcType = JdbcType.INTEGER),
            @Result(property = "userId", column = "user_id",jdbcType = JdbcType.INTEGER),
            @Result(property = "orderAmount", column = "order_amount",jdbcType = JdbcType.DOUBLE)
    })
    Orders selectOne(Integer orderId);
}
