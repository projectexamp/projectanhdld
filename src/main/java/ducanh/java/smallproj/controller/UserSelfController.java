 package ducanh.java.smallproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ducanh.java.smallproj.model.Users;
import ducanh.java.smallproj.service.UserService;

@Controller
@RequestMapping("/userSelfManagement")
public class UserSelfController {
	
	@Autowired
	UserService userService;
	
	   @Autowired 
	   PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(ModelMap modelMap) {
		modelMap.addAttribute("user", new Users());
		return "user/add-user";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Users user, ModelMap modelMap) {
		String rawPassword = user.getPassword();
		user.setPassword(passwordEncoder.encode(rawPassword));
		userService.save(user);
		modelMap.addAttribute("user", user);  
		return "user/view-user";
	}
	
	@RequestMapping(value = "/viewUser/{userId}", method = RequestMethod.GET)
	public String viewUser(@PathVariable("userId") int userId, ModelMap modelMap) {
		Users user=new Users();
		user=userService.getOne(userId);
		modelMap.addAttribute("user", user);  
		return "user/view-user";
	}
	
	@RequestMapping(value = "/editUser/{userId}", method = RequestMethod.GET)
	public String editUser(@PathVariable("userId") int userId, ModelMap modelMap) {
		
		Users user=new Users();
		user=userService.getOne(userId);
		modelMap.addAttribute("user", user);  
		return "user/edit-user";
	}
	

}
