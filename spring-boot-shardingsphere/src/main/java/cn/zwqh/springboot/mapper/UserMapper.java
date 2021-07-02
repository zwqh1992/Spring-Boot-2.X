package cn.zwqh.springboot.mapper;

import cn.zwqh.springboot.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: spring-boot-shardingsphere
 * @description: 用户
 * @author: 朝雾轻寒
 * @create: 2021-07-02 14:24
 **/
@Mapper
public interface UserMapper {

    @Insert("insert into users(user_id,user_name) values(#{userId},#{userName})")
    void insertUser(UserEntity userEntity);

}
