package ducanh.java.smallproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ducanh.java.smallproj.dao.UserDAO;
import ducanh.java.smallproj.model.Users;

@Service
public class UserService {
	@Autowired UserDAO userDAO;
	
	 public List<Users> search(String userName){
		 List<Users> users = userDAO.search(userName);
		 return users;
	 }
	
	 public void save (Users user) {		 
		 userDAO.save(user);
	 }
	 
	 public Users getOne(int userId) {
		 return userDAO.getOne(userId);
	 }
	 
	 public Users updateStatus(int userId,int status) {
		 return userDAO.updateStatus(userId, status);
	 }
	 
	 
}
