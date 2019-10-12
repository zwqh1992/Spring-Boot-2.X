package cn.zwqh.springboot;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zwqh.springboot.model.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests2 {

	@Autowired
	private RedisTemplate<String, String> strRedisTemplate;
	@Autowired
	private RedisTemplate<String, Serializable> serializableRedisTemplate;
	
	@Test
	public void testString() {
		strRedisTemplate.opsForValue().set("strKey", "zwqh");
		System.out.println(strRedisTemplate.opsForValue().get("strKey"));
	}
	
	@Test
	public void testSerializable() {
		UserEntity user=new UserEntity();
		user.setId(1L);
		user.setUserName("朝雾轻寒");
		user.setUserSex("男");		
		serializableRedisTemplate.opsForValue().set("user", user);		
		UserEntity user2 = (UserEntity) serializableRedisTemplate.opsForValue().get("user");
		System.out.println("user:"+user2.getId()+","+user2.getUserName()+","+user2.getUserSex());
	}

}
