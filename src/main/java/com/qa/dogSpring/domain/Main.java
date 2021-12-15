package com.qa.dogSpring.domain;

//import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


//Use of @Entity as below is for generating a table

	@Entity
	public class Main {

		
//Use of @Id denotes the field is the Primary key as in MqSQL
//Use of @GeneratedValue denotes auto-increment - only usable for an integer
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    
//Use of @Column as below denotes a column in a table
	    
	    @Column(unique = true, nullable = false)
	    private String username;

	    @Column(nullable = false) 
//	    @NotNull(message = "Give the password here")
	    private String password;

	    @Column
	    private String firstName;

	    @Column
	    private String lastName;

	     
	   
	    @Column
	   
	    private int Age;

	    // Default constructor
	    public Main() {
	        super();
	    }

	    public Main(String username, String password, String firstName, String lastName, int Age) {
	        super();
	        this.username = username;
	        this.password = password;
	        this.firstName = firstName;
	        this.lastName = lastName;
	       
	        this.Age =Age;
	    }

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		

		public int getAge() {
			return Age;
		}

		public void setAge(int age) {
			Age = age;
		}

		@Override
		public int hashCode() {
			return Objects.hash(Age, firstName, id, lastName, password, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Main other = (Main) obj;
			return Age == other.Age && Objects.equals(firstName, other.firstName)
					&& id == other.id && Objects.equals(lastName, other.lastName)
					&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
		}

		@Override
		public String toString() {
			return "Main [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", Age=" + Age + "]";
		}

	    

	}



	
	

