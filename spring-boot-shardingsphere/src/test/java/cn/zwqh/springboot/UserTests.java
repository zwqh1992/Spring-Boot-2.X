package cn.zwqh.springboot;

import cn.zwqh.springboot.entity.UserEntity;
import cn.zwqh.springboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 用户测试
 * @author: 朝雾轻寒
 * @create: 2021-07-02 14:26
 **/
@SpringBootTest
public class UserTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void insertUser() {
        for (int i = 1; i <= 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(i);
            userEntity.setUserName("user" + i);
            userMapper.insertUser(userEntity);
        }
    }

    @Test
    public void insertUserInfo() {
        for (int i = 1; i <= 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(i);
            userEntity.setUserName("user" + i);
            userMapper.insertUserInfo(userEntity);
        }
    }


    @Test
    public void getUserInfo() {
        System.out.println(userMapper.getUserInfo(1));
    }
}
