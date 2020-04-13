package ducanh.java.smallproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_role_user")
public class Permit {
	  @Id
	  @Column(name = "ROLE_USER_ID")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  @Column(name = "USER_ID")
	  private int userId;
	  @Column(name = "ROLE_ID")
	  private int roleId;
	  @Column(name = "IS_ACTIVE")
	  private int status;
	public Permit() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
