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

import ducanh.java.smallproj.model.Functions;
import ducanh.java.smallproj.service.FunctionService;


@Controller
@RequestMapping("/functionManagement")
public class FunctionController {
	@Autowired
	FunctionService functionService;
	
	@RequestMapping(value = "/searchFunction", method = RequestMethod.GET)
	public String searchFormFunction() {
		return "search-function";
	}
	
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
	public String updateStatus(@RequestParam("FunctionId") Integer FunctionId,@RequestParam("status") Integer status,ModelMap modelMap) {
		Functions function= new Functions();
		String report="";
		if(FunctionId !=null && status != null) {
			function= functionService.updateStatus(FunctionId, status);
			report="update status thanh cong";
		}
		else{
			report="thieu du lieu dau vao";
		}
		modelMap.addAttribute("report", report);  
		modelMap.addAttribute("function", function);  
		return "view-function";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("functionName") String functionName,ModelMap modelMap) {
		List<Functions> functions= new ArrayList<Functions>();
		functions=functionService.search(functionName);
		modelMap.addAttribute("functions", functions);
		return "list-function";		
	}
	
	@RequestMapping(value = "/addFunction", method = RequestMethod.GET)
	public String addFunction(ModelMap modelMap) {
		modelMap.addAttribute("function", new Functions());
		return "add-function";
	}

	@RequestMapping(value = "/saveFunction", method = RequestMethod.POST)
	public String saveFunction(@ModelAttribute("function") Functions function, ModelMap modelMap) {
		functionService.save(function);
		modelMap.addAttribute("function", function);  
		return "view-function";
	}
	
	@RequestMapping(value = "/viewFunction/{FunctionId}", method = RequestMethod.GET)
	public String viewFunction(@PathVariable("FunctionId") int FunctionId, ModelMap modelMap) {
		Functions function=new Functions();
		function=functionService.getOne(FunctionId);
		modelMap.addAttribute("function", function);  
		return "view-function";
	}
	
	@RequestMapping(value = "/editFunction/{FunctionId}", method = RequestMethod.GET)
	public String editFunction(@PathVariable("FunctionId") int FunctionId, ModelMap modelMap) {
		
		Functions function=new Functions();
		function=functionService.getOne(FunctionId);
		modelMap.addAttribute("function", function);  
		return "edit-function";
	}
}
