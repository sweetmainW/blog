package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.UserMapper;
import po.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	// 注入 userMapper
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 根据用户名查询用户详细信息
	 * @param uname 要查询的用户名字
	 * @return 返回查询到的用户信息
	 * @exception 
	 */
	public User selectByName(String uname) throws Exception{
		User user = userMapper.selectByName(uname);
		return user;
	}

	/**
	 * 创建一个用户
	 * @param user 要被创建的对象
	 * @exception
	 */
	public void insertUser(User user) throws Exception {
		userMapper.insertUser(user);
	}

}
