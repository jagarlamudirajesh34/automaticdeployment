package com.test.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(name="mobile", unique = true, nullable = false)
	private String mobile;
	
	@Column(name = "mail", nullable=false)
	private String mail;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="created_date", nullable=false)
	private Date createdDate;
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	@Column(name="deleted_yn", nullable=false)
	private Boolean deletedYn;
	
	@ManyToOne
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;
	
	public User(){
		super();
	}
	
	public User(User user){
		super();
		this.id = user.id;
		this.mail = user.mail;
		this.password = user.password;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.mobile = user.mobile;
		this.createdDate = user.createdDate;
		this.updatedDate = user.updatedDate;
		this.deletedYn = user.deletedYn;
		this.userRole = user.userRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Boolean getDeletedYn() {
		return deletedYn;
	}

	public void setDeletedYn(Boolean deletedYn) {
		this.deletedYn = deletedYn;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + mail + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobile=" + mobile + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", deletedYn=" + deletedYn + ", userRole=" + userRole + "]";
	}

}
