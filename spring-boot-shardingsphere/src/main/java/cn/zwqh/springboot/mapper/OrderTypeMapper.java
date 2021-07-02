package cn.zwqh.springboot.mapper;

import cn.zwqh.springboot.entity.OrderType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 订单类型
 * @author: 朝雾轻寒
 * @create: 2021-07-02 15:09
 **/
@Mapper
public interface OrderTypeMapper {

    @Insert("insert into t_order_type(type_id,type_name) values(#{typeId},#{typeName})")
    void insertOrderType(OrderType orderType);

}
