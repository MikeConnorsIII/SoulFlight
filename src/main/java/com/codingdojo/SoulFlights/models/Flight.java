package com.codingdojo.SoulFlights.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "flights")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 200, message = "From city name must be at least 3 characters")
	private String fromCity;
	
	@NotNull
	@Size(min = 5, max = 200, message = "To city name must be at least 3 characters")
	private String toCity;
	
	@NotNull
	@Size(min = 5, max = 200, message = "Depart date name must be at least 3 characters")
	private Date departDate;
	
	@NotNull
	@Size(min = 5, max = 200, message = "Return date name must be at least 3 characters")
	private Date returnDate;
	
	@NotNull
	@Size(min = 1, max = 200, message = "Amount of Adults must be above 0")
	private Integer adult;
	
	@NotNull
	@Size(min = 0, max = 200, message = "Amount of children required")
	private Integer child;
	
	@NotNull
	@Size(min = 0, max = 200, message = "Amount of infants required")
	private Integer infant;
	
	@NotNull
	@Size(min = 0, max = 5000, message = "Price name must be at least 3 characters")
	private Integer price;
	
	@NotNull
	@Size(min = 5, max = 200, message = "Cabin name must be at least 3 characters")
	private String cabin;
	
	
	
	//count of collaborations for black belt
	
	// ----------Many toCity one--------

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "flyer_id")
		private User flyer;

		// ----------Many toCity one--------
//		@ManyToMany(fetch = FetchType.LAZY)
//	    @JoinTable(
//	        name = "users_flights", 
//	        joinColumns = @JoinColumn(name = "song_Id"), 
//	        inverseJoinColumns = @JoinColumn(name = "user_Id")
//	    )
		
		private List<User> users;
		
//		
		
		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		public Flight() {
		}
		
		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		
		

		public Flight(Long id,
				@NotNull @Size(min = 5, max = 200, message = "From city name must be at least 3 characters") String fromCity,
				@NotNull @Size(min = 5, max = 200, message = "To city name must be at least 3 characters") String toCity,
				@NotNull @Size(min = 5, max = 200, message = "Depart date name must be at least 3 characters") Date departDate,
				@NotNull @Size(min = 5, max = 200, message = "Return date name must be at least 3 characters") Date returnDate,
				@NotNull @Size(min = 1, max = 200, message = "Amount of Adults must be above 0") Integer adult,
				@NotNull @Size(min = 0, max = 200, message = "Amount of children required") Integer child,
				@NotNull @Size(min = 0, max = 200, message = "Amount of infants required") Integer infant,
				@NotNull @Size(min = 0, max = 5000, message = "Price name must be at least 3 characters") Integer price,
				@NotNull @Size(min = 5, max = 200, message = "Cabin name must be at least 3 characters") String cabin,
				User flyer, List<User> users, Date createdAt, Date updatedAt) {
			super();
			this.id = id;
			this.fromCity = fromCity;
			this.toCity = toCity;
			this.departDate = departDate;
			this.returnDate = returnDate;
			this.adult = adult;
			this.child = child;
			this.infant = infant;
			this.price = price;
			this.cabin = cabin;
			this.flyer = flyer;
			this.users = users;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFromCity() {
			return fromCity;
		}

		public void setFromCity(String fromCity) {
			this.fromCity = fromCity;
		}

		public String getToCity() {
			return toCity;
		}

		public void setToCity(String toCity) {
			this.toCity = toCity;
		}

		public Date getDepartDate() {
			return departDate;
		}

		public void setDepartDate(Date departDate) {
			this.departDate = departDate;
		}

		public Date getReturnDate() {
			return returnDate;
		}

		public void setReturnDate(Date returnDate) {
			this.returnDate = returnDate;
		}

		public Integer getAdult() {
			return adult;
		}

		public void setAdult(Integer adult) {
			this.adult = adult;
		}

		public Integer getChild() {
			return child;
		}

		public void setChild(Integer child) {
			this.child = child;
		}

		public Integer getInfant() {
			return infant;
		}

		public void setInfant(Integer infant) {
			this.infant = infant;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public String getCabin() {
			return cabin;
		}

		public void setCabin(String cabin) {
			this.cabin = cabin;
		}

		public User getFlyer() {
			return flyer;
		}

		public void setFlyer(User flyer) {
			this.flyer = flyer;
		}
		
		
		
		
		
		
		
		
		
}