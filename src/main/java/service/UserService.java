package service;

import po.User;

public interface UserService {
	
	/**
	 * 根据用户名查询用户详细信息
	 * @param uname 要查询的用户名字
	 * @return 返回查询到的用户信息
	 * @exception 
	 */
	public User selectByName(String uname) throws Exception;
	
	/**
	 * 创建一个用户
	 * @param user 要被创建的对象
	 * @exception
	 */
	public void insertUser (User user) throws Exception;
}
