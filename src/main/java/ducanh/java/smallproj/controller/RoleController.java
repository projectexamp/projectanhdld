package ducanh.java.smallproj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ducanh.java.smallproj.model.Role;
import ducanh.java.smallproj.service.RoleService;


@Controller
@RequestMapping("/roleManagement")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/searchRole", method = RequestMethod.GET)
	public String searchFormRole() {
		return "role/search-role";
	}
	
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
	public String updateStatus(@RequestParam("roleId") Integer roleId,@RequestParam("status") Integer status,ModelMap modelMap) {
		Role role= new Role();
		String report="";
		if(roleId !=null && status != null) {
			role= roleService.updateStatus(roleId, status);
			report="update status thanh cong";
		}
		else{
			report="thieu du lieu dau vao";
		}
		modelMap.addAttribute("report", report);  
		modelMap.addAttribute("role", role);  
		return "role/view-role";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("roleName") String roleName,ModelMap modelMap) {
		List<Role> roles= new ArrayList<Role>();
		roles=roleService.search(roleName);
		modelMap.addAttribute("roles", roles);
		return "role/list-role";		
	}
	
	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	public String addRole(ModelMap modelMap) {
		modelMap.addAttribute("role", new Role());
		return "role/add-role";
	}

	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public String saveRole(@ModelAttribute("role") Role role, ModelMap modelMap) {
		roleService.save(role);
		modelMap.addAttribute("role", role);  
		return "role/view-role";
	}
	
	@RequestMapping(value = "/viewRole/{roleId}", method = RequestMethod.GET)
	public String viewRole(@PathVariable("roleId") int roleId, ModelMap modelMap) {
		Role role=new Role();
		role=roleService.getOne(roleId);
		modelMap.addAttribute("role", role);  
		return "role/view-role";
	}
	
	@RequestMapping(value = "/editRole/{roleId}", method = RequestMethod.GET)
	public String editRole(@PathVariable("roleId") int roleId, ModelMap modelMap) {
		
		Role role=new Role();
		role=roleService.getOne(roleId);
		modelMap.addAttribute("role", role);  
		return "role/edit-role";
	}
}
