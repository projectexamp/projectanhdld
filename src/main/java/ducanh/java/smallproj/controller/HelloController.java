package ducanh.java.smallproj.controller;



import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ducanh.java.smallproj.dao.UserDAO;
import ducanh.java.smallproj.model.Role;
import ducanh.java.smallproj.model.Users;
import ducanh.java.smallproj.service.UserService;

@Controller

public class HelloController {	  
	
	@Autowired UserService userService;
	@Autowired UserDAO userDAO;
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String welcome() {
		  
	    return "index";
	  }
	   
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String getLogin() {
	        return "login";
	    }
	   

		@RequestMapping(value = "/403", method = RequestMethod.GET)
	    public String accessDenied() {
	        return "403";
	    }
		
		@RequestMapping(value = "/test", method = RequestMethod.GET)
	    public String testt() {
			Users user = new Users();
			user=userDAO.findByUserName("admin");
			Set<Role> roles = user.getRoles();
			String name = "fdfd";
			String namse = "32423";
	        return "test";
	    }
		
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logout(HttpServletRequest request, HttpServletResponse response) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null) {
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/login";
		}
}
