package cn.zwqh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.zwqh.springboot.dao.UserDao;
import cn.zwqh.springboot.model.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(tags = { "接口分组1", "接口分组2" })
@ApiResponses({ @ApiResponse(code = 404, message = "Page Not Found"),
		@ApiResponse(code = 403, message = "Forbidden") })
public class ApiController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/getAllUser")
	@ApiOperation(value = "获取所有用户", notes = "", httpMethod = "GET", tags = "接口分组3")
	public List<UserEntity> getAll() {
		return userDao.getAll();
	}

	@GetMapping("/getUserById")
	@ApiOperation(value = "根据id获取用户", notes = "id必传", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "用户id", example = "1", required = true, dataType = "long", paramType = "query")
	public UserEntity getOne(Long id) {
		return userDao.getOne(id);
	}

	@PostMapping("/getUserByNameAndSex")
	@ApiOperation(value = "根据name和sex获取用户", notes = "", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userName", value = "用户名", example = "关羽", required = true, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "userSex", value = "用户性别", example = "男", required = true, dataType = "string", paramType = "query") })
	public UserEntity getUserByNameAndSex(String userName, String userSex) {
		return userDao.getUserByNameAndSex(userName, userSex);
	}

	@PostMapping("/insertUser")
	@ApiOperation(value = "新增用户", notes = "传json，数据放body", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "body", value = "用户对象json", example = "{userName:'朝雾轻寒',userSex:'男'}", required = true) })
	public String insertUser(@RequestBody String body) {
		System.out.println(body);
		UserEntity user = JSON.parseObject(body, UserEntity.class);
		userDao.insertUser(user);
		return "{code:0,msg:'success'}";
	}

	@PostMapping("/updateUser")
	@ApiOperation(value = "修改用户", notes = "传json，数据放body", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "body", value = "用户对象json", example = "{id:23,userName:'朝雾轻寒',userSex:'女'}", required = true) })
	public String updateUser(@RequestBody String body) {
		System.out.println(body);
		UserEntity user = JSON.parseObject(body, UserEntity.class);
		userDao.updateUser(user);
		return "{code:0,msg:'success'}";
	}

	@PostMapping("/deleteUser")
	@ApiOperation(value = "删除用户", notes = "id必传", httpMethod = "POST")
	public String deleteUser(@ApiParam(name = "id", value = "用户id", required = true) Long id) {
		userDao.deleteUser(id);
		return "{code:0,msg:'success'}";
	}
}
