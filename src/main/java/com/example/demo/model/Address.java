package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address implements Serializable {

	@Id
	@Column(name = "a_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;

	@Column(name = "house_no")
	private Integer homeNo;

	private String city;
	private String district;

	@OneToOne
	@JoinColumn(name = "uid")
	@JsonIgnore
	private User user;

	public Address() {
		super();
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(Integer homeNo) {
		this.homeNo = homeNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Address(Integer addressId, String homeNo, String city, String district, User user) {
//		super();
//		this.addressId = addressId;
//		this.homeNo = homeNo;
//		this.city = city;
//		this.district = district;
//		this.user = user;
//	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", homeNo=" + homeNo + ", city=" + city + ", district=" + district
				+ "]";
	}

}
