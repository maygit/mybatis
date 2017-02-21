package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private int id; 
	private String name;
	private String password;
	private int age;
	private String email;
	private boolean gender;
	private Date birth;
	private Address address;
	private List<Account> account=new ArrayList<Account>();
	public User() {
		super();
	}
	
	
	

	public List<Account> getAccount() {
		return account;
	}




	public void setAccount(List<Account> account) {
		this.account = account;
	}




	public User(int id, String name, String password, int age, String email,
			boolean gender, Date birth, Address address, List<Account> account) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
		this.account = account;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public User(int id, String name, String password, int age) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
	}


	public User(int id, String name, String password, int age, String email,
			boolean gender, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public User(int id, String name, String password, int age, String email,
			boolean gender, Date birth, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (gender ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", age=" + age + ", email=" + email + ", gender=" + gender
				+ ", birth=" + birth + ", address=" + address + ", account="
				+ account + "]";
	}


		
}
