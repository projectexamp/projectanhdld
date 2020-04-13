package ducanh.java.smallproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_role_function")
public class Permission {
	  @Id
	  @Column(name = "ROLE_FUNCTION_ID")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  @Column(name = "FUNCTION_ID")
	  private int functionId;
	  @Column(name = "ROLE_ID")
	  private int roleId;
	  @Column(name = "IS_ACTIVE")
	  private int status;
	public Permission() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	  
	  
}
