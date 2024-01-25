package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Long id;
	
	private String userName;
	
	private String name;
	private Integer age;
	private Double discount;
	
	@OneToOne(mappedBy ="user", cascade = CascadeType.ALL)
	private Address address;
	
	public User() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long userId) {
		this.id = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	    if (address != null) {
	        address.setUser(this);
	    }
		
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", userName=" + userName + ", name=" + name + ", age=" + age + ", discount="
				+ discount + ", address=" + address + "]";
	}

	
}
