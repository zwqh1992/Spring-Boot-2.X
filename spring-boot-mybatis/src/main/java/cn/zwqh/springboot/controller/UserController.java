package cn.zwqh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import cn.zwqh.springboot.dao.UserDao;
import cn.zwqh.springboot.model.UserEntity;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;

	//mapper.xml方式
	/**
	 *  查找所有
	 * @return
	 */
	@RequestMapping("/getAll")
	public List<UserEntity> getAll(){
		return userDao.getAll(); 
	}
	/**
	 * 根据id获取用户
	 * @return
	 */
	@RequestMapping("/getOne")
	public List<UserEntity> getOne(Long id){
		return userDao.getOne(id); 
	}
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String insertUser(UserEntity user) {
		userDao.insertUser(user);
		return "insert success";
	}	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(UserEntity user) {
		userDao.updateUser(user);
		return "update success";
	}
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(Long id) {
		userDao.deleteUser(id);
		return "delete success";
	}	
	/**
	 * 使用pagehelper分页插件
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/pagehelperTest")
	public List<UserEntity> pagehelperTest(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return userDao.getAll(); 
	}
	
	
	
	//使用注解方式
	/**
	 * 获取所有用户
	 * @return
	 */
	@RequestMapping("/getAll2")
	public List<UserEntity> getAll2(){
		return userDao.getAll2(); 
	}
	/**
	 * 根据id获取用户
	 * @return
	 */
	@RequestMapping("/getOne2")
	public List<UserEntity> getOne2(Long id){
		return userDao.getOne2(id); 
	}
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertUser2")
	public String insertUser2(UserEntity user) {
		userDao.insertUser2(user);
		return "insert success";
	}	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser2")
	public String updateUser2(UserEntity user) {
		userDao.updateUser2(user);
		return "update success";
	}
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/deleteUser2")
	public String deleteUser2(Long id) {
		userDao.deleteUser2(id);
		return "delete success";
	}	
	
	
	
	
	
}
