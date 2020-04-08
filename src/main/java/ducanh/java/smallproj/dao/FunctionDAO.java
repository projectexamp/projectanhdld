package ducanh.java.smallproj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ducanh.java.smallproj.model.Functions;
@Repository
@Transactional(rollbackFor = Exception.class)
public class FunctionDAO {
	 @Autowired
	  private SessionFactory sessionFactory;
	 public List<Functions> search (String functionName){
		 Session session = sessionFactory.getCurrentSession();
		 String queryStr="FROM Functions f WHERE f.status != 2";
		 if(functionName!=null && functionName !="")
			 {
			 queryStr="FROM Functions f WHERE f.status != 2 AND f.functionName LIKE concat('%',:likeFunctionName,'%')";
			 }
		 Query<Functions> query = session.createQuery(queryStr, Functions.class);
		 if(functionName!=null && functionName !="")
			 query.setParameter("likeFunctionName", functionName);
		 List<Functions> functions = query.getResultList();
		 return functions;
	 }
	 
	 public void save (Functions function) {
		 Session session = sessionFactory.getCurrentSession();
		 session.saveOrUpdate(function);
	 }
	 
	 
	 public Functions getOne(int functionId){
		 Session session = sessionFactory.getCurrentSession();
		 Functions function=new Functions();
		 function =  (Functions) session.get(Functions.class, functionId);		 
		 return function;
	 }
	 

	 public Functions updateStatus(int functionId,int status) {
		 Functions function = new Functions();
		 try {
			 Session session = sessionFactory.getCurrentSession();
			  function =  (Functions) session.get(Functions.class, functionId);
			  function.setStatus(status);
			  session.update(function);
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 return function;
	 }
}
