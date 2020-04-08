package ducanh.java.smallproj.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ducanh.java.smallproj.model.Users;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAO {
	 @Autowired
	  private SessionFactory sessionFactory;
	 
	 public List<Users> search (String userName){
		 Session session = sessionFactory.getCurrentSession();
		 String queryStr="FROM Users u WHERE u.status != 2";
		 if(userName!=null && userName !="")
			 {
			 queryStr="FROM Users u WHERE u.status != 2 AND u.userName LIKE concat('%',:likeUserName,'%')";
			 }
		 Query<Users> query = session.createQuery(queryStr, Users.class);
		 if(userName!=null && userName !="")
			 query.setParameter("likeUserName", userName);
		 List<Users> users = query.getResultList();
		 return users;
	 }
	 
	 public void save (Users user) {
		 Session session = sessionFactory.getCurrentSession();
		 session.saveOrUpdate(user);
	 }
	 
	 
	 public Users getOne(int userId){
		 Session session = sessionFactory.getCurrentSession();
		 Users user=new Users();
		 user =  (Users) session.get(Users.class, userId);		 
		 return user;
	 }
	 
	 public Users findByUserName(String userName){
		 Session session = sessionFactory.getCurrentSession();
		 String queryStr="FROM Users u join fetch u.roles WHERE u.status != 2 AND u.userName=:userName ";
		 Query<Users> query = session.createQuery(queryStr, Users.class);
		 query.setParameter("userName", userName);
		 Users user=new Users();
		 user = query.uniqueResult();		 
		 return user;
	 }
	 
	 public Users updateStatus(int userId,int status) {
		 Users user = new Users();
		 try {
			 Session session = sessionFactory.getCurrentSession();
			  user =  (Users) session.get(Users.class, userId);
			  user.setStatus(status);
			  session.update(user);
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 return user;
	 }
	 
}
