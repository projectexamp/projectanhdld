package ducanh.java.smallproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ducanh.java.smallproj.dao.FunctionDAO;
import ducanh.java.smallproj.model.Functions;

@Service
public class FunctionService {
	@Autowired FunctionDAO functionDAO;
	
	 public List<Functions> search(String functionName){
		 List<Functions> functions = functionDAO.search(functionName);
		 return functions;
	 }
	
	 public void save (Functions role) {		 
		 functionDAO.save(role);
	 }
	 
	 public Functions getOne(int functionId) {
		 return functionDAO.getOne(functionId);
	 }
	 
	 public Functions updateStatus(int functionId,int status) {
		 return functionDAO.updateStatus(functionId, status);
	 }
}
