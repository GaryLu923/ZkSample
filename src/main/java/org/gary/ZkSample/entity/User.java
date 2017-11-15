package org.gary.ZkSample.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	private String name;
	private String email;
	private String password;
	private boolean female;
	private Date birthday;

	@Id @GeneratedValue(
			strategy = GenerationType.AUTO) private Integer id;

	public User() {

	}

	public User(String name, String email, String password, boolean female, Date birthday) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.female = female;
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public boolean isFemale() {
		return female;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFemale(boolean female) {
		this.female = female;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
