package com.tech.movie.pojo;
import org.hibernate.annotations.Proxy;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String account;
	private String password;
	private String name;
	private String email;
	private Integer age;
	private Integer sex;
	private String phone;
	private Integer role;

	public User() {
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public User(Integer id, String account, String password, String name, String email, Integer age, Integer sex, String phone, Integer role) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", age=" + age +
				", sex=" + sex +
				", phone='" + phone + '\'' +
				", role=" + role +
				'}';
	}
}