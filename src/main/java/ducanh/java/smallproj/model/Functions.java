package ducanh.java.smallproj.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_function")
public class Functions implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	  @Id
	  @Column(name = "FUNCTION_ID")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name = "FUNCTION_NAME")
	  private String functionName;
	  
	  @Column(name = "FUNCTION_CODE")
	  private String functionCode;
	  
	  @Column(name = "DESCRIPTION")
	  private String description;
	  
	  @Column(name = "FUNCTION_URL")
	  private String functionUrl;
	  
	  @Column(name = "FUNCTION_ORDER")
	  private Integer functionOrder;
	  
	  @Column(name = "STATUS")
	  private Integer status;
	  
	  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "functions")
	  private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFunctionUrl() {
		return functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public Integer getFunctionOrder() {
		return functionOrder;
	}

	public void setFunctionOrder(Integer functionOrder) {
		this.functionOrder = functionOrder;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	  
	  
}
