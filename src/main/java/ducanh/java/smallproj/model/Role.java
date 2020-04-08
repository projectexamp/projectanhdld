package ducanh.java.smallproj.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
  	@Column(name = "ROLE_ID")
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@Column(name = "ROLE_CODE")
	private String roleCode;
	
	@Column(name = "ROLE_ORDER")
	private Integer roleOrder;
	
	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<Users> users;
	
	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(
	            name = "tbl_role_function",
	            joinColumns = @JoinColumn(name = "ROLE_ID"),
	            inverseJoinColumns = @JoinColumn(name = "FUNCTION_ID")
	  )
	  private Set<Functions> functions;

	public Role() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getRoleOrder() {
		return roleOrder;
	}

	public void setRoleOrder(Integer roleOrder) {
		this.roleOrder = roleOrder;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
	
}
