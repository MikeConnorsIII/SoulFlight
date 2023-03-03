package com.codingdojo.SoulFlights.models;

import java.util.Date;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "flights")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@NotNull
	@Size(min = 5, max = 200, message = "From city name must be at least 3 characters")
	private String fromCity;

	@NotNull
	@Size(min = 5, max = 200, message = "To city name must be at least 3 characters")
	private String toCity;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departDate;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;

	@NotNull
	@Min(1)
	private Integer adult;

	@NotNull
	@Min(0)
	private Integer child;

	@NotNull
	@Min(0)
	private Integer infant;

//	@NotNull
//	@Min(0)
	private Integer price;

	@NotNull
	@Size(min = 5, max = 200, message = "Cabin name must be at least 3 characters")
	private String cabin;

	// JOIN
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User flyer;

	// CONSTRUCTOR
	public Flight() {
	}

	public Flight(String fromCity, String toCity, Date departDate, Date returnDate, Integer adult, Integer child,
			Integer infant, Integer price, String cabin, User flyer) {
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
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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