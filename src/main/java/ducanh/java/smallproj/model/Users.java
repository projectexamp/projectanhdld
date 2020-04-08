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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "tbl_user")
public class Users implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	  public Users() {
		super();
	}
	  	 

	  @Id
	  @Column(name = "USER_ID")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name = "USER_NAME")
	  private String userName ;
	  
	  @Column(name = "FULL_NAME")
	  private String fullName ;
	  
	  @Column(name = "GENDER")
	  private int gender;
	  
	  @Column(name = "PASSWORD")
	  private String password;
	  
	  @Column(name = "SECRET_QUESTION")
	  private String secretQuestion;
	  
	  @Column(name = "SECRET_ANSWER")
	  private String secretAnswer;
	  
	  @Column(name = "EMAIL")
	  private String email;
	  
	  @Column(name = "STATUS")
	  private int status;
	  
	  
	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(
	            name = "tbl_role_user",
	            joinColumns = @JoinColumn(name = "USER_ID"),
	            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
	  )
	  private Set<Role> roles;
	  	  	  	
	  
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	  
	  
	
}
