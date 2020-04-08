package ducanh.java.smallproj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ducanh.java.smallproj.model.Role;



@Repository
@Transactional(rollbackFor = Exception.class)
public class RoleDAO {
	 @Autowired
	  private SessionFactory sessionFactory;
	 public List<Role> search (String roleName){
		 Session session = sessionFactory.getCurrentSession();
		 String queryStr="FROM Role r WHERE r.status != 2";
		 if(roleName!=null && roleName !="")
			 {
			 queryStr="FROM Role r WHERE r.status != 2 AND r.roleName LIKE concat('%',:likeRoleName,'%')";
			 }
		 Query<Role> query = session.createQuery(queryStr, Role.class);
		 if(roleName!=null && roleName !="")
			 query.setParameter("likeRoleName", roleName);
		 List<Role> roles = query.getResultList();
		 return roles;
	 }
	 
	 public void save (Role role) {
		 Session session = sessionFactory.getCurrentSession();
		 session.saveOrUpdate(role);
	 }
	 
	 
	 public Role getOne(int roleId){
		 Session session = sessionFactory.getCurrentSession();
		 Role role=new Role();
		 role =  (Role) session.get(Role.class, roleId);		 
		 return role;
	 }
	 
	 
	 public Role updateStatus(int roleId,int status) {
		 Role role = new Role();
		 try {
			 Session session = sessionFactory.getCurrentSession();
			  role =  (Role) session.get(Role.class, roleId);
			  role.setStatus(status);
			  session.update(role);
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 return role;
	 }
}
