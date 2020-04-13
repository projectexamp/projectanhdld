package ducanh.java.smallproj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ducanh.java.smallproj.model.Permission;
import ducanh.java.smallproj.model.Permit;
import ducanh.java.smallproj.model.Users;

@Repository
@Transactional(rollbackFor = Exception.class)
public class AuthorizationDAO {
	 @Autowired
	  private SessionFactory sessionFactory;
	 	public Boolean checkExistPermit(int userId,int roleId) {
			Session session = sessionFactory.getCurrentSession();
			String queryStr="select count(p) from Permit p where p.userId=:userId and p.roleId=:roleId";
			Query<Integer> query = session.createQuery(queryStr, Integer.class);
			query.setParameter("userId", userId);
			query.setParameter("roleId", roleId);
			Integer count=query.uniqueResult();
			if (count==0)
				return false;
				else
				return true;
	 	}
	 	
	 	public Boolean checkExistPermission(int functionId,int roleId) {
			Session session = sessionFactory.getCurrentSession();
			String queryStr="select count(p) from Permisstion p where p.functionId=:functionId and p.roleId=:roleId";
			Query<Integer> query = session.createQuery(queryStr, Integer.class);
			query.setParameter("functionId", functionId);
			query.setParameter("roleId", roleId);
			Integer count=query.uniqueResult();
			if (count==0)
				return false;
				else
				return true;
	 	}
	 	
	 	public void addPermit(int userId,int roleId) {
	 		Session session = sessionFactory.getCurrentSession();
	 		if(!checkExistPermit(userId,roleId)) {
	 			Permit permit = new Permit();
	 			permit.setUserId(userId);
	 			permit.setRoleId(roleId);
	 			permit.setStatus(1);
	 			session.save(permit);
	 		}
	 		else {
				Query<Permit> query = session.createQuery("select from Permit p where p.userId=:userId and p.roleId=:roleId",Permit.class);
				query.setParameter("userId", userId);
				query.setParameter("roleId", roleId);
				Permit permit = query.uniqueResult();
				permit.setStatus(1);
				session.update(permit);
	 		}
	 	}
	 	
	 	public void addPermision(int functionId,int roleId) {
	 		Session session = sessionFactory.getCurrentSession();
	 		if(!checkExistPermission(functionId,roleId)) {
	 			Permission permission = new Permission();
	 			permission.setFunctionId(functionId);
	 			permission.setRoleId(roleId);
	 			permission.setStatus(1);
	 			session.save(permission);
	 		}
	 		else {
				Query<Permission> query = session.createQuery("select from Permisstion p where p.functionId=:functionId and p.roleId=:roleId",Permission.class);
				query.setParameter("functionId", functionId);
				query.setParameter("roleId", roleId);
				Permission permission = query.uniqueResult();
				permission.setStatus(1);
				session.update(permission);
	 		}
	 	}
}
