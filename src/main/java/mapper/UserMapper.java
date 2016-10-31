package mapper;

import org.apache.ibatis.annotations.Param;

import po.User;

public interface UserMapper {

	// 根据主键 uid 删除 用户
    void deleteByPrimaryKey(@Param(value = "uid")Integer uid);
    // 插入一个新用户
    void insertUser(User user);
    // 根据 uid 查找用户
    User selectByPrimaryKey(@Param(value = "uid")Integer uid);
    // 根据 uid 更新用户
    void updateByPrimaryKey(User user);
    
 // 根据用户名 模糊查询 用户
 	 User selectByName(@Param(value = "uname") String uname);
}