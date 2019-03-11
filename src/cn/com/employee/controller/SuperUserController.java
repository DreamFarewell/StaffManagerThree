package cn.com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.employee.po.UserCustom;
import cn.com.employee.service.UserService;

@Controller
@RequestMapping("/super")
public class SuperUserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户列表
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manageUser")
	public String manageUser(Model model) throws Exception {
		List<UserCustom> userList = userService.getUserList();
		model.addAttribute("userList",userList);
		return "manageUser";
	}
	
	/**
	 * 删除用户
	 * @param user
	 * @param userType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("username")String user,@RequestParam("type")String userType) throws Exception {
		if(user!=null && userType!=null) {
			userService.deleteUser(user, userType);
				return "success";
		}else {
			return "error";
		}
	}
	/**
	 * 更新用户
	 */
	@RequestMapping("/updateUser")
	public String updateUser() throws Exception {
		return "success";
	}
}
