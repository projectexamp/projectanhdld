package ducanh.java.smallproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ducanh.java.smallproj.dao.RoleDAO;
import ducanh.java.smallproj.model.Role;


@Service
public class RoleService {
	@Autowired RoleDAO roleDAO;
	
	 public List<Role> search(String roleName){
		 List<Role> roles = roleDAO.search(roleName);
		 return roles;
	 }
	
	 public void save (Role role) {		 
		 roleDAO.save(role);
	 }
	 
	 public Role getOne(int roleId) {
		 return roleDAO.getOne(roleId);
	 }
	 
	 public Role updateStatus(int roleId,int status) {
		 return roleDAO.updateStatus(roleId, status);
	 }
	 
}
