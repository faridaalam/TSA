package com.revature.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="U_NAME",nullable=false) 
	private String name;
	
	@Column(name="U_LASTNAME",nullable=false)
	private String lastName;
	
	@Column(name="EMAIL", unique=true, nullable=false)
	private String email;
	
	@Column(name="PASS_WORD",nullable=false)
	private String password;
	
	@Column(name="CITY", nullable=false)
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="userHolder", fetch = FetchType.EAGER)
	private List<FavShows>showList = new ArrayList<FavShows>();
	
	
	public User() {
		
	}


	public User(int id, String name, String lastName, String email, String password, String city,
			List<FavShows> showList) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.showList = showList;
	}
	
	public User(int id, String name, String lastName, String email, String password, String city) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.city = city;
	}
	
	public User( String name, String lastName, String email, String password, String city) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.city = city;
	}
	
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((showList == null) ? 0 : showList.hashCode());
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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
		if (showList == null) {
			if (other.showList != null)
				return false;
		} else if (!showList.equals(other.showList))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", city=" + city + ", showList=" + showList + "]";
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


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public List<FavShows> getShowList() {
		return showList;
	}


	public void setShowList(List<FavShows> showList) {
		this.showList = showList;
	}

}