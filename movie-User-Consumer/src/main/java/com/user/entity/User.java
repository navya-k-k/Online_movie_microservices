package com.user.entity;





public class User {

	
	
		

		
		
	    private Integer userId;
		
		private String username;
		private String password;
		private String email;
		private String firstname;
		private String lastname;
		private String phonenumber;
		private String address;
		private String role;

		
		
		
		
		
		public User(Integer userId, String username, String password, String email, String firstname, String lastname,
				String phonenumber, String address, String role) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
			this.email = email;
			this.firstname = firstname;
			this.lastname = lastname;
			this.phonenumber = phonenumber;
			this.address = address;
			this.role = role;
		}
		
		


		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		



		
	}
