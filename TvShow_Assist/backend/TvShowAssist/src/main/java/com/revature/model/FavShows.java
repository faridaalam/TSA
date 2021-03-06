package com.revature.model;
import javax.persistence.*;

@Entity
@Table(name = "FavShows")

public class FavShows {
	
	@Id
	@Column(name = "show_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sId;
	
	@Column(name = "show_name", nullable = false)
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "user_fk", nullable= false)
	private User userHolder;
	public FavShows() {
		
	}
	
	

	public FavShows(int sId, String name, User userHolder) {
		
		this.sId = sId;
		this.name = name;
		this.userHolder = userHolder;
		
		
	}
	
	public FavShows(String name, User userHolder) {
		super();
		this.name = name;
		this.userHolder = userHolder;
		
		
	}
	
	public FavShows(String name) {
		this.name = name;
	
	
	}
	
	public FavShows(User userHolder) {
		super();
		this.userHolder = userHolder;
	
	
	}
	
	
	public FavShows(int sId) {
		super();
		this.sId = sId;
	
	
	}
	
	
	


	public int getsId() {
		return sId;
	}



	public void setsId(int sId) {
		this.sId = sId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public User getUserHolder() {
		return userHolder;
	}



	public void setUserHolder(User userHolder) {
		this.userHolder = userHolder;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sId;
		result = prime * result + ((userHolder == null) ? 0 : userHolder.hashCode());
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
		FavShows other = (FavShows) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sId != other.sId)
			return false;
		if (userHolder == null) {
			if (other.userHolder != null)
				return false;
		} else if (!userHolder.equals(other.userHolder))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FavShows [sId=" + sId + ", name=" + name + ", userHolder=" + userHolder + "]";
	}

}