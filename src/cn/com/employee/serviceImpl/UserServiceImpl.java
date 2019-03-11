package cn.com.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.employee.mapper.UserMapper;
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
			//判断用户是否存在于数据库中
			if(userMapper.judgeUser(user.getUser(), user.getUserType())>0) {
				//数据库中存在用户信息，则从数据库获得用户信息
				UserCustom usr = userMapper.getUser(user.getUser());
				//判断页面传入用户信息是否正确
				if(user.getUser().equals(usr.getUser()) && user.getPassword().equals(usr.getPassword()) && user.getUserType().equals(usr.getUserType())) {
					return true;
				}
				return false;
			}
			}else {
				return false;
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
		if(id>0 && userCustom!=null) {
			userMapper.updateUser(id, userCustom);
		}
	}
	/**
	 * 按照主键查询用户
	 */
	@Override
	public UserCustom findUserById(Integer id) throws Exception {
		if(id>0) {
			UserCustom userCustom = userMapper.findUserById(id);
			return userCustom;
		}
		return null;
	}
	/**
	 * 新建用户
	 */
	@Override
	public void insertUser(UserCustom userCustom) throws Exception {
		if(userCustom!=null)
		userMapper.insertUser(userCustom);
	}
	/**
	 * 判断用户是否存在
	 */
	@Override
	public boolean judge(String user, String userType) throws Exception {
		return userMapper.judgeUser(user, userType) > 0 ? false : true;
	}
	/**
	 * 判断密码是否正确
	 */
	@Override
	public boolean judgePassword(UserCustom userCustom) throws Exception {
		if(userCustom!=null) {
			if(userMapper.judgeUser(userCustom.getUser(), userCustom.getUserType())>1) {
				UserCustom user = userMapper.getUser(userCustom.getUser());
				if(user.getUser().equals(userCustom.getUser()) && user.getUserType().equals(userCustom.getUserType()) && !user.getPassword().equals(userCustom.getPassword())) {
					return true;
				}
			}else {
				return false;
			}
		}
		return false;
	}
}
