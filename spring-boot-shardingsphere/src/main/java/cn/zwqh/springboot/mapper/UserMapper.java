package cn.zwqh.springboot.mapper;

import cn.zwqh.springboot.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

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


    @Insert("insert into t_user(user_id,user_name) values(#{userId},#{userName})")
    void insertUserInfo(UserEntity userEntity);

    @Select("select * from t_user where user_id=#{userId}")
    @Results({
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.INTEGER),
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR)
    })
    UserEntity getUserInfo(Integer userId);


}
