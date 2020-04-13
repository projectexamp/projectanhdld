package ducanh.java.smallproj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ducanh.java.smallproj.model.Users;
import ducanh.java.smallproj.service.UserService;

@Controller
@RequestMapping("/userManagement")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public String searchFormUser() {
		return "user/search-user";
	}
	
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
	public String updateStatus(@RequestParam("userId") Integer userId,@RequestParam("status") Integer status,ModelMap modelMap) {
		Users user= new Users();
		String report="";
		if(userId !=null && status != null) {
			user= userService.updateStatus(userId, status);
			report="update status thanh cong";
		}
		else{
			report="thieu du lieu dau vao";
		}
		modelMap.addAttribute("report", report);  
		modelMap.addAttribute("user", user);  
		return "user/view-user";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("userName") String userName,ModelMap modelMap) {
		List<Users> users= new ArrayList<Users>();
		users=userService.search(userName);
		modelMap.addAttribute("users", users);
		return "user/list-user";
	}
}
