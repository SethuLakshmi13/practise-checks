package com.cognizant.movie.model;

import java.util.Set;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id", columnDefinition = "INT")
	private long id;
	@NotNull
	@Column(name = "us_name")
	private String userName;
	@NotNull
	@Column(name = "us_first_name")
	private String firstName;
	@NotNull
	@Column(name = "us_last_name")
	private String lastName;
	@Column(name = "us_password")
	@NotNull
	@Size(min = 3, message = "Length should be between 3 to 8 characters")
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "fa_us_id"), inverseJoinColumns = @JoinColumn(name = "fa_mo_id"))
	private Set<Movies> movieList;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;

	public Users() {

	}

	public Users(long id, @NotNull String userName, @NotNull String firstName, @NotNull String lastName,
			@NotNull @Size(min = 3, message = "Length should be between 3 to 8 characters") String password,
			Set<Movies> movieList, Set<Role> roleList) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.movieList = movieList;
		this.roleList = roleList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<Movies> movieList) {
		this.movieList = movieList;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", movieList=" + movieList + ", roleList=" + roleList + "]";
	}

}
