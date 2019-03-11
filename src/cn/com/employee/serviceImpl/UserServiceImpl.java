package cn.com.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.employee.mapper.UserMapper;
import cn.com.employee.po.User;
import cn.com.employee.po.UserCustom;
import cn.com.employee.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	/**
	 * 登录服务
	 */
	@Override
	public boolean getUser(UserCustom user) throws Exception {
		if(user!=null) {
			//从数据库获得用户信息
			User usr = userMapper.getUser(user.getUser());
			//判断页面传入用户信息是否正确
			if(user.getUser().equals(usr.getUser()) && user.getPassword().equals(usr.getPassword()) && user.getUserType().equals(usr.getUserType())) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	/**
	 * 用户列表
	 */
	@Override
	public List<UserCustom> getUserList() throws Exception {
		List<UserCustom> list = userMapper.getUserList();
		return list;
	}
	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(String user, String userType) throws Exception {
		if(user!=null && userType!=null) userMapper.deleteUser(user, userType);
	}
	/**
	 * 更新用户
	 */
	@Override
	public void updateUser(Integer id, UserCustom userCustom) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
