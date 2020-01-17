package cn.zwqh.springboot.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.zwqh.springboot.dao.UserDao;
import cn.zwqh.springboot.model.UserEntity;

@RestController
@RequestMapping(value="user")
public class UserController {

	@Autowired
	private UserDao userDao;
	/**
	 * 新增用户  http://127.0.0.1:8080/user/insert
	 * @return
	 */
	@RequestMapping(value="insert")
	public String insert() {
		UserEntity user=new UserEntity();
		user.setUserName("朝雾轻寒");
		user.setUserSex("男");
		userDao.insert(user); 
		return "insert success";
	}
	/**
	 * 根据id修改用户  http://127.0.0.1:8080/user/updateById
	 * @return
	 */
	@RequestMapping(value="updateById")
	public String updateById(){
		UserEntity user=new UserEntity();
		user.setUserName("朝雾轻晓");
		user.setUserSex("男");
		user.setId(25L);
		userDao.updateById(user);
		return "update success";
	}
	
	/**
	 * 根据entity条件修改信息  http://127.0.0.1:8080/user/update
	 * @return
	 */
	@RequestMapping(value="update")
	public String update(){
		UserEntity user=new UserEntity();
		user.setUserSex("女");
		userDao.update(user,new QueryWrapper<UserEntity>().eq("user_name", "朝雾轻寒"));
		return "update success";
	}
	
	/**
	 * 根据id查询用户   http://127.0.0.1:8080/user/selectById?id=1
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectById")
	public UserEntity selectById(Long id) {	
		return userDao.selectById(id);
	}
	/**
	 * 根据entity条件查询总记录数   http://127.0.0.1:8080/user/selectCount?sex=男
	 * @param sex
	 * @return
	 */
	@RequestMapping(value="selectCount")
	public int selectCount(String sex) {	
		return userDao.selectCount(new QueryWrapper<UserEntity>().eq("user_sex", sex));
	}
	/**
	 * 根据 entity 条件，查询一条记录，返回的是实体，如果表内有两条或以上的相同数据则会报错，可以用来判断某类数据是否已存在  http://127.0.0.1:8080/user/selectOne?username=朝雾轻寒&sex=男  
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectOne")
	public UserEntity selectOne(String username,String sex) {	
		QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<UserEntity>();
		UserEntity user=new UserEntity();
		user.setUserName(username);
		user.setUserSex(sex);
		queryWrapper.setEntity(user);
		return userDao.selectOne(queryWrapper);
	}
	/**
	 * 根据entity条件查询返回第一个字段的值（返回id列表）  http://127.0.0.1:8080/user/selectObjs?sex=男
	 * @param sex
	 * @return
	 */
	@RequestMapping(value="selectObjs")
	public List<Object> selectObjs(String sex) {	
		QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<UserEntity>();
		UserEntity user=new UserEntity();
		user.setUserSex(sex);
		queryWrapper.setEntity(user);
		return userDao.selectObjs(queryWrapper);
	}
	/**
	 * 根据map条件查询返回多条数据   http://127.0.0.1:8080/user/selectByMap?username=朝雾轻寒&sex=男 
	 * @param username
	 * @param sex
	 * @return
	 */
	@RequestMapping(value="selectByMap")
	public List<UserEntity> selectByMap(String username,String sex) {	
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user_name", username);
		map.put("user_sex",sex);
		return userDao.selectByMap(map);
	}
	
	/**
	 * 根据entity条件查询返回多条数据 http://127.0.0.1:8080/user/selectList?sex=男
	 * @param sex
	 * @return
	 */
	@RequestMapping(value="selectList")
	public List<UserEntity> selectList(String sex) {	
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user_sex",sex);
		return userDao.selectList(new QueryWrapper<UserEntity>().allEq(map));
	}
	/**
	 * 根据entity条件查询返回多条数据 http://127.0.0.1:8080/user/selectMaps?sex=男
	 * @param sex
	 * @return
	 */
	@RequestMapping(value="selectMaps")
	public List<Map<String, Object>> selectMaps(String sex) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user_sex",sex);
		return userDao.selectMaps(new QueryWrapper<UserEntity>().allEq(map));
	}
	
	
	
	/**
	 * 根据ID批量查询,主键ID列表(不能为 null 以及 empty) http://127.0.0.1:8080/user/selectBatchIds
	 * @return
	 */
	@RequestMapping(value="selectBatchIds")
	public List<UserEntity> selectBatchIds() {	
		List<Long> ids=new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(3L);
		return userDao.selectBatchIds(ids);
	}
	
	/**
	 * 分页查询，需先配置分页插件bean，否则分页无效（如有pagehelper需先去除）   http://127.0.0.1:8080/user/selectPage
	 * @return
	 */
	@RequestMapping(value="selectPage")
	public Page<UserEntity> selectPage() {	
		Page<UserEntity> page=userDao.selectPage(new Page<>(1,5), new QueryWrapper<UserEntity>().eq("user_sex", "男"));
		System.out.println("records:"+page.getRecords());
		return page;
	}
	/**
	 * 分页查询，需先配置分页插件bean，否则分页无效（如有pagehelper需先去除）   http://127.0.0.1:8080/user/selectPage
	 * @return
	 */
	@RequestMapping(value="selectMapsPage")
	public Page<Map<String, Object>> selectMapsPage() {	
		Page<Map<String, Object>> page=userDao.selectMapsPage(new Page<>(1,5), new QueryWrapper<UserEntity>().eq("user_sex", "男"));
		System.out.println("records:"+page.getRecords());
		return page;
	}
	
	/**
	 * 根据id删除用户  http://127.0.0.1:8080/user/deleteById?id=24
	 * @return
	 */
	@RequestMapping(value="deleteById")
	public String deleteById(Long id){
		userDao.deleteById(id);
		return "delete success";
	}
	
	/**
	 * 根据entity条件删除用户  http://127.0.0.1:8080/user/delete?id=24
	 * @return
	 */
	@RequestMapping(value="delete")
	public String delete(Long id){
		userDao.delete(new QueryWrapper<UserEntity>().eq("id", id));
		return "delete success";
	}
	
	/**
	 * 根据map条件删除用户  http://127.0.0.1:8080/user/deleteByMap?username=xx&sex=x
	 * @return
	 */
	@RequestMapping(value="deleteByMap")
	public String deleteByMap(String username,String sex){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user_name", username);
		map.put("user_sex",sex);
		userDao.deleteByMap(map);
		return "delete success";
	}
	
	/**
	 * 根据ID批量删除,主键ID列表(不能为 null 以及 empty) http://127.0.0.1:8080/user/deleteBatchIds
	 * @return
	 */
	@RequestMapping(value="deleteBatchIds")
	public String deleteBatchIds() {	
		List<Long> ids=new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(3L);
		userDao.deleteBatchIds(ids);
		return "delete success";
	}
	
	
	
	
	
}
