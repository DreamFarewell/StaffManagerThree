/**
 *<p>Title:LoginController.java</p>
 *<p>Description:</p>
 *<p></p>
 *<p></p>
 *@date 2019年2月16日
 *@author 胡金光
 */
package cn.com.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.employee.po.UserCustom;
import cn.com.employee.service.UserService;

/**
 * @author 胡金光
 *
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(Model model,HttpSession session ,String userType, String user, String password) throws Exception {
		//判断页面传过来的值是否为空
		UserCustom uc = new UserCustom();
			uc.setUser(user);
			uc.setPassword(password);
			uc.setUserType(userType);
			
			boolean pd = userService.getUser(uc);
			//如果信息和数据库中的匹配,则进行跳转
			if(pd) {
				//如果是普通管理员用户，则跳转到相应的页面；如果是超级管理员用户，则亦然
				if(userType.replace("", "").equals("ordinary")) {
					session.setAttribute("username", uc.getUser());
					session.setAttribute("userType", uc.getUserType());
					return "redirect:/employee/employeeAllSubmit.action";
				}else if(userType.replace("", "").equals("super")) {
					session.setAttribute("username", uc.getUser());
					session.setAttribute("userType", uc.getUserType());
					return "redirect:/super/manageUser.action";
				}
			}else {
				model.addAttribute("lose", "用户信息不存在");
				return "login";
			}
		session.invalidate();
		model.addAttribute("lose", "账号或密码不正确，请重新输入！");
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/employee/employeeAllSubmit.action";
		
	}
}
