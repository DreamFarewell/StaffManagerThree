package cn.com.employee.service;

import java.util.List;

import cn.com.employee.po.UserCustom;

public interface UserService {
	//用户
	boolean getUser(UserCustom user) throws Exception;
	//获得用户列表
	List<UserCustom> getUserList() throws Exception;
	//删除用户
	void deleteUser(String user,String userType) throws Exception;
	//更新用户
	void updateUser(Integer id,UserCustom userCustom) throws Exception;
}
